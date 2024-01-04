package com.game.sayit;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class ViewHelpActivity extends Activity 
{
	TextView tvHelp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewhelp);
		tvHelp  =(TextView) findViewById(R.id.tvJawaban);
		Bundle var = getIntent().getExtras();
		String help= var.getString("jawaban");		 
		tvHelp.setText(help);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		finish();
		return super.onTouchEvent(event);
	}

}
