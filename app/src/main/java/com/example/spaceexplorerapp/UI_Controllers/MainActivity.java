package com.example.spaceexplorerapp.UI_Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.spaceexplorerapp.Logic.GameManager;
import com.example.spaceexplorerapp.Model.Asteroid;
import com.example.spaceexplorerapp.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ShapeableImageView main_IMG_background;
    private ShapeableImageView[] main_IMG_hearts;
    private MaterialTextView main_LBL_score;
    private ExtendedFloatingActionButton main_FAB_left;
    private ExtendedFloatingActionButton main_FAB_right;
    private ShapeableImageView[][] main_ING_grid;
    private GameManager gameManager;
    private GridLayout main_GRID_game;
    private static final long FRAME_DELAY = 900;

    private boolean timerOn = false;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        Glide.with(this)
                .load(R.drawable.space_backround)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(main_IMG_background);
        gameManager = new GameManager(main_IMG_hearts.length, main_ING_grid.length, main_ING_grid[0].length);
        refreshUI();
        main_FAB_left.setOnClickListener(view -> arrowClick(-1));
        main_FAB_right.setOnClickListener(view -> arrowClick(1));
        startTimer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    private void stopTimer() {
        timerOn = false;
        timer.cancel();
    }

    private void startTimer() {
        if(!timerOn){
            timerOn = true;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(() -> nextFrame());
                }
            }, 0, FRAME_DELAY);
        }
    }
    private void nextFrame(){
        gameManager.randomNewAsteroid();
        gameManager.nextFrame();
        refreshUI();
    }
    private void arrowClick(int n) {
        gameManager.moveSpaceship(n);
        refreshUI();
    }

    private void refreshUI() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
                main_ING_grid[row][col].setVisibility(View.INVISIBLE);
            }
        }
        for(Asteroid asteroid : gameManager.getAsteroidList()) {
            main_ING_grid[asteroid.getRow()][asteroid.getCol()].setImageResource(asteroid.getImage());
            main_ING_grid[asteroid.getRow()][asteroid.getCol()].setVisibility(View.VISIBLE);
        }
        if(gameManager.checkCrush()){
            main_ING_grid[gameManager.getSpaceship().getRow()][gameManager.getSpaceship().getCol()].setImageResource(gameManager.getRandomCrushSrc());
            setCurrentLife();
        }
        else
            main_ING_grid[gameManager.getSpaceship().getRow()][gameManager.getSpaceship().getCol()].setImageResource(gameManager.getSpaceship().getImage());
        main_ING_grid[gameManager.getSpaceship().getRow()][gameManager.getSpaceship().getCol()].setVisibility(View.VISIBLE);

        main_LBL_score.setText(String.format("%03d", gameManager.getScore()));
    }

    private void setCurrentLife() {
        for(int i=0; i< main_IMG_hearts.length; i++) {
            main_IMG_hearts[i].setVisibility(main_IMG_hearts.length - gameManager.getCrushes() > i ? View.VISIBLE : View.INVISIBLE);
        }

    }

    private void findViews() {
        main_IMG_hearts = new ShapeableImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3),
        };
        main_LBL_score= findViewById(R.id.main_LBL_score);
        main_FAB_left = findViewById(R.id.main_FAB_left);
        main_FAB_right = findViewById(R.id.main_FAB_right);
        main_IMG_background = findViewById(R.id.main_IMG_background);

        // Initialize the grid array
        main_ING_grid = new ShapeableImageView[8][3]; // Assuming 8 rows and 3 columns
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
                int viewId = getResources().getIdentifier("main_IMG_grid" + ((row * 3) + col + 1), "id", getPackageName());
                main_ING_grid[row][col] = findViewById(viewId);
                main_ING_grid[row][col].setVisibility(View.INVISIBLE);
            }
        }

    }

}