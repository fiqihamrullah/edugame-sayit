package com.game.sayit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ViewHowToPlayActivity extends Activity 
{
	private ImageView imgVGambar;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewhtplay);
		
		imgVGambar =(ImageView) findViewById(R.id.imgVPetunjuk);	
		Bundle var = getIntent().getExtras();
		if (var.getString("state").equals("1")) 
		{		 
			imgVGambar.setImageResource(R.drawable.gameinformation);
		 
		}else	if (var.getString("state").equals("2"))  {
			 
			imgVGambar.setImageResource(R.drawable.petunjukutama);
		 
		} 
		
	}
	
	
	

}
