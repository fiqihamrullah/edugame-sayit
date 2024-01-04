package com.game.sayit;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MazeMenuActivity extends Activity {
	int gbr[] = new int[] {R.drawable.smaze1,R.drawable.smaze2,R.drawable.smaze3, R.drawable.smaze3,R.drawable.smaze3,R.drawable.smaze4,R.drawable.smaze5,R.drawable.smaze6,R.drawable.smaze7,R.drawable.smaze8,R.drawable.smaze9,R.drawable.smaze10};
    String teks[] = new String[]{"Maze 1","Maze 2","Maze 3","Maze 4","Maze 5","Maze 6","Maze 7","Maze 8","Maze 9","Maze 10"};
	
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
		  public View getView(int position, View convertView, ViewGroup parent) 
		  {
		   // TODO Auto-generated method stub		    
		   View grid;
		   if(convertView==null)
		   {
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
	TextView tvLabel;
	GridView gvHuruf;
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewlayout2);
		
		 gvHuruf = (GridView) findViewById(R.id.grid);
	        MyAdapter adapter =null;
	        
	        adapter = new MyAdapter(this,gbr,teks);
	       
	        gvHuruf.setAdapter(adapter);
	        gvHuruf.setOnItemClickListener(clickGame);
	}
	
	private OnItemClickListener clickGame = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) 
		{
			// TODO Auto-generated method stub
			  startActivity(new Intent(getApplicationContext(), MazeGame.class).putExtra("pil", arg2));
			
		}
	};
}
