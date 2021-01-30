package dev.cernavskis.infernalexp;

import java.util.UUID;

import dev.cernavskis.infernalexp.entities.AscusBombEntity;
import dev.cernavskis.infernalexp.entities.IEEntityTypes;
import dev.cernavskis.infernalexp.util.EntitySpawnPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("deprecation")
@Environment(EnvType.CLIENT)
public class InfernalExpansionClient implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(InfernalExpansion.MOD_ID, "spawn_packet");
    
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(
                IEEntityTypes.ASCUS_BOMB,
                (dispatcher, context) -> new FlyingItemEntityRenderer<AscusBombEntity>(dispatcher, context.getItemRenderer()));
        
        receiveEntityPacket();
    }

    @SuppressWarnings("resource")
    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                    if (MinecraftClient.getInstance().world == null)
                            throw new IllegalStateException("Tried to spawn entity in a null world!");
                    Entity e = et.create(MinecraftClient.getInstance().world);
                    if (e == null)
                            throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                    e.updateTrackedPosition(pos);
                    e.setPos(pos.x, pos.y, pos.z);
                    e.pitch = pitch;
                    e.yaw = yaw;
                    e.setEntityId(entityId);
                    e.setUuid(uuid);
                    MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }
    
}
