package p3psie.theoink.init;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import p3psie.theoink.capabilities.IOinkCapabilities;
import p3psie.theoink.capabilities.IOinkCapabilitiesWorker;

import javax.annotation.Nullable;

public class OinkCapabilities {

    @CapabilityInject(IOinkCapabilities.class)
    public static Capability<IOinkCapabilities> OINK_CAPABILITY_WORKER = null;

    public static void regCapabilities(){
        CapabilityManager.INSTANCE.register(IOinkCapabilities.class, new CapabilityWorker(), IOinkCapabilitiesWorker.class);
    }

    public static class CapabilityWorker implements Capability.IStorage<IOinkCapabilities>{

        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IOinkCapabilities> capability, IOinkCapabilities instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IOinkCapabilities> capability, IOinkCapabilities instance, EnumFacing side, NBTBase nbt) {

        }
    }
}
