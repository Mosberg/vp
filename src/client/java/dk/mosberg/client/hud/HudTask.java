package dk.mosberg.client.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.hit.EntityHitResult;

public class HudTask {
  private static final HudManager manager = new HudManager();

  public static void updatePlayerHud(MinecraftClient client) {
    if (client.crosshairTarget == null || !(client.crosshairTarget instanceof EntityHitResult entityHit)) {
      HudEvents.renderText = null;
      return;
    }

    if (!(entityHit.getEntity() instanceof VillagerEntity villager)) {
      HudEvents.renderText = null;
      return;
    }

    Hud hud = manager.getActiveHud(client);
    if (hud == null || (hud.isDisabledWhilstInWater() && client.player.isSubmergedInWater())) {
      HudEvents.renderText = null;
      return;
    }

    // Replace placeholders with villager data
    if (hud != null) {
      String display = hud.getDisplayText()
          .replace("%profession%", villager.getVillagerData().profession().toString())
          .replace("%trades%", String.valueOf(villager.getOffers().size()));
      HudEvents.renderText = net.minecraft.text.Text.literal(display);
    } else {
      HudEvents.renderText = null;
    }
  }
}
