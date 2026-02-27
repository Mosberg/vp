package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.ai.brain.task.Task;

public class SleepTask implements Task<SwordVillagerEntity> {
  public SleepTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}