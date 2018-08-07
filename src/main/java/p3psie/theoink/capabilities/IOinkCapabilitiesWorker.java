package p3psie.theoink.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class IOinkCapabilitiesWorker implements IOinkCapabilities, INBTSerializable<NBTTagCompound> {
    private int cool;
    int maxCool;

    private Runnable doPork, porkDone;

    public IOinkCapabilitiesWorker(int maxCool, Runnable doPork, Runnable porkDone){
        this.cool = 0;
        this.maxCool = maxCool;
        this.doPork = doPork;
        this.porkDone = porkDone;
    }

    public void setMaxCool(int maxCool){
        this.maxCool = maxCool;
    }


    @Override
    public int getPorkDone() {
        return this.cool;
    }

    @Override
    public void doPork() {
        this.cool++;
        this.cool %= this.maxCool;
        this.doPork.run();

        if(this.cool == 0)
            porkDone();
    }

    @Override
    public void porkDone() {
        this.porkDone.run();
    }



    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("cooldown", this.cool);
        nbt.setInteger("maxCooldown", this.maxCool);
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.cool = nbt.getInteger("cooldown");
        this.maxCool = nbt.getInteger("maxCooldown");
    }
}
