package p3psie.theoink.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkBlockBase extends Block implements OinkModelRegistry {
    protected String name;

    public OinkBlockBase(String name, Material materialIn) {
        super(materialIn);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TheOink.OINK_TAB);
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(Item.getItemFromBlock(this), 0, name);
    }

    public Item itemBlock(){
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
