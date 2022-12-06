package dunkmania101.plastikos.modules.transportation.common.objects.blocks;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PalletBlock extends BasePlastikosBlock {
    public PalletBlock(IModularModModule parentModule, Properties properties) {
        super(parentModule, properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return super.getShape(pState, pLevel, pPos, pContext);
    }
}
