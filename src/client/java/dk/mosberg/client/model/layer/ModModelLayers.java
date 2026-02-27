package dk.mosberg.client.model.layer;

import dk.mosberg.VP;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
  public static final EntityModelLayer SWORD_VILLAGER = new EntityModelLayer(
      new Identifier(VP.MOD_ID, "sword_villager"), "main");
}