package dk.mosberg.item;

import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ProfessionBadgeItem extends Item {

  private final SwordVillagerProfession profession;

  public ProfessionBadgeItem(Settings settings, SwordVillagerProfession profession) {
    super(settings);
    this.profession = profession;
  }

  @Override
  public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
    World world = user.getWorld();
    if (!world.isClient && entity instanceof SwordVillagerEntity villager) {
      villager.setProfession(profession);
      if (!user.isCreative()) {
        stack.decrement(1);
      }
      return ActionResult.SUCCESS;
    }
    return ActionResult.PASS;
  }
}
