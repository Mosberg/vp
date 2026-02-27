package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.ai.brain.task.Task;

public class GoToBedTask implements Task<SwordVillagerEntity> {
  public GoToBedTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}