package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.ai.brain.task.Task;

public class GoToMeetingPointTask implements Task<SwordVillagerEntity> {
  public GoToMeetingPointTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}