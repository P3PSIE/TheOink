package p3psie.theoink.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import p3psie.theoink.TheOink;
import p3psie.theoink.entities.OinkBacon;
import p3psie.theoink.entities.OinkSausage;
import p3psie.theoink.entities.TestPig;


public class OinkEntities {

    public static void entityReg(){
        registerEntities("oink_bacon", OinkBacon.class, OinkBacon.BACON_ID, 50, OinkBacon.eggColour1, OinkBacon.eggColour2);
        registerEntities("oink_sausage", OinkSausage.class, OinkSausage.SAUSAGE_ID, 50, OinkSausage.eggColour1, OinkSausage.eggColour2);
        registerEntities("oink_test", TestPig.class, 201, 50, 16746909, 16740008);
    }

    public static void registerEntities(String name, Class<? extends Entity> entity, int id, int range, int colour1, int colour2){
        EntityRegistry.registerModEntity(new ResourceLocation(TheOink.MODID + "" + name), entity, name, id, TheOink.instance, range,
                1, true, colour1, colour2);
    }

    public static void registerEntitiesEggless(String name, Class<? extends Entity> entity, int id, int range){
        EntityRegistry.registerModEntity(new ResourceLocation(TheOink.MODID + "" + name), entity, name, id, TheOink.instance, range,
                1, true);
    }
}