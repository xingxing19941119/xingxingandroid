package com.example.villagesoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Picture extends Activity {
	private ImageView iv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture);
		iv = (ImageView) findViewById(R.id.imageView1);
		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(2000);
		iv.startAnimation(anima);
		anima.setAnimationListener(new AnimationImpl());
		// Handler handler = new Handler();
		// handler.postDelayed(new splashhandle(), 2000);

	}

	// class splashhandle implements Runnable {
	//
	// @Override
	// public void run() {
	// startActivity(new Intent(Picture.this, MainActivity.class));
	// Picture.this.finish();
	// }
	// }

	class AnimationImpl implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			iv.setBackgroundResource(R.drawable.fba);
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			skip();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub

		}

	}

	private void skip() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

}