package net.matthewmawson.lsystrees;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
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
import net.minecraft.util.Pair;
import net.minecraft.util.math.*;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Stack;


public class LSysBlock extends Block {

    public LSysBlock() {
        super(FabricBlockSettings.of(Material.WOOD).breakByHand(false).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2,2.0f));
    }

    private TurtleEntity turtle;

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        LSysTurtle turtle = new LSysTurtle(new Vec3d( (double)pos.getX(), (double)pos.getY(), (double)pos.getZ()));



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

        // Stack to store the states of the turtle
        Stack<Pair<Vec3d,double[][]>> turtleStateStack = new Stack<Pair<Vec3d,double[][]>>();

        String axiumS = "F+F-F-FF+F+F-F+";
        String axiumB = "F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-FF+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F+ F+ F-F-FF+ F+ F-F-F+ F-F-FF+ F+ F-F";
        String axiumD = "FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF-FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FFFF+F-F+F+FF+FF+F-F+F+FF-FF+F-F+F+FF+FF+F-F+F+FF+FF+F-F+F+FFFF+F-F+F+FF";
        String axium = axiumB;
        axium = "FF-[-F+F+F]+[+F-F-F]";         //35
        axium = "^^FF-[-F+F+F]+[+F-F-F]FF-[-F+F+F]+[+F-F-F]-[-FF-[-F+F+F]+[+F-F-F]+FF-[-F+F+F]+[+F-F-F]+FF-[-F+F+F]+[+F-F-F]]+[+FF-[-F+F+F]+[+F-F-F]-FF-[-F+F+F]+[+F-F-F]-FF-[-F+F+F]+[+F-F-F]]";

        //axium = "F+F+F+F+^F&F+F+F+F";
        axium = "[&&][FFF[&&][&FFF]////[&&][&FFF]////[&&]&FFF]////[&&][FFF[&&J][&FFF]////[&&][&FFF]////[&&]&FFF]////[&&]FFF[&&J][&FFF]////[&&][&FFF]////[&&]&FFF";

        /*int n = 7;
        String rule = "A";
        String p1 = "A-[&FLA]/////[&FLA]///////[&FLA]";
        String p2 = "F-S/////F";
        String p3 = "S-F";
        String p4 = "[^^{-f+f+f-|-f+f+f}]";*/


        /*int n = 4;              //https://www.sidefx.com/docs/houdini/nodes/sop/lsystem.html
        String rule = "FFFA";
        String p1 = "A-"&FFFA]////[&&][&FFFA]////[&&]&FFFA*/

        int n = 7;
        float degrees = 28;
        String rule = "^^^FFFA";
        String p1 = "[B]////[B]////[B]";        // First rule = A
        String p2 = "&FFFA";                    // Second rule = B

        for(int i = 0; i<n; i++){
            axium = "";
            while(rule.length() > 0){
                char symbol = rule .charAt(0);
                rule = rule.substring(1);

                switch (symbol){
                    case 'A':
                        axium = axium + p1;
                        break;
                    case 'B':
                        axium = axium + p2;
                        break;
                    default:
                        axium = axium + symbol;
                        break;
                }
            }
            rule = axium;
        }

        System.out.println(axium);


        //float degrees = 22.5f;
        float angle = degrees*(float)Math.PI/180;

        int blocksPerState = 3;

        //BlockState block = Blocks.LIME_CONCRETE.getDefaultState();
        BlockState block = Blocks.OAK_WOOD.getDefaultState();


        while(axium.length() > 0) {
            char symbol = axium.charAt(0);
            axium = axium.substring(1);

            System.out.println(turtle.getDirection());

            switch (symbol){
                case 'F':
                    Vec3d oldTurtlePos = turtle.getPos();
                    turtle.moveForward(blocksPerState);
                    placeLine(world, block, oldTurtlePos, turtle.getPos(), turtle.getDirection());
                    //position = placeLine(world, block, blocksPerState, direction, position);
                    break;
                case '+':
                    turtle.yawLeft(angle);
                    //direction = direction.rotateYCounterclockwise();
                    break;
                case '-':
                    turtle.yawRight(angle);
                    //direction = direction.rotateYClockwise();
                    break;
                case '&':
                    turtle.pitchDown(angle);
                    break;
                case '^':
                    turtle.pitchUp(angle);
                    break;
                case '\\':
                    turtle.rollLeft(angle);
                    break;
                case '/':
                    turtle.rollRight(angle);
                    break;
                case '|':
                    turtle.turnAround();
                    break;
                case '[':
                    turtleStateStack.push(new Pair<Vec3d, double[][]>(turtle.getPos(), turtle.getHLU()));
                    break;
                case ']':
                    Vec3d point5 = new Vec3d(-0.5d, -0.5d, -0.5d);
                    Pair<Vec3d, double[][]> turtleStateValues = turtleStateStack.pop();
                    turtle = new LSysTurtle(turtleStateValues.getLeft().add(point5), turtleStateValues.getRight());
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

    private void placeLine(World world, BlockState block, Vec3d oldPos, Vec3d newPos, Vec3d direction){
        // While there are more blocks to render
        float increment = 0.5f;
        Vec3d previousPos = oldPos;
        while(previousPos.distanceTo(newPos) > increment){
            //System.out.println(previousPos.distanceTo(newPos));
            BlockPos prevBlockPos = new BlockPos(previousPos);
            world.setBlockState(prevBlockPos, block);
            previousPos = previousPos.add(direction.multiply(increment));
            //System.out.println(previousPos);
            //System.out.println(oldPos);
            //System.out.println(newPos);
        }

        /*while(oldPos.distanceTo(turtle.getPos()) > increment){
            BlockPos prevPos = new BlockPos(previousPos);
            world.setBlockState(prevPos, block);
            turtle.moveForward(increment);
            previousPos = turtle.getPos();
        }*/
    }

    /*@Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new LSysBlockBlockEntity();
    }*/
}





/*
Old simple code

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
        }*/