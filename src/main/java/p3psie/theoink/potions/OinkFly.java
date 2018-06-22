package p3psie.theoink.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import p3psie.theoink.TheOink;

@Mod.EventBusSubscriber
public class OinkFly extends Potion {
    private static final ResourceLocation icon = new ResourceLocation(TheOink.MODID,"textures/gui/oink_flight.png");
    public String name;

    public OinkFly(boolean isBadEffectIn, int liquidColorIn, String name) {
        super(isBadEffectIn, liquidColorIn);
        this.setPotionName(name);
        this.setRegistryName(name);
        this.name = name;
    }

    @Override
    public int getStatusIconIndex() {
        Minecraft.getMinecraft().renderEngine.bindTexture(getTextureFile());
        return super.getStatusIconIndex();
    }
    public Potion setIconIndex(int x, int y) {
        super.setIconIndex(x, y);
        return (Potion) this;
    }

    @Override
    public boolean shouldRenderHUD(PotionEffect effect) {
        return false;
    }

    private ResourceLocation getTextureFile() {
        return icon;
    }

    @Override
    public boolean isBadEffect() {
        return false;
    }

    @SubscribeEvent
    public static void onFlight(TickEvent.PlayerTickEvent e) {
        boolean flight = false;

        if(e.player.isPotionActive(TheOink.OINK_FLY))
        flight = true;

        if(flight || e.player.isCreative() || e.player.isSpectator()){
            e.player.capabilities.allowFlying = true;
            e.player.fallDistance = 0.0f;
        }else{
            flight = false;
            e.player.capabilities.isFlying = false;
            e.player.capabilities.allowFlying = false;
        }
    }
}
