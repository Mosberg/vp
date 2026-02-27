package dk.mosberg.client.render;

import java.util.EnumMap;
import java.util.Map;

import dk.mosberg.VP;
import dk.mosberg.client.render.entity.model.ModModelLayers;
import dk.mosberg.client.render.entity.model.SwordVillagerEntityModel;
import dk.mosberg.client.render.entity.state.SwordVillagerEntityRenderState;
import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class SwordVillagerRenderer
    extends MobEntityRenderer<SwordVillagerEntity, SwordVillagerEntityRenderState, SwordVillagerEntityModel> {

  private static final Map<SwordVillagerProfession, Identifier> TEXTURES = new EnumMap<>(SwordVillagerProfession.class);

  static {
    TEXTURES.put(SwordVillagerProfession.NONE, Identifier.of(VP.MOD_ID, "textures/entity/sword_villager/none.png"));
    TEXTURES.put(SwordVillagerProfession.GUARD, Identifier.of(VP.MOD_ID, "textures/entity/sword_villager/guard.png"));
    TEXTURES.put(SwordVillagerProfession.CAPTAIN,
        Identifier.of(VP.MOD_ID, "textures/entity/sword_villager/captain.png"));
    TEXTURES.put(SwordVillagerProfession.BLADEMASTER,
        Identifier.of(VP.MOD_ID, "textures/entity/sword_villager/blademaster.png"));
  }

  public SwordVillagerRenderer(EntityRendererFactory.Context ctx) {
    super(ctx, new SwordVillagerEntityModel(ctx.getPart(ModModelLayers.SWORD_VILLAGER)), 0.5f);
    this.addFeature(new HeldItemFeatureRenderer<>(this));
  }

  public Identifier getTexture(SwordVillagerEntity entity) {
    return TEXTURES.getOrDefault(entity.getProfession(), TEXTURES.get(SwordVillagerProfession.NONE));
  }

  public Identifier getTexture(SwordVillagerEntityModel model) {
    // Fallback to NONE texture as model does not provide profession context
    return TEXTURES.get(SwordVillagerProfession.NONE);
  }

  @Override
  public Identifier getTexture(SwordVillagerEntityRenderState state) {
    // If state provides profession, use it; otherwise fallback to NONE
    SwordVillagerProfession profession = state.getProfession();
    if (profession == null) {
      profession = SwordVillagerProfession.NONE;
    }
    return TEXTURES.getOrDefault(profession, TEXTURES.get(SwordVillagerProfession.NONE));
  }

  @Override
  public SwordVillagerEntityRenderState createRenderState() {
    // Provide a default instance or customize as needed
    return new SwordVillagerEntityRenderState();
  }
}
