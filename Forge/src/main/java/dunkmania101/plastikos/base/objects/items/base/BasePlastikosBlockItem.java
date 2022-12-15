package dunkmania101.plastikos.base.objects.items.base;

import dunkmania101.modularmod.base.objects.items.base.BaseModularModBlockItem;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import net.minecraft.world.level.block.Block;

public class BasePlastikosBlockItem extends BaseModularModBlockItem<IPlastikosModule> {
    public BasePlastikosBlockItem(IPlastikosModule parentModule, Block block, Properties properties) {
        super(parentModule, block, properties);
    }
}
