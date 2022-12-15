package dunkmania101.plastikos.modules.mobs.modules.monsters;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry.PlastikosMobsMonstersBlockRegistry;
import dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry.PlastikosMobsMonstersItemRegistry;

public class PlastikosModuleMobsModuleMonsters extends BasePlastikosModule {
    public final PlastikosMobsMonstersBlockRegistry BLOCKS;
    public final PlastikosMobsMonstersItemRegistry ITEMS;

    public PlastikosModuleMobsModuleMonsters(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosMobsMonstersBlockRegistry(this);
        this.ITEMS = new PlastikosMobsMonstersItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_MONSTERS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
