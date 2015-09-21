package com.thewarriors.scenes;

import android.app.Activity;

import com.thewarrirors.ResourceManager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by kshitiz on 9/17/15.
 */
public abstract class BaseScene extends Scene {

    protected Engine engine;
    protected Activity activity;
    protected ResourceManager resourceManager;
    protected VertexBufferObjectManager manager;
    protected Camera camera;

    public BaseScene()
    {
        this.resourceManager = ResourceManager.getInstance();
        this.engine = resourceManager.engine;
        this.activity = resourceManager.activity;
        this.manager = resourceManager.vbom;
        this.camera = resourceManager.camera;
        createScene();
    }

    //---------------------------------------------
    // ABSTRACTION
    //---------------------------------------------

    public abstract void createScene();

    public abstract void onBackKeyPressed();

    public abstract SceneManager.SceneType getSceneType();

    public abstract void disposeScene();
}

