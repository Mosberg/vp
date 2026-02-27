package dk.mosberg.registry;

import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModProfessions {
  public static void tickJobsiteCheck(SwordVillagerEntity villager) {
    World world = villager.getEntityWorld();
    BlockPos pos = villager.getBlockPos();
    BlockState below = world.getBlockState(pos.down());
    if (below.isOf(ModBlocks.GUARD_POST)) {
      villager.setProfession(SwordVillagerProfession.GUARD);
    }
  }

  public static void init() {
  }
}