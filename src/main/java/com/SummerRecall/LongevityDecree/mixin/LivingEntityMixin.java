package com.SummerRecall.LongevityDecree.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = {"checkTotemDeathProtection"}, at = {@At("HEAD")}, cancellable = true)
    private void checkTotemDeathProtection(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        System.out.println("AAAA");
        LivingEntity livingEntity = ((LivingEntity)(Object)this);
        if (livingEntity instanceof ServerPlayer player) {
            ItemStack itemStack = null;
            Inventory inventory = player.getInventory();
            //在背包中找到我们的物品
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                ItemStack stack = inventory.getItem(i);
                if (stack.getItem().equals(Items.DIAMOND)) {
                    itemStack = stack;
                    break;
                }
            }
            if (itemStack != null) {
                player.awardStat(Stats.ITEM_USED.get(Items.DIAMOND));
                CriteriaTriggers.USED_TOTEM.trigger(player, itemStack);
                itemStack.shrink(1);
                player.setHealth(10.0F);
                player.removeAllEffects();
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
                player.level.broadcastEntityEvent(player, (byte) 35);
                info.setReturnValue(true);
            }
        }
    }
}
