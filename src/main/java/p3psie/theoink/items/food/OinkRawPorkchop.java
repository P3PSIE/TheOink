package p3psie.theoink.items.food;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class OinkRawPorkchop extends OinkFoodBase {
    protected EnumRarity rarity;
    public OinkRawPorkchop(String name, EnumRarity rarity, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(name, oreName, hunger, saturation, isWolfFood);
        this.rarity = rarity;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote && !player.capabilities.isCreativeMode) {
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 120, 0, false, false));
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return rarity;
    }
}
