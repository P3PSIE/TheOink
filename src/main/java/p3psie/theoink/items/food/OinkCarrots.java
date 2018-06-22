package p3psie.theoink.items.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import p3psie.theoink.init.OinkItems;
import p3psie.theoink.items.OinkItemBase;

import java.util.Random;

public class OinkCarrots extends OinkItemBase {
    int pigQty;
    public OinkCarrots(String name, int pigsQty) {
        super(name);
        this.pigQty = pigsQty;
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        World world = playerIn.world;
        Random rand = new Random();

        if(!world.isRemote) {
            if (stack.getItem() == this && !target.isChild()) {
                if (target instanceof EntityPig) {
                    for(int i = 0; i < pigQty; i++) {
                        EntityPig pig = new EntityPig(world);
                        pig.setGrowingAge(-3000);
                        pig.setPosition(target.posX + (0.5 + rand.nextInt(2)), target.posY, target.posZ + (0.5 + rand.nextInt(2)));
                        world.spawnEntity(pig);
                    }
                    stack.shrink(1);
                }
            }
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
