package net.matthewmawson.lsystrees;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.system.CallbackI;

import java.util.Arrays;

public class LSysTurtle {

    // Vector pos
    //private Vec3d direction;
    private Vec3d pos;

    // Turtle heading, left and up, three unit length perpendicular vectors.
    private double[][] hlu = {
            new double[]{1.0d, 0.0d, 0.0d},
            new double[]{0.0d, 0.0d, 1.0d},
            new double[]{0.0d, 1.0d, 0.0d}
    };


    // Class to act as a the moving turtle for rendering L-Systems
    public LSysTurtle(){

    }

    public LSysTurtle(Vec3d blockPos){
        // Get the centre of the block as the starting point for the turtle
        pos = new Vec3d(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5);
        //direction = new Vec3d(1.0d, 0.0d, 0.0d); // Start facing forwards
    }

    public LSysTurtle(Vec3d blockPos, double[][] directionIn){
        // Get the centre of the block as the starting point for the turtle
        pos = new Vec3d(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5);
        hlu = directionIn;

        double[][] ma1 = {
                new double[]{1.0d, 2.0d, 3.0d},
                new double[]{4.0d, 5.0d, 6.0d},
                new double[]{7.0d, 8.0d, 9.0d}
        };
        double[][] ma2 = {
                new double[]{1.0d, 0.0d, 0.0d},
                new double[]{0.0d, 1.0d, 0.0d},
                new double[]{0.0d, 0.0d, 1.0d}
        };

        //System.out.println(Arrays.deepToString(matrixMultiply(ma1, ma2)));
    }

    public void moveForward(float distance){
        Vec3d direction = new Vec3d(hlu[0][0], hlu[1][0], hlu[2][0]);
        pos = pos.add(direction.multiply(distance));
    }

    public void yawLeft(float angle){
        double[][] rotMatrix = new double[][]{
                new double[]{Math.cos(angle), Math.sin(angle), 0.0d},
                new double[]{-Math.sin(angle), Math.cos(angle), 0.0d},
                new double[]{0.0d, 0.0d, 1.0d}
        };
        hlu = matrixMultiply(hlu,rotMatrix);
    }

    public void yawRight(float angle){
        yawLeft(-angle);
    }

    public void pitchUp(float angle){
        double[][] rotMatrix = new double[][]{
                new double[]{Math.cos(angle), 0.0d, -Math.sin(angle)},
                new double[]{0.0d, 1.0d, 0.0d},
                new double[]{Math.sin(angle), 0.0d, Math.cos(angle)}
        };
        hlu = matrixMultiply(hlu,rotMatrix);
    }

    public void pitchDown(float angle){
        pitchUp(-angle);
    }

    public void rollLeft(float angle){
        double[][] rotMatrix = new double[][]{
                new double[]{1.0d, 0.0d, 0.0d},
                new double[]{0.0d, Math.cos(angle), -Math.sin(angle)},
                new double[]{0.0d, Math.sin(angle), Math.cos(angle)}
        };
        hlu = matrixMultiply(hlu,rotMatrix);
    }

    public void rollRight(float angle){
        rollLeft(-angle);
    }

    // Rotate 180deg
    public void turnAround(){
        yawLeft((float)Math.PI);
    }

    public Vec3d getPos() {
        return pos;
    }

    public void setPos(Vec3d posIn) {
        pos = posIn;
    }

    public Vec3d getDirection() {
        return new Vec3d(hlu[0][0], hlu[1][0], hlu[2][0]);
    }

    public double[][] getHLU() {
        return hlu;
    }

    public void setDirection(Vec3d dirIn) {
        //direction = dirIn;
    }



    private double[][] matrixMultiply(double[][] m1, double[][] m2){
        double[][] output = new double[m1.length][m2[0].length];

        for (int i = 0; i< output.length; i++){
            for (int j = 0; j< output[0].length; j++){
                // for each cell in the final matrix
                double cellValue = 0;
                for(int k = 0; k< m1[0].length; k++){
                    cellValue += m1[i][k]*m2[k][j];
                }
                output[i][j] = cellValue;
            }
        }
        return output;

    }
}
