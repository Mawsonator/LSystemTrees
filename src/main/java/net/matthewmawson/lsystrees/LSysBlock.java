package net.matthewmawson.lsystrees;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class LSysBlock extends Block {

    public LSysBlock() {
        super(FabricBlockSettings.of(Material.WOOD).breakByHand(false).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2,2.0f));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        // Interpret an L-System string and display it in blocks
        // North = -z , East = +x


        String axiumS = "F+F-F-FF+F+F-F+";
        String axiumB = "F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F";
        String axiumD = "FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF";
        String axium = axiumB;
        int blocksPerState = 2;

        BlockState block = Blocks.LIME_CONCRETE.getDefaultState();
        BlockPos position = new BlockPos(pos);
        Direction direction = Direction.NORTH;

        while(axium.length() > 0) {
            char symbol = axium.charAt(0);
            axium = axium.substring(1);

            switch (symbol){
                case 'F':
                    position = placeLine(world, block, blocksPerState, direction, position);
                    //world.setBlockState(position = position.offset(direction,blocksPerState),block);
                    break;
                case '+':
                    direction = direction.rotateYCounterclockwise();
                    break;
                case '-':
                    direction = direction.rotateYClockwise();
                    break;
            }
        }

        //world.setBlockState(pos.offset(Direction),state);
        //world.setBlockState(pos.east(), Blocks.ACACIA_PLANKS.getDefaultState());
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    /* Method to place a line of blocks, currently just straight lines
    *  Returns the position at the end of the line*/
    private BlockPos placeLine(World world, BlockState blockState, int length, Direction direction, BlockPos pos){
        while(length > 0){
            world.setBlockState(pos = pos.offset(direction),blockState);
            length--;
        }
        return pos;
    }
}
