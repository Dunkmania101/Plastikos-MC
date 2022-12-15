package dunkmania101.modularmod.base.objects.block_entities.base;

import dunkmania101.modularmod.base.data.ModularModConstants;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.objects.base.interfaces.IModularModContentObject;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseModularModBlockEntity<M extends IModularModModule<?>> extends BlockEntity implements IModularModContentObject<M> {
    protected final M PARENT_MODULE;

    public BaseModularModBlockEntity(M parentModule, BlockEntityType<BaseModularModBlockEntity<M>> beType, BlockPos pos, BlockState state) {
        super(beType, pos, state);
        this.PARENT_MODULE = parentModule;
    }

    @Override
    public M getParentModule() {
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
