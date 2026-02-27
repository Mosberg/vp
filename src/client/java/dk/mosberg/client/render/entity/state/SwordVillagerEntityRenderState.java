package dk.mosberg.client.render.entity.state;

import org.jspecify.annotations.Nullable;

import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.entity.state.VillagerDataRenderState;
import net.minecraft.village.VillagerData;

public class SwordVillagerEntityRenderState extends ArmedEntityRenderState implements VillagerDataRenderState {
  public boolean headRolling;
  @Nullable
  public VillagerData villagerData;

  @Nullable
  @Override
  public VillagerData getVillagerData() {
    return this.villagerData;
  }

  public SwordVillagerProfession getProfession() {
    if (this.villagerData == null) {
      return SwordVillagerProfession.NONE;
    }
    return SwordVillagerProfession.valueOf(this.villagerData.profession().getKey().toString());
  }
}
