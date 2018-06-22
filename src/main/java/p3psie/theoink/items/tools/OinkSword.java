package p3psie.theoink.items.tools;

import net.minecraft.item.ItemSword;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkSword extends ItemSword implements OinkModelRegistry {
    protected String name;

    public OinkSword(String name, ToolMaterial material){
        super(material);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TheOink.OINK_TAB);
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(this, 0, name);
    }
}