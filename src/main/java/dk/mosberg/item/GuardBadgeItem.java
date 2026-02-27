package dk.mosberg.item;

import dk.mosberg.entity.SwordVillagerEntity;
import dk.mosberg.profession.SwordVillagerProfession;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GuardBadgeItem extends Item {

  public GuardBadgeItem(Settings settings) {
    super(settings);
  }

  @Override
  public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
    if (entity instanceof SwordVillagerEntity villager) {
      villager.setProfession(SwordVillagerProfession.GUARD);

      if (!player.isCreative()) {
        stack.decrement(1);
      }

      player.sendMessage(Text.literal("Profession set to GUARD"), true);
      return ActionResult.SUCCESS;
    }
    return ActionResult.PASS;
  }
}
