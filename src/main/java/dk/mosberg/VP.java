package dk.mosberg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mosberg.registry.ModBlocks;
import dk.mosberg.registry.ModEntities;
import dk.mosberg.registry.ModItems;
import dk.mosberg.registry.ModProfessions;
import dk.mosberg.registry.ModTrades;
import net.fabricmc.api.ModInitializer;

public class VP implements ModInitializer {
  public static final String MOD_ID = "vp";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    ModEntities.init();
    ModItems.init();
    ModBlocks.init();
    ModProfessions.init();
    ModTrades.init();

    LOGGER.info("[VP] Villager Professions initialized.");
  }
}