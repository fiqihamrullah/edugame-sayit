package com.game.sayit;

 

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView imgVBtnLearn,imgBtnPlay,imgVBtnSound,imgVBtnTutup,imgBtnInfo;
    MediaPlayer mMediaPlayer;
    boolean nosound =false;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		mMediaPlayer = MediaPlayer.create(this, R.raw.awal);  
		setContentView(R.layout.activity_main);
		initComponent();
	
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		if (!nosound) 
		{
	        mMediaPlayer.setLooping(true);
	        mMediaPlayer.start();
		}
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if (!nosound) 
		{
		mMediaPlayer.start();
		}
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if (!nosound) 
		{
		  mMediaPlayer.pause();
		}
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		mMediaPlayer.stop();
		mMediaPlayer.release();
		super.onDestroy();
	}
	
	public void initComponent()
	{
		imgVBtnLearn = (ImageView) findViewById(R.id.imgVBtnLearn);
		imgVBtnLearn.setOnClickListener(clickBtnLearn);
		
		imgBtnPlay = (ImageView) findViewById(R.id.imgBtnPlay);	 
		imgBtnPlay.setOnClickListener(clickBtnPlay);
		
		imgVBtnSound = (ImageView) findViewById(R.id.imgVBtnSound);	 
		imgVBtnSound.setOnClickListener(clickBtnSound);
		
		imgVBtnTutup = (ImageView) findViewById(R.id.imgBtnTutup);	
		imgVBtnTutup.setOnClickListener(clickBtnTutup);
		
		imgBtnInfo =(ImageView) findViewById(R.id.imgBtnInfo);
		imgBtnInfo.setOnClickListener(clickBukaInfo);
		
		
	}
	
	private OnClickListener clickBukaInfo= new OnClickListener() 
	{		
		@Override
		public void onClick(View v)
		{			
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), ViewHowToPlayActivity.class).putExtra("state","1"));
		}
	};
	
private OnClickListener clickBtnSound = new OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			nosound=!nosound;
			if (nosound) {
			  mMediaPlayer.pause();
			}else{
				mMediaPlayer.start();
			}
		}
	};
	
private OnClickListener clickBtnTutup= new OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			finish();
		}
	};
	
private OnClickListener clickBtnPlay = new OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), MenuPlayActivity.class));
		}
	};
	
	private OnClickListener clickBtnLearn = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
			startActivity(new Intent(getApplicationContext(), MenuLearnActivity.class));
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
