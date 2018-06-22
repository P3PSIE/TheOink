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

public class OinkBacon extends EntityPig {

    public static final int BACON_ID = 160;
    public static final int eggColour1 = 16746908;
    public static final int eggColour2 = 16740007;
    private ResourceLocation lootLoc = OinkLootTables.ENTITIES_BACON;
    private int timeToDiamond;

    public OinkBacon(World worldIn) {
        super(worldIn);
        this.setCustomNameTag("Bacon");
        this.setAlwaysRenderNameTag(true);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        //Block stuff
        List<Block> listBlocks = ImmutableList.copyOf(Block.REGISTRY);
        int blockListSize = listBlocks.size();
        int randomBlockInt = rand.nextInt(blockListSize);
        Block block = Block.getBlockById(randomBlockInt);
        Item itemBlock = Item.getItemFromBlock(block);

        if(!listBlocks.isEmpty()){
            block = listBlocks.get(randomBlockInt);
        }


        if(!this.world.isRemote && !this.isChild() && timeToDiamond == 1){
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(itemBlock, 1);
            this.timeToDiamond = this.rand.nextInt(6000) + 6000;

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