package dunkmania101.modularmod.base.objects.items.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BaseModularModBlockItem extends BlockItem implements IModularModContentObject {
    protected final IModularModModule PARENT_MODULE;

    public BaseModularModBlockItem(IModularModModule parentModule, Block block, Properties properties) {
        super(block, properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT_MODULE;
    }
}
