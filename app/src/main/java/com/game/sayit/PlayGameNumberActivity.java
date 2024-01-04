package com.game.sayit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameNumberActivity extends Activity 
{
	TextView tvQuestion,tvScore;
	ImageView imgVBtnAnswer,imgVBtnHome,imgVOp1,imgVOp2,imgVOperator,imgVBtnHelp;
	protected static final int RESULT_SPEECH = 1;
	SoalNumberPlayer snp;
	private final int delayTime = 3000;
	private Handler myHandler = new Handler();
	private String keyname="Math";
	private int chance=0;
             @Override
            protected void onCreate(Bundle savedInstanceState)
             {
            	// TODO Auto-generated method stub
            	super.onCreate(savedInstanceState);
            	setContentView(R.layout.viewgamenumber);
            	initComponent();
            	snp = new SoalNumberPlayer();
            	showSoal(snp.generateSoal());
            }
             
            private void showSoal(SoalNumber sn)
            {
            	imgVOp1.setImageResource(sn.getOperandKiri());
            	imgVOp2.setImageResource(sn.getOperandKanan());
            	imgVOperator.setImageResource(sn.getIntOperator());
            	
            }
            
            private Runnable closeSelf= new Runnable() {
    		    public void run() {
    		    	finish();
    		    }
    		};
    	
    	 private Runnable gotoGameOver= new Runnable() {
    		    public void run() {
    		    	startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtra("state", "2"));
    		       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    		    	GameDatabase gd = new GameDatabase(getApplicationContext());
    		    	gd.SetScore(keyname, snp.getGameScore().getTotalScore());
    		    	myHandler.postDelayed(closeSelf, delayTime);
    		    }
    		};
             
             private void initComponent()
        	 {
        		 tvQuestion = (TextView)findViewById(R.id.tvQuestion);
        		 tvScore = (TextView)findViewById(R.id.tvScore);
        		 tvQuestion.setText("Count This Number...!!");
        		 
        		 imgVBtnAnswer =(ImageView) findViewById(R.id.imgVBtnAnswer);
        		 imgVBtnAnswer.setOnClickListener(clickToNextPlay);
        		 
        		 imgVBtnHome =(ImageView) findViewById(R.id.imgVBtnHome);
        		 imgVBtnHome.setOnClickListener(clickToHome);
        		 
        		 imgVOp1=(ImageView) findViewById(R.id.imgVOp1);
        		 imgVOp2=(ImageView) findViewById(R.id.imgVOp2);
        		 imgVOperator=(ImageView) findViewById(R.id.imgVOperator);
        		 
        		 imgVBtnHelp =(ImageView) findViewById(R.id.imgVBtnHelp);
        		 imgVBtnHelp.setOnClickListener(clickViewHelp);
        		 
        		 
        		 
        	 }
             
             private OnClickListener clickViewHelp = new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getApplicationContext(), ViewHelpActivity.class).putExtra("jawaban",snp.getCurrentJawaban()));
					snp.getGameScore().addHelp();
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
         	
         	private void nextSoal()
         	{
         		 tvScore.setText(String.valueOf(snp.getGameScore().getTotalScore()));
  				if (!snp.IsLastofGame()) 
  				{
  								
  					showSoal(snp.generateSoal());
  				   
  				}else {
  					myHandler.postDelayed(gotoGameOver, delayTime);
  				}
         	}
         	 
         	 private OnClickListener clickToHome = new OnClickListener() {
         		
         		@Override
         		public void onClick(View v) {
         			// TODO Auto-generated method stub
         			PlayGameNumberActivity.this.finish();
         		}
         	};
           
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
         				if (snp.check(text.get(0))) 
         				{
         					chance=0;
         					extras.putString("state", "1");	
         					startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));
         					nextSoal();
         					snp.getGameScore().addBenar();
         				}else{
         					if (chance<3) 
        					{
        					  chance++;
        					  Toast.makeText(getApplicationContext(), "Ulangi Kembali,Jawaban Anda tadi " +text.get(0) , 3000).show();
        					}else{
        					  chance=0;
         					  extras.putString("state", "0");	
         					  startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));
         					  nextSoal();
         					  snp.getGameScore().addSalah();
        					}
         				}
         			   
         			}
         			break;
         		}

         		}
         	}
             
}
