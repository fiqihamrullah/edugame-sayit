package com.game.sayit;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;

public class ViewDetailKategoriActivity extends Activity implements TextToSpeech.OnInitListener
{
	ImageView imgGambarTerpilih;
	GalleryImageAdapter gia;
	ImageView imgVBack,imgVHome,imgVTranslate,imgVSayit;
	TextView tvIndo,tvInggris;
	String textIndo[];
	String textIng[];
	  private TextToSpeech tts;
	int idxgambar=0;
	
           @Override
        protected void onCreate(Bundle savedInstanceState) 
        {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.viewdetailkategori);
         
        	Bundle var = getIntent().getExtras();
        	int pil = var.getInt("pil");
        	Resources res = getResources();
        	if (pil==0){
        		textIndo = res.getStringArray(R.array.nama_hewan_indo);
        		textIng = res.getStringArray(R.array.nama_hewan_inggris);
        		
        	}else if (pil==1){
        		textIndo = res.getStringArray(R.array.nama_buah_indo);
        		textIng = res.getStringArray(R.array.nama_buah_inggris);
        		
        	}else if (pil==2){
        		textIndo = res.getStringArray(R.array.nama_warna_indo);
        		textIng = res.getStringArray(R.array.nama_warna_inggris);
        		
        	}else if (pil==3){
        		textIndo = res.getStringArray(R.array.nama_bodyparts_indo);
        		textIng = res.getStringArray(R.array.nama_bodyparts_inggris);
        		
        	}else if (pil==4){
        		textIndo = res.getStringArray(R.array.nama_school_indo);
        		textIng = res.getStringArray(R.array.nama_school_inggris);        		
        	}else if (pil==5){
        		textIndo = res.getStringArray(R.array.nama_alphabet_indo);
        		textIng = res.getStringArray(R.array.nama_alphabet_indo);        		
        	}else if (pil==6){
        		textIndo = res.getStringArray(R.array.nama_numbers_indo);
        		textIng = res.getStringArray(R.array.nama_numbers_inggris);        		
        	}else if (pil==7){
        		 textIndo = res.getStringArray(R.array.nama_transports_indo);
        		 textIng = res.getStringArray(R.array.nama_transports_inggris);        		
        	}
        	
        	
        	gia =   new GalleryImageAdapter(this,pil);
        	Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        	imgGambarTerpilih=(ImageView)findViewById(R.id.imgVGambar);
            gallery.setSpacing(1);
            gallery.setAdapter(gia); 
             
            initComponent();
            
            tts = new TextToSpeech(this, this);
             
            gallery.setOnItemClickListener(new OnItemClickListener() 
            {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					idxgambar = arg2;
					tvIndo.setText("");
					tvInggris.setText(textIng[idxgambar]);
					imgGambarTerpilih.setImageResource(gia.currentImage[arg2]);
				}
			});
             
             
        }
           
       private void initComponent()
       {
    	   imgVBack = (ImageView) findViewById(R.id.imgVBack);
    	   imgVHome = (ImageView) findViewById(R.id.imgVHome); 
    	   imgVTranslate = (ImageView) findViewById(R.id.imgVTranslate);
    	   imgVSayit = (ImageView) findViewById(R.id.imgVSayit);  
    	   
    	   tvIndo = (TextView) findViewById(R.id.tvIndo);
    	   tvInggris = (TextView) findViewById(R.id.tvInggris);
    	   
    	   
    	   imgVBack.setOnClickListener(clickBack);
    	   imgVHome.setOnClickListener(clickToHome);
    	   
    	   imgVTranslate.setOnClickListener(clickTranslate);
    	   imgVSayit.setOnClickListener(clickSayit);
        	   
       }
       
       private OnClickListener clickTranslate = new OnClickListener() 
       {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tvIndo.setText(textIndo[idxgambar]);
		}
	};
	
	private OnClickListener clickSayit = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			speakOut();
		}
	};
           
       private OnClickListener clickBack =  new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ViewDetailKategoriActivity.this.finish();
		}
	};
	
	
	
	  private OnClickListener clickToHome = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), MainActivity.class));
		
			finish();
		}
	};

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if (status == TextToSpeech.SUCCESS) {
			 
            int result = tts.setLanguage(Locale.US);
 
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
               // btnSpeak.setEnabled(true);
                speakOut();
            }
 
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
	}
	
	private void speakOut()
	{
		String text = textIng[idxgambar];
		tvInggris.setText(textIng[idxgambar]);
		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
           
           
           
           
           
}
