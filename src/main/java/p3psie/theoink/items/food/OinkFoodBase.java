package p3psie.theoink.items.food;

import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkFoodBase extends ItemFood implements OinkModelRegistry {
    protected String name;
    protected String oreName;

    public OinkFoodBase(String name, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        this.name = name;
        this.oreName = oreName;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TheOink.OINK_TAB);
        this.setMaxStackSize(64);
        this.setMaxDamage(0);
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(this, 0, name);
    }


    public void initOreDict(){
        OreDictionary.registerOre(oreName, this);
    }
}
