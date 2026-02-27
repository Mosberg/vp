package dk.mosberg.ai;

import net.minecraft.entity.ai.brain.task.Task;
import dk.mosberg.entity.SwordVillagerEntity;

public class RandomStrollTask implements Task<SwordVillagerEntity> {
  public RandomStrollTask(float speed) {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}