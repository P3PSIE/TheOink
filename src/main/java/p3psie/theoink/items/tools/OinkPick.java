package p3psie.theoink.items.tools;

import net.minecraft.item.ItemPickaxe;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkPick extends ItemPickaxe implements OinkModelRegistry {
    protected String name;

    public OinkPick(String name, ToolMaterial material) {
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