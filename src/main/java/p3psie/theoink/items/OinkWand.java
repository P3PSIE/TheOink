package p3psie.theoink.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import p3psie.theoink.entities.OinkBacon;
import p3psie.theoink.entities.OinkSausage;

public class OinkWand extends OinkItemBase {
    protected String name;
    public OinkWand(String name) {
        super(name);
        this.name = name;
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        double x = player.posX;
        double y = player.posY;
        double z = player.posZ;
        String list = player.world.getLoadedEntityList().toString();
        boolean spawnOinkBacon = true;
        boolean spawnOinkSausage = true;

        spawnOinkBacon = !list.contains("OinkBacon");
        spawnOinkSausage = !list.contains("OinkSausage");

        if(!worldIn.isRemote && player.dimension == 0) {
            if(spawnOinkBacon) {
                spawnBacon(worldIn, pos);
                player.world.playSound(player, x, y, z, SoundEvents.ENTITY_PIG_AMBIENT, SoundCategory.NEUTRAL, 30.0F, 1.0F);
            }else if(spawnOinkSausage){
                spawnSausage(worldIn, pos);
                player.world.playSound(player, x, y, z, SoundEvents.ENTITY_PIG_AMBIENT, SoundCategory.NEUTRAL, 30.0F, 1.0F);
            }else {
                chatMessage(player);
                player.world.playSound(player, x, y, z, SoundEvents.ENTITY_PIG_HURT, SoundCategory.NEUTRAL, 30.0F, 1.0F);
            }
        }else if (!worldIn.isRemote){
            player.sendMessage(new TextComponentTranslation("oinkwand.strings.nonspawn"));

        }
        return EnumActionResult.SUCCESS;
    }


    private void chatMessage(EntityPlayer player){
        player.sendMessage(new TextComponentTranslation("oinkwand.strings.pigsalive"));
    }

    private  void spawnBacon(World worldIn, BlockPos pos){
        OinkBacon oinkBacon = new OinkBacon(worldIn);
        oinkBacon.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        worldIn.spawnEntity(oinkBacon);

    }

    private  void spawnSausage(World worldIn, BlockPos pos){
        OinkSausage oinkSausage = new OinkSausage(worldIn);
        oinkSausage.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        worldIn.spawnEntity(oinkSausage);
    }
}
