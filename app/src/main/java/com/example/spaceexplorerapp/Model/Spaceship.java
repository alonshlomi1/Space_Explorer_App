package com.example.spaceexplorerapp.Model;

public class Spaceship extends GameObject{

    private final int row = 7;
    public Spaceship(){}

    @Override
    public int getRow() {
        return row;
    }
}
