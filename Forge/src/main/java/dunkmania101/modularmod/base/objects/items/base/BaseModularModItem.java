package dunkmania101.modularmod.base.objects.items.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.world.item.Item;

public class BaseModularModItem<M extends IModularModModule<?>> extends Item implements IModularModContentObject<M> {
    protected final M PARENT_MODULE;

    public BaseModularModItem(M parentModule, Properties properties) {
        super(properties);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public M getParentModule() {
        return this.PARENT_MODULE;
    }
}
