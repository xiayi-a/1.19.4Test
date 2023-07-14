package com.SummerRecall.LongevityDecree.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class LegSwing extends Entity {
    public LegSwing(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("HEAD") , method = "explodeCreeper", cancellable = true)
    public void explodeCreeper (CallbackInfo ci) {
        if (!this.level.isClientSide) {
            ci.cancel();
            this.level.explode(this, this.getX(), this.getY(), this.getZ(),6F, Level.ExplosionInteraction.NONE);
            this.discard();
            System.out.println("aaa");
        }
    }
}
