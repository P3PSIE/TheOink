package p3psie.theoink.crops;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkPorkCrop extends BlockCrops implements OinkModelRegistry {

    private String name;

    public OinkPorkCrop (String name){
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(Item.getItemFromBlock(this), 0, name);
    }


    public Item itemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
