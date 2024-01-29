package com.example.spaceexplorerapp.Logic;

import com.example.spaceexplorerapp.Model.Asteroid;
import com.example.spaceexplorerapp.Model.Spaceship;
import com.example.spaceexplorerapp.R;

import java.util.ArrayList;

public class GameManager {
    private int score = 0;
    private int crushes = 0;
    private int life;
    private ArrayList<Asteroid> asteroidList;
    private Spaceship spaceship;

    public GameManager() {
        this.life = 3;
        setStart();
    }

    public GameManager(int life) {
        this.life = life;
        setStart();
    }

    private void setStart() {
        this.spaceship = new Spaceship();
        this.spaceship.setCol(1);
        this.spaceship.setImage(R.drawable.spaceship1);
        asteroidList = new ArrayList<Asteroid>();
    }
    public int getScore() {
        return score;
    }

    public GameManager setScore(int score) {
        this.score = score;
        return this;
    }

    public int getCrushes() {
        return crushes;
    }

    public GameManager setCrushes(int crushes) {
        this.crushes = crushes;
        return this;
    }

    public int getLife() {
        return life;
    }

    public GameManager setLife(int life) {
        this.life = life;
        return this;
    }

    public ArrayList<Asteroid> getAsteroidList() {
        return asteroidList;
    }

    public GameManager setAsteroidList(ArrayList<Asteroid> asteroidList) {
        this.asteroidList = asteroidList;
        return this;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public GameManager setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
        return this;
    }
}
