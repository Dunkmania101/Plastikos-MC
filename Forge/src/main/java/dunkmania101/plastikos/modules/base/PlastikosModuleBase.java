package dunkmania101.plastikos.modules.base;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseBlockRegistry;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseItemRegistry;
import dunkmania101.plastikos.modules.base.modules.materials.PlastikosModuleBaseModuleMaterials;

public class PlastikosModuleBase implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleBaseModuleMaterials MATERIALS;

    public final PlastikosBaseBlockRegistry BLOCKS;
    public final PlastikosBaseItemRegistry ITEMS;

    public PlastikosModuleBase(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.MATERIALS = registerChild(new PlastikosModuleBaseModuleMaterials(this));

        this.BLOCKS = new PlastikosBaseBlockRegistry(this);
        this.ITEMS = new PlastikosBaseItemRegistry(this);
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_BASE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
