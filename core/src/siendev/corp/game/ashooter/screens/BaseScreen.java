/*
 * Copyright (c) 2020. Golubnichenko Iurii aka Ghost Rider
 */

package siendev.corp.game.ashooter.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import siendev.corp.game.ashooter.Ashooter;
import siendev.corp.game.ashooter.commons.GameConst;

public abstract class BaseScreen implements Screen {

    protected final OrthographicCamera gameCamera;
    protected final Viewport gameViewport;
    protected final Ashooter ashooterGame;

    public BaseScreen(Ashooter game) {
        this.ashooterGame = game;
        this.gameCamera = new OrthographicCamera();
        this.gameViewport = new FitViewport(GameConst.WORLD_WIDTH, GameConst.WORLD_HEIGHT, this.gameCamera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        this.gameViewport.update(width, height);
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

    }
}
