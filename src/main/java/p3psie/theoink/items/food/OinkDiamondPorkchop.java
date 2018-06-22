package p3psie.theoink.items.food;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import p3psie.theoink.config.OinkConfig;
import p3psie.theoink.items.OinkItemBase;

import javax.annotation.Nullable;
import java.util.List;

public class OinkDiamondPorkchop extends OinkFoodBase {
    protected int effectsTimer = OinkConfig.FOOD.effectTime;

    public OinkDiamondPorkchop(String name, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(name, oreName, hunger, saturation, isWolfFood);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, effectsTimer, 0, false, false));
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION,effectsTimer, 0, false, false));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("3rd step towards the Ultimate Pork Chop!");
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add("Strength");
            tooltip.add("Regeneration");
            tooltip.add("Resistance");
            tooltip.add("Fire Resistance");
            tooltip.add("Haste");
            tooltip.add("Speed");
            tooltip.add("Night Vision");
        }
        if (!GuiScreen.isShiftKeyDown())
            tooltip.add(TextFormatting.AQUA + I18n.format("press.for.info.name", "SHIFT"));
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }
}