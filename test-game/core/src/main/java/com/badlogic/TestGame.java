package com.badlogic;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class TestGame implements ApplicationListener {
	@Override
	public void create () {
	}

	@Override
	public void dispose () {
	}

	@Override
	public void pause () {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize (int arg0, int arg1) {
	}

	@Override
	public void resume () {
	}
}
