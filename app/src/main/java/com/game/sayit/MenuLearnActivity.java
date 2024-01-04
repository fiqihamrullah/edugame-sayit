package com.game.sayit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

 

public class MenuLearnActivity  extends Activity{
	int gbr[] = new int[] {R.drawable.animal,R.drawable.fruit,R.drawable.colour, R.drawable.bodyparts,R.drawable.school,R.drawable.aplhabet,R.drawable.number,R.drawable.transportation};
     String teks[] = new String[]{"Animal","Fruit","Color","Body Parts","School","Alphabet","Number","Transportation"};
     MediaPlayer mMediaPlayer;
	 public class MyAdapter extends BaseAdapter {
		   
		//  final int NumberOfItem = 30;
		  private Bitmap[] bitmap ;//= new Bitmap[NumberOfItem];
		  String huruf[]; 
		  private Context context;
		  private LayoutInflater layoutInflater;
		   
		  MyAdapter(Context c,int gbr[],String huruf2[]){
		   context = c;
		   layoutInflater = LayoutInflater.from(context);
		    bitmap  = new Bitmap[gbr.length];
		    huruf = huruf2;
		   //init dummy bitmap,
		   //using R.drawable.icon for all items
		   for(int i = 0; i < gbr.length; i++){
		    bitmap[i] = BitmapFactory.decodeResource(context.getResources(),gbr[i]);
		   }
		  }
		 
		  @Override
		  public int getCount() {
		   // TODO Auto-generated method stub
		   return bitmap.length;
		  }
		 
		  @Override
		  public Object getItem(int position) {
		   // TODO Auto-generated method stub
		   return bitmap[position];
		  }
		 
		  @Override
		  public long getItemId(int position) {
		   // TODO Auto-generated method stub
		   return position;
		  }
		 
		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		   // TODO Auto-generated method stub
		    
		   View grid;
		   if(convertView==null){
		    grid = new View(context);
		    grid = layoutInflater.inflate(R.layout.gridlayout, null); 
		   }else{
		    grid = (View)convertView; 
		   }
		    
		   ImageView imageView = (ImageView)grid.findViewById(R.id.image);
		   imageView.setImageBitmap(bitmap[position]);
		   TextView textView = (TextView)grid.findViewById(R.id.text);
		   textView.setText(huruf[position]);
		    
		   return grid;
		  }
		 
		 }
    /** Called when the activity is first created. */
	TextView tvLabel;
	GridView gvHuruf;

	
	
    @Override    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
    	mMediaPlayer = MediaPlayer.create(this, R.raw.learn);
 
	 
        setContentView(R.layout.gridviewlayout);
        gvHuruf = (GridView) findViewById(R.id.grid);
        MyAdapter adapter =null;
        
        adapter = new MyAdapter(this,gbr,teks);
       
        gvHuruf.setAdapter(adapter);
        gvHuruf.setOnItemClickListener(otmclick);
        TextView tvJudul = (TextView)findViewById(R.id.tvJudul);
        tvJudul.setText("Aplikasi Permainan Pembelajaran");              
    }
    
    @Override
    protected void onStart() 
     {
    	// TODO Auto-generated method stub
    	 mMediaPlayer.setLooping(true);
         mMediaPlayer.start();
    	super.onStart();
    }
     
     @Override
    protected void onPause() 
     {
    	// TODO Auto-generated method stub
    //	 mMediaPlayer.pause();
    	super.onPause();
    }
     
     @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	 mMediaPlayer.start();
    	super.onResume();
    }
     
     @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	 mMediaPlayer.stop();
    	 mMediaPlayer.release();
    	super.onDestroy();
    }
    
 
   private OnItemClickListener otmclick = new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getApplicationContext(), ViewDetailKategoriActivity.class).putExtra("pil", position));
	}
};


 
 public void onBackPressed() {
 
	/*  Intent intent = new Intent();
      intent.setClass(MenuLearnActivity.this,MainActivity.class);
      startActivity(intent);   */
      MenuLearnActivity.this.finish();
 };
    
 
    public void goExit(){
    	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    //	MenuMCommerce.this.finish();
                       Process.killProcess(Process.myPid());
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                         dialog.cancel();
                    }
                });
         AlertDialog alert = builder.create();
         alert.show();
}
}
