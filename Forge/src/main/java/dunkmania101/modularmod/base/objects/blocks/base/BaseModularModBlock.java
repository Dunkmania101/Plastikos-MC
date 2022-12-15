package dunkmania101.modularmod.base.objects.blocks.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.level.block.Block;

public class BaseModularModBlock<M extends IModularModModule<?>> extends Block implements IModularModContentObject<M> {
    protected final M PARENT_MODULE;

    public BaseModularModBlock(M parentModule, Properties properties) {
        super(properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public M getParentModule() {
        return this.PARENT_MODULE;
    }
}

