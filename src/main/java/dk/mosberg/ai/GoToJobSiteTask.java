package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.ai.brain.task.Task;

public class GoToJobSiteTask implements Task<SwordVillagerEntity> {
  public GoToJobSiteTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}