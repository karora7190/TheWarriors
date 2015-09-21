package com.thewarrirors;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by kshitiz on 9/16/15.
 */
public class ResourceManager {
    private static final ResourceManager INSTANCE = new ResourceManager();

    public Engine engine;
    public SplashScreen activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
    public ITextureRegion splashRegion;
    private BitmapTextureAtlas bitmapTextureAtlas;
    private Music music;

    //---------------------------------------------
    // TEXTURES & TEXTURE REGIONS
    //---------------------------------------------

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    public void loadMenuResources()
    {
        loadMenuGraphics();
        loadMenuAudio();
    }

    public void loadGameResources()
    {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics()
    {

    }

    private void loadMenuAudio()
    {

    }

    private void loadGameGraphics()
    {

    }

    private void loadGameFonts()
    {

    }

    private void loadGameAudio()
    {
        MusicFactory.setAssetBasePath("mfx/");
        try{
            music = MusicFactory.createMusicFromAsset(engine.getMusicManager(),activity.getBaseContext(),"gametrack.mp3");
            music.setLooping(true);
            music.play();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadSplashScreen()
    {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        bitmapTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(),1024,512, TextureOptions.NEAREST_PREMULTIPLYALPHA);
        splashRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas,activity, "back2.png",0,0);
        bitmapTextureAtlas.load();
    }

    public void unloadSplashScreen()
    {
        bitmapTextureAtlas.unload();
        splashRegion = null;
    }

    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     * <br><br>
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, SplashScreen activity, Camera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static ResourceManager getInstance()
    {
        return INSTANCE;
    }
}
