/*
 * Copyright (c) 2020. Golubnichenko Iurii aka Ghost Rider
 */

package siendev.corp.game.ashooter.screens;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import siendev.corp.game.ashooter.Ashooter;

public class PlayScreen extends BaseScreen {

    private final Stage playStage;

    public PlayScreen(Ashooter game) {
        super(game);
        this.playStage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
        this.playStage.dispose();
    }
}
