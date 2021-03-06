package com.ian.mario.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.mario.Constants;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label levelLabel;
    Label timeLabel;
    Label worldLabel;
    Label marioLabel;

    public Hud(SpriteBatch spriteBatch){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(Constants.V_WIDTH, Constants.V_HEIGHT, new OrthographicCamera());
        stage= new Stage(viewport, spriteBatch);

        Table table = new Table(); //gives organisation to the stage
        table.top(); //puts table at the top of the stage (instead of centre by default)
        table.setFillParent(true); //makes the table the size of the stage

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLabel = new Label("MARIO" , new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);
    }
}
