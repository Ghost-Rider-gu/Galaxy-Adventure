/*
 * Copyright (c) 2020. Golubnichenko Iurii aka Ghost Rider
 */

package siendev.corp.game.ashooter.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

public class ParallaxMenuBackground extends Actor {

    private static final String BACKGROUND_IMAGE_RESOURCE   = "screens/menu/background/back_planet%s.png";
    private static final String MENU_BOX_IMAGE              = "screens/menu/menu_box.png";
    private static final String MENU_LOGO_IMAGE             = "screens/menu/menu_logo.png";

    private static final String PLAY_INACTIVE_BUTTON    = "screens/menu/buttons/play_inactive.png";
    private static final String PLAY_ACTIVE_BUTTON      = "screens/menu/buttons/play_active.png";
    private static final String EXIT_INACTIVE_BUTTON    = "screens/menu/buttons/exit_inactive.png";
    private static final String EXIT_ACTIVE_BUTTON      = "screens/menu/buttons/exit_active.png";
    private static final String CREDITS_INACTIVE_BUTTON = "screens/menu/buttons/credits_inactive.png";
    private static final String CREDITS_ACTIVE_BUTTON   = "screens/menu/buttons/credits_active.png";

    private final List<Texture> textureList;
    private final Texture boxImage;
    private final Texture logoImage;
    private final Texture playButton;
    private final Texture exitButton;
    private final Texture creditsButton;

    private int parallaxSpeed;
    private int parallaxScroll;

    public ParallaxMenuBackground() {
        this.textureList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            textureList.add(new Texture(Gdx.files.internal(String.format(BACKGROUND_IMAGE_RESOURCE, i))));
            textureList.get(i).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        this.boxImage = new Texture(Gdx.files.internal(MENU_BOX_IMAGE));
        this.logoImage = new Texture(Gdx.files.internal(MENU_LOGO_IMAGE));
        this.playButton = new Texture(Gdx.files.internal(PLAY_INACTIVE_BUTTON));
        this.exitButton = new Texture(Gdx.files.internal(EXIT_INACTIVE_BUTTON));
        this.creditsButton = new Texture(Gdx.files.internal(CREDITS_INACTIVE_BUTTON));

        this.parallaxScroll = 0;
        this.parallaxSpeed = 0;
    }

    public void setParallaxSpeed(int speed) {
        this.parallaxSpeed = speed;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);

        this.parallaxScroll += this.parallaxSpeed;
        for (int i = 0; i < textureList.size(); i++) {
            int srcX = this.parallaxScroll + i * this.parallaxScroll;
            batch.draw(textureList.get(i),
                    0,
                    0,
                    0,
                    0,
                    Gdx.graphics.getWidth(),
                    Gdx.graphics.getHeight(),
                    1,
                    1,
                    0,
                    srcX,
                    0,
                    textureList.get(i).getWidth(),
                    textureList.get(i).getHeight(),
                    false,
                    false);
        }

        float width = (float) Gdx.graphics.getWidth() / 2;
        float height = (float) Gdx.graphics.getHeight() / 2;
        batch.draw(boxImage,
                width - (boxImage.getWidth() * 1.0f / 2),
                height - (boxImage.getHeight() * 1.0f / 2),
                boxImage.getWidth(),
                boxImage.getHeight());
        batch.draw(logoImage,
                width - (boxImage.getWidth() * 1.0f / 2) - 15,
                height,
                logoImage.getWidth(),
                logoImage.getHeight());
        batch.draw(playButton,
                width - (playButton.getWidth() * 1.0f / 2),
                (height - (playButton.getHeight() * 1.0f / 2)) + (playButton.getHeight() + 20),
                playButton.getWidth(),
                playButton.getHeight());
        batch.draw(creditsButton,
                width - (creditsButton.getWidth() * 1.0f / 2),
                height - (creditsButton.getHeight() * 1.0f / 2),
                creditsButton.getWidth(),
                creditsButton.getHeight());
        batch.draw(exitButton,
                width - (exitButton.getWidth() * 1.0f / 2),
                (height - (exitButton.getHeight() * 1.0f / 2)) - (exitButton.getHeight() + 20),
                exitButton.getWidth(),
                exitButton.getHeight());
    }
}
