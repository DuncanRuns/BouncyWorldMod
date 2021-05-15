package me.duncanruns.bouncyworld.mixin;

import me.duncanruns.bouncyworld.BouncyWorld;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Block.class)
public class BlockMixin {

    /**
     * @author Duncanruns
     */
    @Overwrite
    public void onEntityLand(BlockView world, Entity entity) {
        if(entity.isSneaking()) {
            entity.setVelocity(entity.getVelocity().multiply(1.0D, 0.0D, 1.0D));
        }else{
            this.bounce(entity);
        }
    }

    /**
     * @author DuncanRuns
     */
    @Overwrite
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        if (entity.isSneaking()) {
            entity.handleFallDamage(distance, BouncyWorld.shouldDoFallDamage ? 1.0F : 0.0f);
        } else {
            entity.handleFallDamage(distance, 0.0F);
        }
    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }
    }
}
