package com.thewarriors.scenes;

import android.graphics.Color;
import android.graphics.Typeface;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.util.GLState;

/**
 * Created by kshitiz on 9/17/15.
 */
public class SplashScene extends BaseScene {
    private Sprite splash;
    @Override
    public void createScene() {

        IFont myfont = FontFactory.create(resourceManager.activity.getFontManager(), resourceManager.activity.getTextureManager(), 256, 256, Typeface.create(Typeface.SERIF, Typeface.BOLD), 48,false, Color.WHITE);
        myfont.load();
        IFont myfont1 = FontFactory.create(resourceManager.activity.getFontManager(), resourceManager.activity.getTextureManager(), 256, 256, Typeface.create(Typeface.SERIF, Typeface.BOLD), 32,false, Color.WHITE);
        myfont1.load();
        Text text = new Text(175,180,myfont,"The Warriors",resourceManager.vbom);
        Text subText = new Text(175,250,myfont1,"Fight with Pride",resourceManager.vbom);
        splash = new Sprite(0, 0, resourceManager.camera.getWidth(),resourceManager.camera.getHeight(),resourceManager.splashRegion, manager)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        splash.setScale(1.5f);
        splash.setPosition(50, 50);
        attachChild(splash);
        attachChild(text);
        attachChild(subText);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
        splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();

    }
}
