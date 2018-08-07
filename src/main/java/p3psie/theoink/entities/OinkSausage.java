package p3psie.theoink.entities;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import p3psie.theoink.init.OinkItems;
import p3psie.theoink.init.OinkLootTables;

import java.util.Set;

public class OinkSausage extends EntityPig {
    public static final int SAUSAGE_ID = 161;
    public static final int eggColour1 = 16746909;
    public static final int eggColour2 = 16740008;
    private ResourceLocation lootLoc = OinkLootTables.ENTITIES_SAUSAGE;
    public int timeToDrop;

    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, OinkItems.OINK_DIAMOND_CARROT);

    public OinkSausage(World worldIn) {
        super(worldIn);
        this.setCustomNameTag("Sausage");
        this.setAlwaysRenderNameTag(true);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.CARROT_ON_A_STICK, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
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

        if(!this.world.isRemote && !this.isChild() && timeToDrop == 1){
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(itemBlock, 1);
            this.timeToDrop = this.rand.nextInt(6000) + 6000;

        }

        if(!world.isRemote && timeToDrop >= 0){
            timeToDrop--;
        }

        if(timeToDrop < 0){
            timeToDrop = 120;
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("BaconDiamondLayTime", this.timeToDrop);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("BaconDiamondLayTime"))
        {
            this.timeToDrop = compound.getInteger("BaconDiamondLayTime");
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