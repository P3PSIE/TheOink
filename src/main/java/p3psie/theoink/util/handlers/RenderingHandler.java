package p3psie.theoink.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import p3psie.theoink.entities.OinkBacon;
import p3psie.theoink.entities.OinkSausage;
import p3psie.theoink.entities.render.RenderBacon;
import p3psie.theoink.entities.render.RenderSausage;

public class RenderingHandler {

    public static void init(){
        regBaconRender();
        regSausageRender();
    }

    public static void regBaconRender(){
        RenderingRegistry.registerEntityRenderingHandler(OinkBacon.class, new IRenderFactory<OinkBacon>() {
            @Override
            public Render<? super OinkBacon> createRenderFor(RenderManager manager) {
                return new RenderBacon(manager);
            }
        });
    }

    public static void regSausageRender(){
        RenderingRegistry.registerEntityRenderingHandler(OinkSausage.class, new IRenderFactory<OinkSausage>() {
            @Override
            public Render<? super OinkSausage> createRenderFor(RenderManager manager) {
                return new RenderSausage(manager);
            }
        });
    }
}
