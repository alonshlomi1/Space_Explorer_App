package com.example.spaceexplorerapp.Model;

import com.example.spaceexplorerapp.R;

public class Spaceship extends GameObject{
    private static final int[] crushSrcList = {R.drawable.boom1, R.drawable.boom2};
    private static final int[] spaceshipSrcList = {R.drawable.boom1, R.drawable.boom2};

    private final int row = 7;
    public Spaceship(){}

    @Override
    public int getRow() {
        return row;
    }
    public static int[] getCrushSrcList(){return crushSrcList;}
    public static int[] getSpaceshipSrcList(){return spaceshipSrcList;}

}
