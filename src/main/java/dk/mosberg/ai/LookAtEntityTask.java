package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.task.Task;

public class LookAtEntityTask implements Task<SwordVillagerEntity> {
  public LookAtEntityTask(EntityType<?> type, float range) {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}