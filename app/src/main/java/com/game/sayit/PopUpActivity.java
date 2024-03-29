package com.game.sayit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class PopUpActivity extends Activity 
{
	private TextView tvPoint,tvJawaban;
	private ImageView imgVGambar;
	private final int delayTime = 2000;
	private Handler myHandler = new Handler();
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) 
	 {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpopup);
		
		tvPoint =(TextView) findViewById(R.id.tvPoint);
		tvJawaban =(TextView) findViewById(R.id.tvJawabanAnda);
		
		imgVGambar =(ImageView) findViewById(R.id.imgVGambar);		
		
		Bundle var = getIntent().getExtras();
		if (var.getString("state").equals("1")) 
		{
			tvPoint.setText("+20 Point");
			imgVGambar.setImageResource(R.drawable.imgcorrect);
			tvJawaban.setText("Jawaban Anda : " + var.getString("suara"));
		}else	if (var.getString("state").equals("0"))  {
			tvPoint.setText("-5 Point");
			imgVGambar.setImageResource(R.drawable.imgsorry);
			tvJawaban.setText("Jawaban Anda : " + var.getString("suara"));
		}else if (var.getString("state").equals("2"))  {
			tvPoint.setText("- GAME OVER -");
			tvJawaban.setText("");
			imgVGambar.setImageResource(R.drawable.imgcorrect);
		}else if (var.getString("state").equals("4"))  {
			tvPoint.setText("- SELAMAT, ANDA SUKSES -");
			tvJawaban.setText("<< ANDA BERHASIL MENYELESAIKAN MAZE INI >>");
			imgVGambar.setImageResource(R.drawable.imgcorrect);
		}else if (var.getString("state").equals("5"))  {
			tvPoint.setText("- WRONG WAY -");
			tvJawaban.setText("<< ANDA SALAH MEMILIH JALAN >>");
			imgVGambar.setImageResource(R.drawable.imgsorry);
		}else if (var.getString("state").equals("6"))  {
			tvPoint.setText("- GAME OVER -");
			tvJawaban.setText("<< ANDA GAGAL MENYELESAIKAN MAZE INI >>");
			imgVGambar.setImageResource(R.drawable.imgsorry);
		}
		
		myHandler.postDelayed(closePopUp, delayTime);
	}
	 
	 private Runnable closePopUp= new Runnable() {
		    public void run() {
		        finish();
		       // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
		    }
		};
  
}
