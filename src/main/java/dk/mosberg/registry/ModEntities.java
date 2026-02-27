
package dk.mosberg.registry;

import dk.mosberg.VP;
import dk.mosberg.entity.SwordVillagerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntities {
  public static final EntityType<SwordVillagerEntity> SWORD_VILLAGER = Registry.register(Registries.ENTITY_TYPE,
      Identifier.of(VP.MOD_ID, "sword_villager"),
      FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SwordVillagerEntity::new)
          .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).trackRangeBlocks(32)
          .build(RegistryKey.of(Registries.ENTITY_TYPE, Identifier.of(VP.MOD_ID, "sword_villager"))));

  public static void init() {
    FabricDefaultAttributeRegistry.register(SWORD_VILLAGER, SwordVillagerEntity.createAttributes());
  }
}