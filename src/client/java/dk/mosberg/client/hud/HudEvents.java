package dk.mosberg.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

public class HudEvents implements HudRenderCallback {
  public static Text renderText = null;

  public static void enableHud(MinecraftClient client, Hud hud) {
    renderText = Text.literal(hud.getDisplayText());
  }

  public static void updateHud(MinecraftClient client, Hud hud) {
    enableHud(client, hud);
  }

  @Override
  public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
    MinecraftClient client = MinecraftClient.getInstance();
    if (renderText == null || client.options.hudHidden || client.player == null) {
      return;
    }

    // Bottom center action bar position
    int width = client.textRenderer.getWidth(renderText);
    int screenWidth = client.getWindow().getScaledWidth();
    int x = (screenWidth - width) / 2;
    int y = client.getWindow().getScaledHeight() - 30;
    drawContext.drawText(client.textRenderer, renderText, x, y, 0xFFFFFF, true);
  }
}
