package com.badlogic.android;

import com.badlogic.TestGame;

import android.app.Activity;
import android.os.Bundle;

public class TestGameActivity extends Activity {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new TestGame();
	}
}
