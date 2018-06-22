package p3psie.theoink.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class OinkTab extends CreativeTabs {
    public OinkTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(OinkItems.OINK_ULTIMATE_PORKCHOP);
    }
}