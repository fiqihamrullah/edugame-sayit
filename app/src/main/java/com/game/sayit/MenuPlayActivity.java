package com.game.sayit;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MenuPlayActivity extends Activity 
{ 
	ImageView imgBtnHighScore,imgBtnHowToPlay,imgBtnBack,imgVPlayGames,imgVBtnSound;
	  MediaPlayer mMediaPlayer;
	  TextView tvPlayerName;
	  EditText tvNmP ;
	  boolean nosound=false;
     @Override
    protected void onCreate(Bundle savedInstanceState) 
     {    	 
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.gamemenu);
    	mMediaPlayer = MediaPlayer.create(this, R.raw.play);       
    	initComponent();
    }    
     
     @Override
    protected void onStart() 
     {
    	// TODO Auto-generated method stub
    	 if (!nosound) {
    	 mMediaPlayer.setLooping(true);
         mMediaPlayer.start();
    	 }
         GameDatabase gd = new GameDatabase(getApplicationContext());
         gd.CreateTablePlayer();
         gd.CreateTableScore();
         
         if (!gd.hasPlayer())
         {
            // This example shows how to add a custom layout to an AlertDialog
            LayoutInflater factory = LayoutInflater.from(this);           
            View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
            tvNmP =(EditText) textEntryView.findViewById(R.id.edNmPlayer); 
        	  // tvNmP =(EditText) 
            final    AlertDialog dlg = new  AlertDialog.Builder(MenuPlayActivity.this)
            //   .setIconAttribute(android.R.attr.)
             .setTitle("Masukkan Nama Anda:")
             .setView(textEntryView)
             
             .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int whichButton) {
         
                     /* User clicked OK so do some stuff */
                 	 GameDatabase gd = new GameDatabase(getApplicationContext());
                 	 if (tvNmP.getText().toString().equals("")) {
                 		Toast.makeText(getApplicationContext(), "Nama Pemain tidak boleh kosong ", 4000).show();
                 		MenuPlayActivity.this.finish();
                 	 }else{
                	  gd.AddPlayer(tvNmP.getText().toString());
                	  Toast.makeText(getApplicationContext(), "Nama Pemain Sukses Diciptakan ", 4000).show();
                 	 }
                 }
             })
             .setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int whichButton) {
                	 

                     /* User clicked cancel so do some stuff */
                 }
             })
             .create();
             dlg.show();
         }else {
         	  
        	 tvPlayerName.setText(gd.getPlayerName());
         }
    	super.onStart();
    }
     
     @Override
    protected void onPause() 
     {
    	// TODO Auto-generated method stub
    	// mMediaPlayer.pause();
    	super.onPause();
    }
     
     @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	 if (!nosound) {
    	 mMediaPlayer.start();
    	 }
    	super.onResume();
    }
     
    
     
     @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	 mMediaPlayer.stop();
    	 mMediaPlayer.release();
    	super.onDestroy();
    }
     
  
     
     public void onBackPressed() {
    	/*
    	  Intent intent = new Intent();
          intent.setClass(MenuPlayActivity.this,MainActivity.class);
          startActivity(intent); */  
          MenuPlayActivity.this.finish();
     };
     
     
     private void initComponent()
     {
     
    	 imgBtnHighScore = (ImageView) findViewById(R.id.imgBtnHighScore);
    	 imgBtnHowToPlay = (ImageView) findViewById(R.id.imgBtnHowToPlay);
    	 imgBtnBack = (ImageView) findViewById(R.id.imgBtnBack);  
    	 imgVPlayGames =(ImageView) findViewById(R.id.imgVPlayGames);
    	 tvPlayerName =(TextView) findViewById(R.id.tvPlayerName);
    	 imgVBtnSound =(ImageView) findViewById(R.id.imgBtnSound);   
    	 imgVPlayGames.setOnClickListener(clickBukaGame);
    
    	 imgBtnHighScore.setOnClickListener(clickBukaHighScore);
    	 imgBtnHowToPlay.setOnClickListener(clickBagaimanaBermain);
    	 imgBtnBack.setOnClickListener(clickKembali);
    	 imgVBtnSound.setOnClickListener(clickBunyiSuara);
    	 tvPlayerName.setOnClickListener(clickEditPlayerName);
    	 
    	 
     }
     
     private OnClickListener clickEditPlayerName = new OnClickListener() {
		
		@Override
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			GameDatabase gd = new GameDatabase(getApplicationContext());
			 // This example shows how to add a custom layout to an AlertDialog
            LayoutInflater factory = LayoutInflater.from(MenuPlayActivity.this);
           
              View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
              tvNmP =(EditText) textEntryView.findViewById(R.id.edNmPlayer); 
              tvNmP.setText(gd.getPlayerName());
        	  // tvNmP =(EditText) 
            final    AlertDialog dlg = new  AlertDialog.Builder(MenuPlayActivity.this)
            //   .setIconAttribute(android.R.attr.)
             .setTitle("Masukkan Nama Anda:")
             .setView(textEntryView)
             
             .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int whichButton) {
         
                     /* User clicked OK so do some stuff */
               	 GameDatabase gd = new GameDatabase(getApplicationContext());
               
             	
                	 gd.SetPlayer(tvNmP.getText().toString());
                	 Toast.makeText(getApplicationContext(), "Nama Pemain Sukses Diperbaharui ", 4000).show();
                 }
             })
             .setNegativeButton("Reset", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int whichButton) {
                	 

                     /* User clicked cancel so do some stuff */
                 }
             })
             .create();
           
           
             dlg.show();
		   	
		}
	};
     
     private OnClickListener clickBunyiSuara = new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			nosound = !nosound;
 			if (nosound){
 				mMediaPlayer.pause();
 			}else{
 				mMediaPlayer.start();
 			}
 		}
 	};
      
     
     private OnClickListener clickBukaGame = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			GameDatabase gd = new GameDatabase(getApplicationContext());
			 if (gd.hasPlayer())
			 {
			startActivity(new Intent(getApplicationContext(), OptionsPlayGameActivity.class));
			 }else{
				 Toast.makeText(getApplicationContext(), "Nama Pemain Belum Dibuat!", 4000).show();
			 }
		}
	};
     
     private OnClickListener clickBukaPlayer = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private OnClickListener clickBukaHighScore = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), ViewHighScoreActivity.class));
		}
	};
	
	private OnClickListener clickBagaimanaBermain = new OnClickListener() 
	{		
		@Override
		public void onClick(View v)
		{			
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), ViewHowToPlayActivity.class).putExtra("state", "2"));
		}
	};
	
	private OnClickListener clickKembali  = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MenuPlayActivity.this.finish();
		}
	};
      
     
}
