package p3psie.theoink.items.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.Random;

public class OinkCarrots extends OinkFoodBase {
    private int pigQty;

    public OinkCarrots(String name, String oreName, int hunger, float saturation, boolean isWolfFood, int pigQty) {
        super(name, oreName, hunger, saturation, isWolfFood);

        this.pigQty = pigQty;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        World world = playerIn.world;
        Random rand = new Random();

        if(!world.isRemote) {
            if (stack.getItem() == this && !target.isChild() && !playerIn.getCooldownTracker().hasCooldown(stack.getItem())) {
                    if (target instanceof EntityPig) {
                        for (int i = 0; i < pigQty; i++) {
                            EntityPig pig = new EntityPig(world);
                            pig.setGrowingAge(-24000);
                            pig.setPosition(target.posX + (0.5 + rand.nextInt(2)), target.posY, target.posZ + (0.5 + rand.nextInt(2)));
                            world.spawnEntity(pig);
                            playerIn.getCooldownTracker().setCooldown(stack.getItem(), 300);
                        }
                        stack.shrink(1);
                }
            }
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
