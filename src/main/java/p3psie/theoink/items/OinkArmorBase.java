package p3psie.theoink.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkArmorBase extends ItemArmor implements OinkModelRegistry {
    protected String name;
    protected boolean hasEffect;

    public OinkArmorBase(String name, boolean hasEffect, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.name = name;
        this.hasEffect = hasEffect;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TheOink.OINK_TAB);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return hasEffect;
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(this, 0, name);
    }
}
