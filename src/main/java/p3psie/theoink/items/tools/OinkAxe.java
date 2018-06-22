package p3psie.theoink.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkAxe extends ItemAxe implements OinkModelRegistry {

    protected String name;

    public OinkAxe(String name, Item.ToolMaterial material, float damage, float speed){
        super(material, damage, speed);
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