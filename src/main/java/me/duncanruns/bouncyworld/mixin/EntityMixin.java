package me.duncanruns.bouncyworld.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    public abstract boolean isSneaking();

    @Shadow public abstract String toString();

    @Inject(at = @At("RETURN"), method = "getJumpVelocityMultiplier", cancellable = true)
    private void getJumpVelocityMultiplierMixin(CallbackInfoReturnable<Float> info) {
        if((Object) this instanceof PlayerEntity && !this.isSneaking()){
            info.setReturnValue(info.getReturnValueF()*4.1f);
        }
    }
}
