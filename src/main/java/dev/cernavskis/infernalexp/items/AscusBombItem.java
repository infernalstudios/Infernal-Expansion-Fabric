package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.entities.AscusBombEntity;
import dev.cernavskis.infernalexp.entities.IEEntityTypes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AscusBombItem extends IEItemBase {
    public AscusBombItem() {
        super(new FabricItemSettings().maxCount(1));
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {
            AscusBombEntity ascusBombEntity = new AscusBombEntity(IEEntityTypes.ASCUS_BOMB, world);
            ascusBombEntity.updatePosition(user.getX(), user.getEyeY() - 0.10000000149011612D, user.getZ());
            ascusBombEntity.setItem(itemStack);
            ascusBombEntity.setProperties(user, user.pitch, user.yaw, -20, 0.5f, 1);
            world.spawnEntity(ascusBombEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        if (!user.abilities.creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}