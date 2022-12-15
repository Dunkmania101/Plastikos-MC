package dunkmania101.modularmod.base.objects.items.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BaseModularModBlockItem<M extends IModularModModule<?>> extends BlockItem implements IModularModContentObject<M> {
    protected final M PARENT_MODULE;

    public BaseModularModBlockItem(M parentModule, Block block, Properties properties) {
        super(block, properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public M getParentModule() {
        return this.PARENT_MODULE;
    }
}
