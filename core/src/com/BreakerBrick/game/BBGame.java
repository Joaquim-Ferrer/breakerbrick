package com.BreakerBrick.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import BBHelper.AssetLoader;
import Screens.MenuScreen;

public class BBGame extends Game {
	
	@Override
	public void create ()
	{
		//Utilizacao do AssetLoader
		AssetLoader.load();
        setScreen(new MenuScreen(this));
	}

    @Override
    public void dispose()
    {
        super.dispose();
        AssetLoader.dispose();
    }
}
