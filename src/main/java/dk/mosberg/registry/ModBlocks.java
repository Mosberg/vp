
package dk.mosberg.registry;

import dk.mosberg.VP;
import dk.mosberg.block.GuardPostBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block GUARD_POST = registerBlock("guard_post",
      new GuardPostBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

  private static Block registerBlock(String name, Block block) {
    Identifier id = Identifier.of(VP.MOD_ID, name);
    Registry.register(Registries.BLOCK, id, block);
    Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
    return block;
  }

  public static void init() {
  }
}