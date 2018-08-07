package p3psie.theoink.items.food;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import p3psie.theoink.config.OinkConfig;

import javax.annotation.Nullable;
import java.util.List;

public class OinkIronPorkchop extends OinkFoodBase {

    private final PotionEffect[] effects;

    public OinkIronPorkchop(String name, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(name, oreName, hunger, saturation, isWolfFood);


        effects = new PotionEffect[OinkConfig.FOOD.ironPorkchopEffects.length];
        for(int i = 0; i < OinkConfig.FOOD.ironPorkchopEffects.length; i++) {
            String[] split = OinkConfig.FOOD.ironPorkchopEffects[i].split(",");
            Potion potion = Potion.getPotionFromResourceLocation(split[0]);
            if(potion == null) continue;
            int duration, power;
            try {
                duration = Integer.parseInt(split[1]);
                power = Integer.parseInt(split[2]);
            }catch (NumberFormatException e){
                continue;
            }
            PotionEffect effect = new PotionEffect(potion, duration, power, false, false);
            effects[i] = effect;
        }
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        for(PotionEffect effect : effects){
            player.addPotionEffect(new PotionEffect(effect));
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("1st step towards the Ultimate Pork Chop!");
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add("Haste");
            tooltip.add("Speed");
            tooltip.add("Night Vision");
        }
        if (!GuiScreen.isShiftKeyDown())
            tooltip.add(TextFormatting.AQUA + I18n.format("press.for.info.name", "SHIFT"));

    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.COMMON;
    }
}