package dunkmania101.modularmod.base.objects.block_entities.base;

import dunkmania101.modularmod.base.data.ModularModConstants;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseModularModBlockEntity extends BlockEntity implements IModularModContentObject {
    protected final IModularModModule PARENT_MODULE;

    public BaseModularModBlockEntity(IModularModModule parentModule, BlockEntityType<BaseModularModBlockEntity> beType, BlockPos pos, BlockState state) {
        super(beType, pos, state);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT_MODULE;
    }

    @Override
    public void load(CompoundTag data) {
        setData(data.getCompound(ModularModConstants.KEY_ROOT_DATA));
    }

    @Override
    protected void saveAdditional(CompoundTag data) {
        data.put(ModularModConstants.KEY_ROOT_DATA, getData());
    }
}
