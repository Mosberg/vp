package dk.mosberg.ai;

import net.minecraft.entity.ai.brain.task.Task;
import dk.mosberg.entity.SwordVillagerEntity;

public class WorkAtJobSiteTask implements Task<SwordVillagerEntity> {
  public WorkAtJobSiteTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}