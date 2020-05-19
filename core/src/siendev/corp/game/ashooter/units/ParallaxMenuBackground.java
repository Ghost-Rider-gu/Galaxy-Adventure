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

    private static final String BACKGROUND_IMAGE_RESOURCE = "screens/menu/background/back_planet%s.png";
    private static final String MENU_BOX_IMAGE = "screens/menu/menu_box.png";
    private static final String MENU_LOGO_IMAGE = "screens/menu/menu_logo.png";

    private final List<Texture> textureList;
    private final Texture boxImage;
    private final Texture logoImage;

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
        batch.draw(boxImage,
                (Gdx.graphics.getWidth() / 2) - (boxImage.getWidth() / 2),
                (Gdx.graphics.getHeight() / 2) - (boxImage.getHeight() / 2),
                boxImage.getWidth(),
                boxImage.getHeight());
        batch.draw(logoImage,
                (Gdx.graphics.getWidth() / 2) - (boxImage.getWidth() / 2) - 15,
                (Gdx.graphics.getHeight() / 2),
                logoImage.getWidth(),
                logoImage.getHeight());
    }
}
