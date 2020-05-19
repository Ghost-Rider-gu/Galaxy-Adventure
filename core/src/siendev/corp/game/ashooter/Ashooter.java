/*
 * Copyright (c) 2020. Golubnichenko Iurii aka Ghost Rider
 */

package siendev.corp.game.ashooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import siendev.corp.game.ashooter.screens.MenuScreen;

public class Ashooter extends Game {

	public SpriteBatch batch;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
