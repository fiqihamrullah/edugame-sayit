package com.game.sayit;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
 

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
 
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
 

public class MazeGame extends Activity {
 
    private MazeView mMazeView;	
    protected static final int RESULT_SPEECH = 1;
    private int chance=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	mMazeView = new MazeView(this);    
    	setContentView(mMazeView);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
    	return super.onTouchEvent(event);
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
 				String jawaban =text.get(0);
 				
 				if (jawaban.length() > 1) 
 				{
 					chance++;
 					if (chance<3){
 						Toast.makeText(getApplicationContext(), "Ulangi, Ucapan Anda Tadi : " + jawaban, 3000).show();
 	 					
 					}else if (chance==3)
 					{ 						 
 						Toast.makeText(getApplicationContext(), "Ulangi, Ucapan Anda Tadi : " + jawaban + ", Atau Gunakan Ucapan Panjang Menurut Inisialnya\n Misal A berarti Apple", 3000).show();
 					}else if (chance>3){
 						chance=0;
 						String ch = String.valueOf(jawaban.charAt(0)).toUpperCase();
 	 					Toast.makeText(getApplicationContext(), "Ucapan Anda: " + ch  , 2000).show();
 	 					mMazeView.setActiveNode(ch);
 					}
 				}else{
 					chance=0;
 					Toast.makeText(getApplicationContext(), "Ucapan Anda: " + jawaban.toUpperCase(), 2000).show();
 					mMazeView.setActiveNode(jawaban.toUpperCase());
 				}
 			}
 			break;
 		}

 		}
 	}
	
	  private class MazeView extends View implements Runnable
	    {	    		  
	        private Bitmap  mBitmap;
	        private Bitmap  mBitmapScaled;
	        private Bitmap  mBitmapOriScaled;
	        
	        private Paint   mPaint = new Paint();
	        private Canvas  mCanvas = new Canvas(); 
 
	        private int     mColors[] = new int[3*2];
	        	
	        private float scale_x;
	        private float scale_y;
	        
 
	        private float   mWidth;
	        private float   mHeight;
	        private boolean bStop=false;
	        
	        int chanceEP=0;
	        int no=0;
	        
	        //Maze
	        int gbrmaze[] = new int[] {R.drawable.maze1,R.drawable.maze2,R.drawable.maze3,R.drawable.maze4,R.drawable.maze5,R.drawable.maze6,R.drawable.maze7,R.drawable.maze8,R.drawable.maze9,R.drawable.maze10};
	        
	        //Jumlah Node
	        int jnode[] = new int[]{8,13,14,15,15,15,16,16,20,24};
	        
	        //Posisi Titik Di dalam Maze
	        String  posisimaze1[] = new String[]{"374;302","466;354","564;436","594;632","564;768","656;824","754;912","848;994"};
	        String posisimaze2[] = new String[]{"372;243","260;105","248;573","568;403","816;551","1204;339","572;571","374;833","1382;227","1314;547","1070;677","1154;765","1326;831"};
	        String posisimaze3[] = new String[]{"1357;134","1035;286","245;282","403;392","593;314","745;392","341;820","193;924","1359;966","749;970","1053;584","1183;782","879;400","959;790"};
	        String posisimaze4[] = new String[]{"168;247","308;393","168;611","826;823","1148;397","574;611","292;787","178;907","574;895","294;995","710;819","828;941","1288;611","1392;817","1290;1019"};
	        String posisimaze5[] = new String[]{"366;242","298;440","552;242","772;176","1064;302","618;496","892;502","844;510","484;700","796;708","408;842","644;978","810;896","946;742","1176;936"};
	        String posisimaze6[] = new String[]{"259;385","261;101","513;579","265;883","503;159","749;159","1031;243","1393;407","509;437","839;385","1295;497","575;883","973;697","1193;700","1393;593"};
	        String posisimaze7[] = new String[]{"957;591","855;405","737;589","739;105","1205;105","1203;887","1207;1021","125;1023","583;737","453;881","301;325","105;881","155;439","105;103","407;359","561;400"};
	        String posisimaze8[] = new String[]{"106;832","562;830","488;652","126;586","336;394","130;44","746;260","830;176","1214;44","768;462","656;750","966;832","916;262","1042;510","1042;750","1218;832"};
	        String posisimaze9[] = new String[]{"295;237","295;367","839;237","493;119","841;367","1065;119","1065;387","665;367","827;541","729;719","307;543","425;695","207;807","269;975","577;935","1063;817","431;1045","781;941","1349;661","1007;1035"};
	        String posisimaze10[] = new String[]{"250;260","250;164","568;474","164;590","482;706","250;854","434;936","398;260","546;140","696;234","808;142","968;36","1246;240","1436;424","566;396","566;614","848;396","848;572","1162;470","1334;588","1254;718","1164;876","896;806","566;806"};
	        
	        //Simpul Terhubung
	        String csimpul1[] = new String[] {"B","A;C","B;D","C;E","D;F","E;G","F;H","G"};
	        String csimpul2[] = new String[] {"B;C;D;E;F;G;H;K","A;I","A;G;H;K","A;E;F","A;D;F;J","A;D;E","A;C;H;K","A;C;G;K;L;M","B","E","A;C;G;H","H;M","H;L"};
	        String csimpul3[] = new String[] {"B;C;I","A;C;K;L","A;B;D","C;E;F","D;E","D;E;G;J","F;J;H","G","A,J","F;G;I","B;L;M","B;K;N","K","L"};
	        String csimpul4[] = new String[] {"B","A;C;D;E","B;F;G","B;E;K;L;N;O","B;D;M","C;G;I","C;F;H","G","F;J","I","D","D;O","D;E;N;O","D;L;M;O","D;L;M;N"};
	        String csimpul5[] = new String[] {"B;C","A","A;D;E;F","C","C;G;H","C;I;J","E;H","E;G","F;J;K","F;I;M","I","M","J;L;N","M;O","N"};
	        String csimpul6[] = new String[] {"B;C;D;I;J","A;C;K;L","A;B;D","A;B;C;L","B;F;G;H","B;E;G;H","B;E;F;H","B;E;F;G","A;J","A;I;K","J","D;M;N;O","L;N","L;M","D;L"};
	        String csimpul7[] = new String[] {"B;C","A","A;D","C;E","D;F;G","E;G;I","E;F;H","G","F;J","I;K;L","J;L","J;K;M;N","L;N","L;M;O;P","N;P","O;N"};
	        String csimpul8[] = new String[] {"B;C;D","A;C;D","A;B;D","A;B;C;E;F","D;F","D;E;G;H;I;J","F;H;I;J","F;G;I;J","F;G;H;J;M;N","F;G;H;I;K;L","J;L","K;L","I;N;P","I;M;O;P","N","I;M;N"};
	        String csimpul9[] = new String[] {"B;C;D","A;H","A;D;E","A;C;F","C","D;G","F","B;I;J;K","H;J;K","H;I;K","H;I;J;L","K;M;O;Q","L;N;O;Q","M","L;M;P;Q","O;S","L;M;O;R","Q","P;T","S"};
	        String csimpul10[] = new String[] {"B;C;D;E;F;H","A","A;D;E;F'O'P'Q'R'S","A;C;E;F","A;C;D;F","A;C;D;E;G","F","A;I","H;J","I;K","J;L","K;M","L;N","M","C","C","C;R;S","C;Q;S","C;Q;R;T;U;V;W","S;U;V;W","S;T;V;W","S;T;U;W","S;T;U;V;X","W"};
	        
	        //End Points
	        String endpoints[][] = new String[][]{{"H"},
	        		                              {"C","D","F","G","I","K","L","M"},
	        		                              {"E","M","N"},
	        		                              {"H","J","K","N"},
	        		                              {"B","D","G","H","K","L"},
	        		                              {"C","E","F","G","H","I","K","N","O"},
	        		                              {"B","H","M","O","P"},
	        		                              {"A","B","C","E","G","H","K","L","M","O"},
	        		                              {"E","G","I","J","N"},
	        		                              {"B","D","E","G","N","O","Q","R","T","U","V"}};
	        
	        
	        //Start & Finish
	        String starts [][] = new String[][]  {{"A"},
	        		                              {"A;B"},
	        		                              {"A;C"},
	        		                              {"A"},
	        		                              {"A"},
	        		                              {"A"},
	        		                              {"A;B"},
	        		                              {"A;B;C;D"},
	        		                              {"A"},
	        		                              {"A"}};
	        
	        
	        String ends [] = new String[]  {"H","J","H","O","O","M","P","P","T","G"};
	     
	        Node nodes[];
	        Node nodeaktif;
	        boolean dimulai=false;
	        int mazeterpilih;
	        
	        int currentstage=0;
	        	
	        
	        
	        public void nextStage()
	        {
	        	   initMaze(); 
	               InputStream is = getContext().getResources().openRawResource(gbrmaze[mazeterpilih]);
	               mBitmap = BitmapFactory.decodeStream(is);
	               currentstage++;
	        }
	        
	  public MazeView(Context context) 
	  {
          super(context);
          nodeaktif=null;
          mColors[0] = Color.argb(192, 255, 64, 64);
          mColors[1] = Color.argb(192, 64, 128, 64);
          mColors[2] = Color.argb(192, 64, 64, 255);
          mColors[3] = Color.argb(192, 64, 255, 255);
          mColors[4] = Color.argb(192, 128, 64, 128);
          mColors[5] = Color.argb(192, 255, 255, 64);
         
          mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
          Bundle var = getIntent().getExtras();
          currentstage  = var.getInt("pil");
          nextStage();
       
          new Thread(this).start();
      } 
	 
	  public boolean IsInChoice(int idx){
		  boolean isChoice =false;
		  for(int i=0;i<nodeaktif.getNodeCCCount();i++)
		  {
			 if ( nodeaktif.getNodeCC(i).getName().equals(nodes[idx].getName()))
			 {
				 isChoice =true;
				 break;
			 }
		  }
		  return isChoice;
		  
	  }
	  
	  public void check()
	  {
		  if (nodeaktif.isEnd())
		     {
		    	Bundle extras = new Bundle();
		    	extras.putString("state", "4");						 
				startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));				
				
		     }else if (nodeaktif.isEndPoint())
		     {
		    	 chanceEP++;
		    	Bundle extras = new Bundle();
		    		
		    	if (chanceEP<3 ){
		    		extras.putString("state", "5");
				
		    	}else {
		    		extras.putString("state", "6");
		    	}
		    	startActivity(new Intent(getApplicationContext(), PopUpActivity.class).putExtras(extras));
		     }
	  }
	        
	  public void setActiveNode(String karakter)
	  {
		  int ascii =(int) karakter.charAt(0);
          int idx = ascii-65;	
          if (idx>=0 && idx<nodes.length)
          {
        	
        	 if (dimulai==false) {
        		 
        	    if (nodes[idx].isStart()) 
        	    {
        	    	dimulai = true;
                    nodeaktif= nodes[idx];//.setEndPoint(true);
                    check();
        	    }else
        	    {        	  
        	    	Toast.makeText(getApplicationContext(), "Ucapkan Pilihan Pertama Anda Huruf 'A'", 3000).show();
        	    }
                
        	 }else{
        		 
        		 if (IsInChoice(idx))
        		 {
        			 nodeaktif= nodes[idx]; 
        			 check();
        		 }else{
        			 Toast.makeText(getApplicationContext(), "Tidak Ada Di dalam Pilihan ", 3000).show();
        		 }
        	 }
             
             
          }
	  }
	  
	        private void initMaze()
	        {
	        	//Random rand = new Random();
	        //	mazeterpilih =(int) rand.nextDouble()*15;
	        	mazeterpilih = currentstage;
	        	int byknode = jnode[mazeterpilih];
	        	nodes = new Node[byknode];
	        	//Inisialisasi Node
	        	for(int i=0;i<nodes.length;i++)
	        	{
	        		  Point pt = new Point();
	        		  String strposisi= "";
	        		  if (mazeterpilih==0) {
	        			  strposisi = posisimaze1[i];
	        		  }
	        		  else if (mazeterpilih==1) {
	        			  strposisi = posisimaze2[i];
	        		  } else if (mazeterpilih==2) {
	        			  strposisi = posisimaze3[i];
	        		  } else if (mazeterpilih==3) {
	        			  strposisi = posisimaze4[i];
	        		  } else if (mazeterpilih==4) {
	        			  strposisi = posisimaze5[i];
	        		  } else if (mazeterpilih==5) {
	        			  strposisi = posisimaze6[i];
	        		  } else if (mazeterpilih==6) {
	        			  strposisi = posisimaze7[i];
	        		  } else if (mazeterpilih==7) {
	        			  strposisi = posisimaze8[i];
	        		  } else if (mazeterpilih==8) {
	        			  strposisi = posisimaze9[i];
	        		  } else if (mazeterpilih==9) {
	        			  strposisi = posisimaze10[i];
	        		  }
	        		  String koordinat[] = strposisi.split(";");
	        		  pt.x = Integer.parseInt(koordinat[0]);
	        		  pt.y = Integer.parseInt(koordinat[1]);
	        		  
	        		  nodes[i] = new Node(String.valueOf((char)(65+i)),pt);
	        	}
	        	//Inisial EndPoint, Start, dan End of Game
	        	for(int i=0;i<endpoints[mazeterpilih].length;i++)
	        	{
	        		 int ascii =(int) endpoints[mazeterpilih][i].charAt(0);
	                 int idx = ascii-65;	                 
	                 nodes[idx].setEndPoint(true);	                 
	        	}
	        	
	        	for(int i=0;i<starts[mazeterpilih].length;i++)
	        	{
	        		 int ascii =(int) starts[mazeterpilih][i].charAt(0);
	                 int idx = ascii-65;	                 
	                 nodes[idx].setStart(true);	                 
	        	}
	        	
	        	 int ascii =(int) ends[mazeterpilih].charAt(0);
	        	 int idx = ascii-65;	                 
	             nodes[idx].setEnd(true);
	            
	             
	             String cc[] =null;
	             if (mazeterpilih==0)  //Jika Maze 1
	             {
	            	 cc = csimpul1;
	             }else if (mazeterpilih==1) //Jika Maze 2
	             {
	            	 cc = csimpul2;
	             }else if (mazeterpilih==2)  
	             {
	            	 cc = csimpul3;
	             }else if (mazeterpilih==3)  
	             {
	            	 cc = csimpul4;
	             }else if (mazeterpilih==4) 
	             {
	            	 cc = csimpul5;
	             }else if (mazeterpilih==5) 
	             {
	            	 cc = csimpul6;
	             }else if (mazeterpilih==6)  
	             {
	            	 cc = csimpul7;
	             }else if (mazeterpilih==7)  
	             {
	            	 cc = csimpul8;
	             }else if (mazeterpilih==8)  
	             {
	            	 cc = csimpul9;
	             }else if (mazeterpilih==9)  
	             {
	            	 cc = csimpul10;
	             }
	             //Hubungkan dengan Simpul
	             for(int i=0;i<cc.length;i++)
	             {
	                 String c = cc[i];
	                 String arrc[] = c.split(";");
	                 for(int j=0;j<arrc.length;j++)
	                 {
	                      ascii =(int) arrc[j].charAt(0);
	                      idx = ascii-65;
	                      nodes[i].AddConnectedNode(nodes[idx]);
	                    
	                 }
	             }
	        	
	        	
	        	
	        }
	  
	  @Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	// TODO Auto-generated method stub
		 
		
         
		   scale_x =(float) (w) / mBitmap.getWidth();
		   scale_y =(float) (h) / mBitmap.getHeight();
		  
		   mBitmapScaled = Bitmap.createScaledBitmap(mBitmap, getWidth(), getHeight(), false);		  
		   mCanvas.setBitmap(mBitmapScaled);
		   mBitmapOriScaled = Bitmap.createBitmap(mBitmapScaled);
		  // mCanvas.save();
		   
	       
	super.onSizeChanged(w, h, oldw, oldh);
	}
	  
	  
	  
      @Override
      protected void onDraw(Canvas canvas) {
          synchronized (this) {
        	 
        	  mPaint.setColor(0xFF00FFFF);
        	  if (nodeaktif!=null)
        	  {
  				 
        		 mBitmapScaled = Bitmap.createBitmap(mBitmapOriScaled);
        		 mCanvas.setBitmap(mBitmapScaled);
 				 mCanvas.drawCircle(nodeaktif.getPoint().x*scale_x, nodeaktif.getPoint().y*scale_y, 10, mPaint);
 			    
 			   }
              canvas.drawBitmap(mBitmapScaled, 0, 0, null);
        	 
     
        	 
        	   
          }
      }

      @Override
	public void run() 
    {
		// TODO Auto-generated method stub		    	
     
		while(bStop==false)
		{
		    no++;		    
		    mPaint.setColor(0xFFFFF000);
			
			// mCanvas.drawText("SIIIIIIIIIAP", 100, 100, mPaint);
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				  invalidate();
				}
			});
	       
		 
			
		}
	}

	    }
	

}
