package dunkmania101.modularmod.base.objects.items.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.item.Item;

public class BaseModularModItem extends Item implements IModularModContentObject {
    protected final IModularModModule PARENT_MODULE;

    public BaseModularModItem(IModularModModule parentModule, Properties properties) {
        super(properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT_MODULE;
    }
}
