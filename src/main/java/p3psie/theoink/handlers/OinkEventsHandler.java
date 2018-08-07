package p3psie.theoink.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import p3psie.theoink.entities.OinkBacon;
import p3psie.theoink.entities.OinkSausage;

@Mod.EventBusSubscriber
public class OinkEventsHandler {

    public static boolean baconGlow;
    private static boolean sausageGlow;
    private static final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public static void playerInteract(PlayerInteractEvent.EntityInteract e) {
        EntityPlayer player = e.getEntityPlayer();

        if (!player.world.isRemote) {
            if (e.getTarget() instanceof OinkSausage) {
                if (player.getHeldItemMainhand().isEmpty() && player.isSneaking() && e.getHand() == EnumHand.MAIN_HAND) {
                    sausageGlow = !sausageGlow;
                }
            }

            if (e.getTarget() instanceof OinkBacon) {
                if (player.getHeldItemMainhand().isEmpty() && player.isSneaking() && e.getHand() == EnumHand.MAIN_HAND) {
                    baconGlow = !baconGlow;
                }
            }
        }

        else {
                player.swingArm(EnumHand.MAIN_HAND);
            }
    }

    @SubscribeEvent
    public static void applyEffectBacon(LivingEvent.LivingUpdateEvent e) {
        if (e.getEntity() instanceof OinkBacon) {
            OinkBacon piggy = (OinkBacon) e.getEntity();
            if (baconGlow) {
                piggy.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 3, 10, false, false));
            }
        }

        if (e.getEntity() instanceof OinkSausage) {
            OinkSausage piggy = (OinkSausage) e.getEntity();
            if (sausageGlow) {
                piggy.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 3, 10, false, false));
            }
        }
    }

}
