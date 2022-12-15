package dunkmania101.modularmod.base.registry.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.interfaces.IBlockRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public abstract class BaseBlockRegistryHandler<M extends IModularModModule<?>> implements IBlockRegistryHandler<M> {
    private final M PARENT;
    private final Map<ResourceLocation, Supplier<? extends Block>> ENTRIES = new HashMap<>();
    private final IRegistryAcceptor<? extends Block> acceptor;

    public BaseBlockRegistryHandler(M parent, IRegistryAcceptor<? extends Block> acceptor) {
        this.PARENT = parent;
        this.acceptor = acceptor;
    }

    public BaseBlockRegistryHandler(M parent) {
        this(parent, parent.getRegistryAcceptorOfId(Registry.BLOCK_REGISTRY.location()));
    }

    @Override
    public IRegistryAcceptor<? extends Block> getAcceptor() {
        return this.acceptor;
    }

    @Override
    public M getParentModule() {
        return this.PARENT;
    }

    @Override
    public Map<ResourceLocation, Supplier<? extends Block>> getEntries() {
        return this.ENTRIES;
    }
}
