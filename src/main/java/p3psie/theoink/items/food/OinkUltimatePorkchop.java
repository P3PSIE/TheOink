package p3psie.theoink.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import p3psie.theoink.TheOink;

public class OinkUltimatePorkchop extends OinkFoodBase {
    public OinkUltimatePorkchop(String name, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(name, oreName, hunger, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
            player.addPotionEffect(new PotionEffect(TheOink.OINK_FLY, 500, 1, false,false));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }
}
