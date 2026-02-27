package dk.mosberg.ai;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.ai.brain.task.MultiTickTask.Status;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.server.world.ServerWorld;

public class GoToBedTask implements Task<SwordVillagerEntity> {
  public GoToBedTask() {
  }

  @Override
  public String getName() {
    return "go_to_bed";
  }

  @Override
  public void tick(ServerWorld world, SwordVillagerEntity entity, long time) {
    return;
  }

  @Override
  public void stop(ServerWorld world, SwordVillagerEntity entity, long time) {
    // No-op for stub
  }

  @Override
  public Status getStatus() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
  }

  @Override
  public boolean tryStarting(ServerWorld world, SwordVillagerEntity entity, long time) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'tryStarting'");
  }

}
