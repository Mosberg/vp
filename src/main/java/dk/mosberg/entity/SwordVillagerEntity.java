package dk.mosberg.entity;

import java.util.List;

import dk.mosberg.profession.SwordVillagerProfession;
import dk.mosberg.registry.ModBlocks;
import dk.mosberg.registry.ModProfessions;
import dk.mosberg.trade.SwordVillagerTrades;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SwordVillagerEntity extends PathAwareEntity {

  private static final TrackedData<Integer> PROFESSION = DataTracker.registerData(SwordVillagerEntity.class,
      TrackedDataHandlerRegistry.INTEGER);

  public SwordVillagerEntity(EntityType<? extends SwordVillagerEntity> type, World world) {
    super(type, world);
  }

  public static DefaultAttributeContainer.Builder createAttributes() {
    return MobEntity.createMobAttributes()
        .add(EntityAttributes.MAX_HEALTH, 24.0)
        .add(EntityAttributes.MOVEMENT_SPEED, 0.35)
        .add(EntityAttributes.ATTACK_DAMAGE, 5.0)
        .add(EntityAttributes.FOLLOW_RANGE, 24.0);
  }

  @Override
  protected void initDataTracker() {
    super.initDataTracker(this);
    this.dataTracker.startTracking(PROFESSION, SwordVillagerProfession.NONE.ordinal());
  }

  public SwordVillagerProfession getProfession() {
    return SwordVillagerProfession.fromId(this.dataTracker.get(PROFESSION));
  }

  public void setProfession(SwordVillagerProfession profession) {
    this.dataTracker.set(PROFESSION, profession.ordinal());
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(1, new MeleeAttackGoal(this, 1.1, true));
    this.goalSelector.add(2, new WanderAroundGoal(this, 0.8));
    this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
    this.goalSelector.add(4, new LookAroundGoal(this));

    this.targetSelector.add(1, new RevengeGoal(this));
    this.targetSelector.add(2, new ActiveTargetGoal<LivingEntity>(this, Monster.class, true));
  }

  @Override
  protected void initEquipment(Random random, float difficulty) {
    this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
  }

  @Override
  public void tick() {
    super.tick();

    BlockPos pos = this.getBlockPos();
    BlockState state = this.getEntityWorld().getBlockState(pos.down());
    if (state.isOf(ModBlocks.GUARD_POST)) {
      this.setProfession(SwordVillagerProfession.GUARD);
    }

    if (!this.getEntityWorld().isClient()) {
      ModProfessions.tickJobsiteCheck(this);
    }

    if (!this.getEntityWorld().isClient()) {
      switch (getProfession()) {
        case CAPTAIN -> applyCaptainAura();
        case BLADEMASTER -> applyBlademasterPassive();
        default -> {
        }
      }
    }

  }

  private void applyCaptainAura() {
    Box box = this.getBoundingBox().expand(6.0);
    List<SwordVillagerEntity> allies = this.getEntityWorld().getEntitiesByClass(
        SwordVillagerEntity.class, box, e -> e != this);
    for (SwordVillagerEntity ally : allies) {
      ally.setVelocity(ally.getVelocity().add(0, 0.01, 0));
    }
  }

  private void applyBlademasterPassive() {
    if (this.age % 40 == 0) {
      this.heal(1.0F);
    }
  }

  @Override
  public boolean tryAttack(net.minecraft.server.world.ServerWorld world, Entity target) {
    boolean hit = super.tryAttack(world, target);
    if (!hit)
      return false;

    SwordVillagerProfession prof = getProfession();
    DamageSource source = this.getDamageSources().mobAttack(this);

    switch (prof) {
      case GUARD -> target.damage(world, source, 2.0F);
      case CAPTAIN -> {
        if (target instanceof LivingEntity living) {
          living.takeKnockback(0.6F, this.getX() - target.getX(), this.getZ() - target.getZ());
        }
      }
      case BLADEMASTER -> dashStrike(world, target);
      default -> {
      }
    }

    return true;
  }

  private void dashStrike(net.minecraft.server.world.ServerWorld world, Entity target) {
    Vec3d dir = new Vec3d(target.getX() - this.getX(), target.getY() - this.getY(), target.getZ() - this.getZ())
        .normalize().multiply(1.2);
    this.setVelocity(dir.x, 0.2, dir.z);
    target.damage(world, this.getDamageSources().mobAttack(this), 4.0F);
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    if (!this.getEntityWorld().isClient() && hand == Hand.MAIN_HAND) {
      SwordVillagerTrades.openTrades(this, player);
      return ActionResult.SUCCESS;
    }
    return super.interactMob(player, hand);
  }

  // Remove incorrect Brain overrides for now (Yarn 1.21.11 may use
  // Datafixer/BrainProvider)
}
