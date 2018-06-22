package p3psie.theoink.blocks.ores;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import p3psie.theoink.blocks.OinkBlockBase;

public class OinkBaseOre extends OinkBlockBase {
    protected String oreName;

    public OinkBaseOre(String name, Material materialIn, String oreName, float hardness, float resistance, float lightLevel) {
        super(name, materialIn);
        this.oreName = oreName;
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
        this.setResistance(15.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setLightLevel(1.0F);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }

}