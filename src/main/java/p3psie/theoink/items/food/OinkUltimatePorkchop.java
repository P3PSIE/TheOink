package p3psie.theoink.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import p3psie.theoink.TheOink;
import p3psie.theoink.config.OinkConfig;

public class OinkUltimatePorkchop extends OinkFoodBase {
    private final PotionEffect[] effects;
    public OinkUltimatePorkchop(String name, String oreName, int hunger, float saturation, boolean isWolfFood) {
        super(name, oreName, hunger, saturation, isWolfFood);
        this.setAlwaysEdible();

        effects = new PotionEffect[OinkConfig.FOOD.ultimatePorkchopEffects.length];
        for(int i = 0; i < OinkConfig.FOOD.ultimatePorkchopEffects.length; i++) {
            String[] split = OinkConfig.FOOD.ultimatePorkchopEffects[i].split(",");
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
        player.addPotionEffect(new PotionEffect(TheOink.OINK_FLIGHT, 600, 1, false, false));
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
