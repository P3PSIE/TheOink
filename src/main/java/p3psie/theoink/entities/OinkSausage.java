package p3psie.theoink.entities;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import p3psie.theoink.init.OinkLootTables;

import java.util.List;

public class OinkSausage extends EntityPig {
    public static final int SAUSAGE_ID = 161;
    public static final int eggColour1 = 16746909;
    public static final int eggColour2 = 16740008;
    private ResourceLocation lootLoc = OinkLootTables.ENTITIES_SAUSAGE;
    public int timeToDiamond;

    public OinkSausage(World worldIn) {
        super(worldIn);
        this.setCustomNameTag("Sausage");
        this.setAlwaysRenderNameTag(true);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        Block block = Block.REGISTRY.getRandomObject(rand);
        Item itemBlock = Item.getItemFromBlock(block);

        if(!this.world.isRemote && !this.isChild() && timeToDiamond == 1){
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(itemBlock, 1);
            this.timeToDiamond = this.rand.nextInt(100) + 100;

        }

        if(!world.isRemote && timeToDiamond >= 0){
            timeToDiamond--;
        }

        if(timeToDiamond < 0){
            timeToDiamond = 120;
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("BaconDiamondLayTime", this.timeToDiamond);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("BaconDiamondLayTime"))
        {
            this.timeToDiamond = compound.getInteger("BaconDiamondLayTime");
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return lootLoc;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!this.world.isRemote)
        {
            this.dead = true;
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 60.0F, false);
            this.setDead();
        }
    }
}