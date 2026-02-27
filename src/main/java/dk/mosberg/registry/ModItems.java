
package dk.mosberg.registry;

import dk.mosberg.VP;
import dk.mosberg.item.ProfessionBadgeItem;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  public static final Item GUARD_BADGE = register("guard_badge",
      new ProfessionBadgeItem(new Item.Settings(), SwordVillagerProfession.GUARD));

  public static final Item CAPTAIN_BADGE = register("captain_badge",
      new ProfessionBadgeItem(new Item.Settings(), SwordVillagerProfession.CAPTAIN));

  public static final Item BLADEMASTER_BADGE = register("blademaster_badge",
      new ProfessionBadgeItem(new Item.Settings(), SwordVillagerProfession.BLADEMASTER));

  private static Item register(String name, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(VP.MOD_ID, name), item);
  }

  public static void init() {
  }
}
