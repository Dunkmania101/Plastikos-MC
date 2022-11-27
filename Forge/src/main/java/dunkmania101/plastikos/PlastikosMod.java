package dunkmania101.plastikos;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.PlastikosModuleBase;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlastikosMod implements IModularModModule {
    public static PlastikosMod INSTANCE;

    public final Map<String, IModularModModule> MODULES;

    protected final IRegistryAcceptor<Item> itemAcceptor;
    protected final IRegistryAcceptor<Block> blockAcceptor;
    protected final IRegistryAcceptor<BlockEntityType<?>> blockEntityAcceptor;
    protected final IRegistryAcceptor<EntityType<?>> entityAcceptor;
    protected final IRegistryAcceptor<MenuType<?>> menuAcceptor;

    public final PlastikosModuleBase BASE;

    public PlastikosMod(IRegistryAcceptor<Item> itemAcceptor, IRegistryAcceptor<Block> blockAcceptor, IRegistryAcceptor<BlockEntityType<?>> blockEntityAcceptor, IRegistryAcceptor<EntityType<?>> entityAcceptor, IRegistryAcceptor<MenuType<?>> menuAcceptor) {
        INSTANCE = this;

        this.itemAcceptor = itemAcceptor;
        this.blockAcceptor = blockAcceptor;
        this.blockEntityAcceptor = blockEntityAcceptor;
        this.entityAcceptor = entityAcceptor;
        this.menuAcceptor = menuAcceptor;

        this.MODULES = new HashMap<>();

        this.BASE = registerChild(new PlastikosModuleBase(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public Map<String, IModularModModule> getChildren() {
        return this.MODULES;
    }

    @Override
    public IRegistryAcceptor<?> getRegistryAcceptorOfId(ResourceLocation registry) {
        if (registry == Registry.ITEM_REGISTRY.location()) {
            return this.itemAcceptor;
        } else if (registry == Registry.BLOCK_REGISTRY.location()) {
            return this.blockAcceptor;
        } else if (registry == Registry.BLOCK_ENTITY_TYPE_REGISTRY.location()) {
            return this.blockEntityAcceptor;
        } else if (registry == Registry.ENTITY_TYPE_REGISTRY.location()) {
            return this.entityAcceptor;
        } else if (registry == Registry.MENU_REGISTRY.location()) {
            return this.menuAcceptor;
        }

        return null;
    }
}
