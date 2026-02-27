package dk.mosberg.client.hud;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class HudManager {
  public final int hudUpdateTime = 40; // ticks
  private final Map<String, Hud> huds = new HashMap<>();
  private boolean hudEnabled = true;
  private KeyBinding toggleKey;

  public HudManager() {
    loadHuds();
    registerKeys();
  }

  private void loadHuds() {
    // Hardcoded for villager professions (add json config later)
    huds.put("vp_profession", new Hud(
        "Villager: %profession% - Trades: %trades%",
        "minecraft:default", "vp.hud", false, true, false));
  }

  private void registerKeys() {
    toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.vp.hud_toggle",
        InputUtil.Type.KEYSYM,
        InputUtil.GLFW_KEY_H,
        KeyBinding.Category.MISC));

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      // Toggle key handling
      while (toggleKey.wasPressed()) {
        hudEnabled = !hudEnabled;
      }

      // Update HUD every hudUpdateTime ticks when enabled
      if (client.world != null && hudEnabled && client.world.getTime() % hudUpdateTime == 0) {
        HudTask.updatePlayerHud(client);
      }
    });
  }

  @Nullable
  public Hud getActiveHud(MinecraftClient client) {
    return getHuds().values().stream()
        .filter(Hud::isEnabledByDefault)
        .findFirst().orElse(null);
  }

  public Map<String, Hud> getHuds() {
    return huds;
  }

  public boolean isHudEnabled() {
    return hudEnabled;
  }
}
