package com.example.spaceexplorerapp.Model;

import com.example.spaceexplorerapp.R;

public class Spaceship extends GameObject{
    private static final int[] crushSrcList = {R.drawable.boom1, R.drawable.boom2};
    //private static final int[] spaceshipSrcList = {R.drawable.boom1, R.drawable.boom2};

    public Spaceship(){}

    @Override
    public int getRow() {
        return 7;
    }
    public static int[] getCrushSrcList(){return crushSrcList;}


}
