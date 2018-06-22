package p3psie.theoink.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import p3psie.theoink.TheOink;
import p3psie.theoink.entities.OinkBacon;

import javax.annotation.Nullable;

public class RenderBacon extends RenderLiving<OinkBacon> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(TheOink.MODID + ":textures/entity/oink_bacon.png");

    public RenderBacon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPig(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(OinkBacon entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(OinkBacon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}