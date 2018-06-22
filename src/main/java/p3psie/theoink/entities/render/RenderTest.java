package p3psie.theoink.entities.render;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import p3psie.theoink.TheOink;
import p3psie.theoink.entities.OinkSausage;
import p3psie.theoink.entities.TestPig;

import javax.annotation.Nullable;

public class RenderTest extends RenderLiving<TestPig> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(TheOink.MODID + ":textures/entity/oink_sausage.png");

    public RenderTest(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPig(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(TestPig entity) {
        return TEXTURE;
    }

    @Override
    protected void applyRotations(TestPig entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
