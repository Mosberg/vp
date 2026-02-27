package dk.mosberg.ai;

import net.minecraft.entity.ai.brain.task.Task;
import dk.mosberg.entity.SwordVillagerEntity;

public class SocializeAtMeetingPointTask implements Task<SwordVillagerEntity> {
  public SocializeAtMeetingPointTask() {
  }

  @Override
  public boolean run(SwordVillagerEntity entity) {
    return true;
  }
}