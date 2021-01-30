package dev.cernavskis.infernalexp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SlurpSoupItem extends IEItemBase {
    public SlurpSoupItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
       ItemStack itemstack = super.finishUsing(stack, world, entity);
       return entity instanceof PlayerEntity && ((PlayerEntity) entity).abilities.creativeMode ? itemstack : new ItemStack(Items.BOWL);
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
}