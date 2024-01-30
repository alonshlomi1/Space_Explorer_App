package com.example.spaceexplorerapp.Model;

import com.example.spaceexplorerapp.R;

public class Asteroid extends GameObject{
    private static final int[] srcList = {R.drawable.asteroid1, R.drawable.asteroid2, R.drawable.asteroid3, R.drawable.asteroid4};
    private static final int ASTEROID_POINTS = 5;
    public Asteroid(){}

    public static int[] getSrcList(){return srcList;}

    public static int getPoints() {
        return ASTEROID_POINTS;
    }

}
