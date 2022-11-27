package dunkmania101.modularmod.base.objects.blocks.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.level.block.Block;

public class BaseModularModBlock extends Block implements IModularModContentObject {
    protected final IModularModModule PARENT_MODULE;

    public BaseModularModBlock(IModularModModule parentModule, Properties properties) {
        super(properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT_MODULE;
    }
}

