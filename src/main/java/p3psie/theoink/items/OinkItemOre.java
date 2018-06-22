package p3psie.theoink.items;

import net.minecraftforge.oredict.OreDictionary;

public class OinkItemOre extends OinkItemBase {

    protected String oreName;

    public OinkItemOre(String name, String oreName) {
        super(name);
        this.oreName = oreName;
    }


    public void initOreDict(){
        OreDictionary.registerOre(oreName, this);
    }
}