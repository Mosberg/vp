package dk.mosberg.ai;

import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import dk.mosberg.entity.SwordVillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.SleepTask;

public class SwordVillagerAi {

  public static void setupTasks(Brain<SwordVillagerEntity> Brain) {

    Brain.setTaskList(Activity.IDLE, ImmutableList.of(
        Pair.of(0, new RandomStrollTask(0.6F)),
        Pair.of(1, new LookAtEntityTask(EntityType.PLAYER, 8.0F)),
        Pair.of(2, new SocializeAtMeetingPointTask())));

    Brain.setTaskList(Activity.WORK, ImmutableList.of(
        Pair.of(0, new GoToJobSiteTask()),
        Pair.of(1, new WorkAtJobSiteTask())));

    Brain.setTaskList(Activity.REST, ImmutableList.of(
        Pair.of(0, new GoToBedTask()),
        Pair.of(1, new SleepTask())));

    Brain.setTaskList(Activity.MEET, ImmutableList.of(
        Pair.of(0, new GoToMeetingPointTask()),
        Pair.of(1, new SocializeAtMeetingPointTask())));

    Brain.setCoreActivities(Set.of(Activity.IDLE, Activity.WORK, Activity.REST, Activity.MEET));
    Brain.setDefaultActivity(Activity.IDLE);
  }
}
