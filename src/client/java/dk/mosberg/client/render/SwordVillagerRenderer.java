package dk.mosberg.client.render;

import java.util.EnumMap;
import java.util.Map;

import dk.mosberg.VP;
import dk.mosberg.client.model.SwordVillagerEntityModel;
import dk.mosberg.client.model.layer.ModModelLayers;
import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class SwordVillagerRenderer extends MobEntityRenderer<SwordVillagerEntity, SwordVillagerEntityModel> {

  private static final Map<SwordVillagerProfession, Identifier> TEXTURES = new EnumMap<>(SwordVillagerProfession.class);

  static {
    TEXTURES.put(SwordVillagerProfession.NONE, new Identifier(VP.MOD_ID, "textures/entity/sword_villager/none.png"));
    TEXTURES.put(SwordVillagerProfession.GUARD, new Identifier(VP.MOD_ID, "textures/entity/sword_villager/guard.png"));
    TEXTURES.put(SwordVillagerProfession.CAPTAIN,
        new Identifier(VP.MOD_ID, "textures/entity/sword_villager/captain.png"));
    TEXTURES.put(SwordVillagerProfession.BLADEMASTER,
        new Identifier(VP.MOD_ID, "textures/entity/sword_villager/blademaster.png"));
  }

  public SwordVillagerRenderer(EntityRendererFactory.Context ctx) {
    super(ctx, new SwordVillagerEntityModel(ctx.getPart(ModModelLayers.SWORD_VILLAGER)), 0.5F);
    this.addFeature(new HeldItemFeatureRenderer<>(this, ctx.getHeldItemRenderer()));
  }

  @Override
  public Identifier getTexture(SwordVillagerEntity entity) {
    return TEXTURES.getOrDefault(entity.getProfession(), TEXTURES.get(SwordVillagerProfession.NONE));
  }
}
