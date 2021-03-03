package net.matthewmawson.lsystrees;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class LSysBlock extends Block {

    public LSysBlock() {
        super(FabricBlockSettings.of(Material.WOOD).breakByHand(false).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2,2.0f));
    }

    private TurtleEntity turtle;

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        LSysTurtle turtle = new LSysTurtle();


        // Interpret an L-System string and display it in blocks
        // North = -z , East = +x
        //turtle = (TurtleEntity) EntityType.TURTLE.create(world);
        //turtle.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
        //turtle.setInvulnerable(true);
        //turtle.setNoGravity(true);
        //turtle.initialize((ServerWorld)placer.world, world.getLocalDifficulty(pos), SpawnReason.STRUCTURE, (EntityData)null, (CompoundTag)null);
        //world.spawnEntity(turtle);

        // Attempt was made to use entity, but particle is used instead.

        //MinecraftClient.getInstance().particleManager.addParticle(ParticleTypes.EXPLOSION, pos.getX());

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
