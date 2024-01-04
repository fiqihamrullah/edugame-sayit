package com.game.sayit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.speech.RecognizerIntent;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGamePictureActivity extends Activity
{
	TextView tvQuestion,tvScore;
	ImageView imgVBtnAnswer,imgVBtnHome,imgVSoal,imgVBtnHelp;
	protected static final int RESULT_SPEECH = 1;
	SoalGambarPlayer sgp;
	private final int delayTime = 3000;
	private Handler myHandler = new Handler();
	private String keyname="";
	private int chance=0;
	
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewgamepicture);
		
		initComponent();
		
		Bundle var = getIntent().getExtras();
		SoalGambar sg = new SoalGambar();
		if (var.getInt("pil")==0) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_HEWAN);
	     	keyname = "Animal";
	   	    tvQuestion.setText("What is the name of this animal?");
		}else if (var.getInt("pil")==1) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_BUAH2AN);
	     	keyname = "Fruits";
	     	 tvQuestion.setText("What is the name of this fruits?");
		}else if (var.getInt("pil")==2) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_COLOR);
	     	keyname = "Colors";
	     	 tvQuestion.setText("What is the name of this color?");
		}else if (var.getInt("pil")==3) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_BODYPARTS);
	     	keyname = "Body Parts";
	     	 tvQuestion.setText("What is the name of this bodyparts?");
		}else if (var.getInt("pil")==4) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_SCHOOLS);
	     	keyname = "School";
	     	 tvQuestion.setText("What is the name of this schools?");
		}else if (var.getInt("pil")==7) 
		{		
	     	sg.setSoal(getResources(), SoalGambar.KATEGORI_TRANSPORTATION);
	     	keyname = "Transportations";
	     	tvQuestion.setText("What is the name of this transportation?");
		}
		
		sgp = new SoalGambarPlayer(sg);
		//sgp.firstPicture();
		imgVSoal.setImageResource(sgp.firstPicture());
	}
	 
	 private void initComponent()
	 {
		 tvQuestion = (TextView)findViewById(R.id.tvQuestion);
		 tvScore = (TextView)findViewById(R.id.tvScore);
	
		 
		 imgVBtnAnswer =(ImageView) findViewById(R.id.imgVBtnAnswer);
		 imgVBtnAnswer.setOnClickListener(clickToNextPlay);
		 
		 imgVBtnHome =(ImageView) findViewById(R.id.imgVBtnHome);
		 imgVBtnHome.setOnClickListener(clickToHome);
		 
		 imgVSoal =(ImageView) findViewById(R.id.imgVSoal);
		 
		 imgVBtnHelp =(ImageView) findViewById(R.id.imgVBtnHelp);
		 imgVBtnHelp.setOnClickListener(clickViewHelp);
		 
		 
	 }
	 
	 private OnClickListener clickViewHelp = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), ViewHelpActivity.class).putExtra("jawaban",sgp.getCurrentJawaban()));
				sgp.getGameScore().addHelp();
			}
		};
	 
	 private OnClickListener clickToNextPlay = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent intent = new Intent(
					RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en");

			try {
				startActivityForResult(intent, RESULT_SPEECH);
				 
			} catch (ActivityNotFoundException a) {
				Toast t = Toast.makeText(getApplicationContext(),
						"Ops! Your device doesn't support Speech to Text",
						Toast.LENGTH_SHORT);
				t.show();
			}
		}
	};
	
	 private Runnable closeSelf= new Runnable() {
		    public void run() {
		    	finish();
		    }
		};
	
	 private Runnable gotoGameOver= new Runnable() {
		    public void run() {
		    	startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtra("state", "0"));
		       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		    	GameDatabase gd = new GameDatabase(getApplicationContext());
		    	gd.SetScore(keyname, sgp.getGameScore().getTotalScore());
		    	myHandler.postDelayed(closeSelf, delayTime);
		    }
		};
	 
	 private OnClickListener clickToHome = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			PlayGamePictureActivity.this.finish();
		}
	};
	
	public void nextPicture()
	{
		 tvScore.setText(String.valueOf(sgp.getGameScore().getTotalScore()));
			if (!sgp.IsLastPicture()) 
			{								
			    imgVSoal.setImageResource(sgp.nextPicture());
			   
			}else{
				myHandler.postDelayed(gotoGameOver, delayTime);
				
				 
			}
	}
  
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case RESULT_SPEECH: {
			if (resultCode == RESULT_OK && null != data) 
			{

				ArrayList<String> text = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				//txtText.setText(text.get(0));
				Log.i("Hasil Suara", text.get(0));
				Bundle extras = new Bundle();
				extras.putString("suara",text.get(0));
				if (sgp.checkJawaban(text.get(0).toLowerCase())) 
				{
					extras.putString("state", "1");	
					chance=0;
					startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));
					sgp.getGameScore().addBenar();
					nextPicture();
					
				}else{
					if (chance<3) 
					{
					  chance++;
					  Toast.makeText(getApplicationContext(), "Ulangi Kembali,Jawaban Anda tadi " +text.get(0) , 3000).show();
					}else{
					  chance=0;
					  extras.putString("state", "0");
					  startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));
					  sgp.getGameScore().addSalah();
					  nextPicture();
					}
					 
				}
				
			   
			}
			break;
		}

		}
	}
	
	
}
