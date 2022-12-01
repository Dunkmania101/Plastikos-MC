package dunkmania101.modularmod.base.objects.base.impl;

import javax.annotation.Nonnull;

import dunkmania101.modularmod.base.data.ModularModConstants;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class ModularModItemStackWrapper implements IModularModContentObject {
    private final IModularModModule PARENT_MODULE;
    @Nonnull
    private final ItemStack stack;

    public ModularModItemStackWrapper(IModularModModule parentModule, @Nonnull ItemStack stack) {
        this.PARENT_MODULE = parentModule;
        this.stack = stack;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT_MODULE;
    }

    @Nonnull
    public ItemStack getStack() {
        return this.stack;
    }

    @Override
    public CompoundTag gatherData() {
        CompoundTag stackData = getStack().getTag();
        if (stackData != null && stackData.contains(ModularModConstants.KEY_ROOT_DATA)) {
            return stackData.getCompound(ModularModConstants.KEY_ROOT_DATA);
        }
        return null;
    }
}
