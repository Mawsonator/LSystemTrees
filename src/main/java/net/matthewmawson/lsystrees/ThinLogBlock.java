package net.matthewmawson.lsystrees;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ThinLogBlock extends PillarBlock {

    public ThinLogBlock() {
        super(FabricBlockSettings.of(Material.WOOD).breakByHand(false).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2,2.0f));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction.Axis dir = state.get(AXIS);
        switch(dir) {
            case X:
                return VoxelShapes.cuboid(0.0f, 0.1875f, 0.1875f, 1.0f, 0.8125f, 0.8125f);
            case Y:
                return VoxelShapes.cuboid(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
            case Z:
                return VoxelShapes.cuboid(0.1875f, 0.1875f, 0.0f, 0.8125f, 0.8125f, 1.0f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    //public BlockState getPlacementState(ItemPlacementContext ctx) {
    //    return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    //}
}
