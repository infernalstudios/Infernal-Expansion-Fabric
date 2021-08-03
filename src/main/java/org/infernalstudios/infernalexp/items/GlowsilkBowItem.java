package org.infernalstudios.infernalexp.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import org.infernalstudios.infernalexp.access.PersistentProjectileEntityAccess;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.infernalstudios.infernalexp.registry.IEEffects;

import java.util.Random;

public class GlowsilkBowItem extends BowItem {

    protected static final Random random = new Random();

    public GlowsilkBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) user;
            boolean flag = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;

            ItemStack itemStack = playerEntity.getArrowType(stack);

            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (!itemStack.isEmpty() || flag) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(Items.ARROW);
                }

                float pullProgress = getPullProgress(i);
                if (!((double) pullProgress < 0.1D)) {
                    boolean isArrowInfinite = playerEntity.getAbilities().creativeMode || (itemStack.getItem() instanceof ArrowItem && isInfinite(stack, itemStack));
                    if (!world.isClient) {

                        PersistentProjectileEntity persistentProjectileEntity;

                        persistentProjectileEntity = ProjectileUtil.createArrowProjectile(playerEntity, itemStack, pullProgress);
                        persistentProjectileEntity.setProperties(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, pullProgress * 6.0F, 1.0F);

                        persistentProjectileEntity.setDamage((persistentProjectileEntity.getDamage() / 2.0D) + 0.1D);

                        if (pullProgress == 1.0F) {
                            persistentProjectileEntity.setCritical(true);
                        }
                        int power = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
                        if (power > 0) {
                            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double) power * 0.5D + 0.5D);
                        }

                        int punch = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
                        if (punch > 0) {
                            persistentProjectileEntity.setPunch(punch);
                        }

                        if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                            persistentProjectileEntity.setOnFireFor(100);
                        }

                        stack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(playerEntity.getActiveHand()));

                        if (isArrowInfinite ||playerEntity.getAbilities().creativeMode && (itemStack.getItem() == Items.SPECTRAL_ARROW) || itemStack.getItem() == Items.TIPPED_ARROW) {
                            persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                        }

                        if (persistentProjectileEntity instanceof ArrowEntity) {
                            ((ArrowEntity) persistentProjectileEntity).addEffect(new StatusEffectInstance(IEEffects.LUMINOUS, 3600));
                        }

                        ((PersistentProjectileEntityAccess) persistentProjectileEntity).setGlow(true);

                        world.spawnEntity(persistentProjectileEntity);
                    }

                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F));
                    if (!isArrowInfinite && !playerEntity.getAbilities().creativeMode) {
                        playerEntity.getInventory().removeOne(itemStack);
                    }

                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }

    public boolean isInfinite(ItemStack bow, ItemStack arrow) {
        if (EnchantmentHelper.getLevel(Enchantments.INFINITY, bow) <= 0) {
            return arrow.getItem()== Items.ARROW;
        } else return false;
    }

}
