/*
 * Copyright (c) 2020. Golubnichenko Iurii aka Ghost Rider
 */

package siendev.corp.game.ashooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import siendev.corp.game.ashooter.Ashooter;
import siendev.corp.game.ashooter.units.ParallaxMenuBackground;

public class MenuScreen extends BaseScreen {

    private final Stage menuStage;
    private static final int PARALLAX_SPEED = 1;

    public MenuScreen(Ashooter game) {
        super(game);
        this.menuStage = new Stage(new ScreenViewport());

        ParallaxMenuBackground parallaxMenuBackground = new ParallaxMenuBackground();
        parallaxMenuBackground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        parallaxMenuBackground.setParallaxSpeed(PARALLAX_SPEED);
        menuStage.addActor(parallaxMenuBackground);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuStage.act();
        menuStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.menuStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        menuStage.dispose();
    }
}
