package dev.cernavskis.infernalexp.entities;

import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IEEntityTypes {

    public static final EntityType<AscusBombEntity> ASCUS_BOMB = FabricEntityTypeBuilder.create(SpawnGroup.MISC, AscusBombEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build();
    
    public static void registerEntities() {
        register("ascus_bomb", ASCUS_BOMB);
        InfernalExpansion.LOGGER.info("Infernal Expansion: Entities Registered!");
    }
    
    public static EntityType<? extends Entity> register(String id, EntityType<? extends Entity> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(InfernalExpansion.MOD_ID, id), entityType);
    }
    
    public static void registerEntityAttributes() {
        
    }
    
}