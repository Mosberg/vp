package dk.mosberg.trade;

import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class SwordVillagerTrades {

  public static void openTrades(SwordVillagerEntity villager, PlayerEntity player) {
    SwordVillagerProfession prof = villager.getProfession();

    switch (prof) {
      case GUARD -> sendGuardTrades(player);
      case CAPTAIN -> sendCaptainTrades(player);
      case BLADEMASTER -> sendBlademasterTrades(player);
      default -> player.sendMessage(Text.literal("This villager has no profession."), false);
    }
  }

  private static void sendGuardTrades(PlayerEntity player) {
    player.sendMessage(Text.literal("GUARD trades: 5 emeralds -> 1 iron sword"), false);
    player.giveItemStack(new ItemStack(Items.EMERALD, 1));
  }

  private static void sendCaptainTrades(PlayerEntity player) {
    player.sendMessage(Text.literal("CAPTAIN trades: 10 emeralds -> 1 shield"), false);
  }

  private static void sendBlademasterTrades(PlayerEntity player) {
    player.sendMessage(Text.literal("BLADEMASTER trades: 20 emeralds -> 1 diamond sword"), false);
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    if (!this.getWorld().isClient) {
      SwordVillagerTrades.applyTrades(this, player);
    }
    return ActionResult.SUCCESS;
  }

}
