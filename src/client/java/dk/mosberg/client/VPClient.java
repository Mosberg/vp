package dk.mosberg.client;

import dk.mosberg.client.hud.HudEvents;
import dk.mosberg.client.hud.HudManager;
import dk.mosberg.client.render.SwordVillagerRenderer;
import dk.mosberg.client.render.entity.model.ModModelLayers;
import dk.mosberg.client.render.entity.model.SwordVillagerEntityModel;
import dk.mosberg.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class VPClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    HudEvents.EVENT.register(new HudEvents()); // Register HUD renderer
    new HudManager(); // Initialize manager + keybinds

    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SWORD_VILLAGER,
        SwordVillagerEntityModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.SWORD_VILLAGER, SwordVillagerRenderer::new);
  }
}
