package me.forestwolf99.more_repairables.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class RepairMixin {

    @Inject(method = {"canRepair"}, at = {@At("HEAD")}, cancellable = true)
    public void injectRepair(ItemStack stack, ItemStack ingredient, CallbackInfoReturnable<Boolean> cir) {
        if (
                (stack.isOf(Items.BOW) && ingredient.isOf(Items.STRING)) ||
                (stack.isOf(Items.CROSSBOW) && ingredient.isOf(Items.STRING)) ||
                (stack.isOf(Items.TRIDENT) && ingredient.isOf(Items.PRISMARINE_SHARD))
        ) {
            cir.setReturnValue(true);
        }
    }
}
