package dev.cernavskis.infernalexp.entities;

import dev.cernavskis.infernalexp.InfernalExpansionClient;
import dev.cernavskis.infernalexp.items.IEItems;
import dev.cernavskis.infernalexp.util.EntitySpawnPacket;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class AscusBombEntity extends ThrownItemEntity  {

    public AscusBombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        /*
        for (int i = 0; i < 16; i++) {
            this.world.addParticle(ModParticleTypes.INFECTION.get(), this.getPosXRandom(5), this.getPosYRandom(), this.getPosZRandom(5), 0, 0, 0);
        }
        */
        if (!this.world.isClient) {
            /*
            Entity entity = result.getType() == RayTraceResult.Type.ENTITY ? ((EntityRayTraceResult) result).getEntity() : null;

            AxisAlignedBB axisAlignedBB = this.getBoundingBox().grow(4, 2, 4);
            List<LivingEntity> livingEntities = this.world.getEntitiesWithinAABB(LivingEntity.class, axisAlignedBB);

            if (!livingEntities.isEmpty()) {
                for (LivingEntity livingEntity : livingEntities) {
                    double distanceSq = this.getDistanceSq(livingEntity);

                    if (distanceSq < 16) {
                        double durationMultiplier = 1 - Math.sqrt(distanceSq) / 4;

                        if (livingEntity == entity) {
                            durationMultiplier = 1;
                        }

                        int duration = (int) (durationMultiplier * 300 + 0.5);

                        livingEntity.addPotionEffect(new EffectInstance(ModEffects.INFECTION.get(), duration, 0, false, false));
                    }
                }
            }
            */
            this.remove();
        }
    }
    
    @Override
    protected Item getDefaultItem() {
        return IEItems.ASCUS_BOMB;
    }
    
    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, InfernalExpansionClient.PacketID);
    }

}
