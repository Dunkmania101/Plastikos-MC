package dunkmania101.plastikos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.icu.impl.Pair;

import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.PlastikosModuleBase;
import dunkmania101.plastikos.modules.control.PlastikosModuleControl;
import dunkmania101.plastikos.modules.logistics.PlastikosModuleLogistics;
import dunkmania101.plastikos.modules.mobs.PlastikosModuleMobs;
import dunkmania101.plastikos.modules.production.PlastikosModuleProduction;
import dunkmania101.plastikos.modules.transportation.PlastikosModuleTransportation;
import dunkmania101.plastikos.modules.warfare.PlastikosModuleWarfare;
import dunkmania101.plastikos.modules.world.PlastikosModuleWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlastikosMod implements IPlastikosModule {
    public static PlastikosMod INSTANCE;

    public final Map<String, IPlastikosModule> MODULES;

    protected final IRegistryAcceptor<Item> itemAcceptor;
    protected final IRegistryAcceptor<Block> blockAcceptor;
    protected final IRegistryAcceptor<BlockEntityType<?>> blockEntityAcceptor;
    protected final IRegistryAcceptor<EntityType<?>> entityAcceptor;
    protected final IRegistryAcceptor<MenuType<?>> menuAcceptor;

    public final PlastikosModuleBase BASE;
    public final PlastikosModuleWorld WORLD;
    public final PlastikosModuleMobs MOBS;
    public final PlastikosModuleControl CONTROL;
    public final PlastikosModuleProduction PRODUCTION;
    public final PlastikosModuleLogistics LOGISTICS;
    public final PlastikosModuleTransportation TRANSPORTATION;
    public final PlastikosModuleWarfare WARFARE;

    public PlastikosMod(IRegistryAcceptor<Item> itemAcceptor, IRegistryAcceptor<Block> blockAcceptor, IRegistryAcceptor<BlockEntityType<?>> blockEntityAcceptor, IRegistryAcceptor<EntityType<?>> entityAcceptor, IRegistryAcceptor<MenuType<?>> menuAcceptor) {
        INSTANCE = this;

        this.itemAcceptor = itemAcceptor;
        this.blockAcceptor = blockAcceptor;
        this.blockEntityAcceptor = blockEntityAcceptor;
        this.entityAcceptor = entityAcceptor;
        this.menuAcceptor = menuAcceptor;

        this.MODULES = new HashMap<>();

        this.BASE = registerChild(new PlastikosModuleBase(this));
        this.WORLD = registerChild(new PlastikosModuleWorld(this));
        this.CONTROL = registerChild(new PlastikosModuleControl(this));
        this.PRODUCTION = registerChild(new PlastikosModuleProduction(this));
        this.LOGISTICS = registerChild(new PlastikosModuleLogistics(this));
        this.TRANSPORTATION = registerChild(new PlastikosModuleTransportation(this));
        this.WARFARE = registerChild(new PlastikosModuleWarfare(this));
        this.MOBS = registerChild(new PlastikosModuleMobs(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public Map<String, IPlastikosModule> getChildren() {
        return this.MODULES;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IRegistryAcceptor<?> getRegistryAcceptorOfId(ResourceLocation registry) {
        if (registry == Registries.ITEM.location()) {
            return this.itemAcceptor;
        } else if (registry == Registries.BLOCK.location()) {
            return this.blockAcceptor;
        } else if (registry == Registries.BLOCK_ENTITY_TYPE.location()) {
            return this.blockEntityAcceptor;
        } else if (registry == Registries.ENTITY_TYPE.location()) {
            return this.entityAcceptor;
        } else if (registry == Registries.MENU.location()) {
            return this.menuAcceptor;
        }

        return null;
    }

    @Override
    public boolean parentIsDep() {
        return false;
    }

    @Override
    public ArrayList<Pair<String, Boolean>> getDependencyIds() {
        return new ArrayList<>();
    }

    @Override
    public boolean isDependable() {
        return true;
    }
}
