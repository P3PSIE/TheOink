package p3psie.theoink.items.tools;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import p3psie.theoink.items.OinkItemBase;

import javax.annotation.Nullable;
import java.util.List;

public class OinkTools extends OinkItemBase {
    private String tooltipInfo;

    public OinkTools(String name, String tooltipInfo, int maxUses) {
        super(name);
        this.setMaxDamage(maxUses);
        this.tooltipInfo = tooltipInfo;
        this.setMaxStackSize(1);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);
        stack.setCount(1);

        return stack;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int damage = stack.getMaxDamage() - stack.getItemDamage() ;

        //tooltip.add("Uses Left: \u00A7c" + damage);
        if (GuiScreen.isShiftKeyDown()) {
            tooltip.add(tooltipInfo);
        }
        if (!GuiScreen.isShiftKeyDown())
            tooltip.add(TextFormatting.AQUA + I18n.format("press.for.info.name", "SHIFT"));
    }
}
