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

public class OptionsPlayGameActivity extends Activity
{
	int gbr[] = new int[] {R.drawable.animal,R.drawable.fruit,R.drawable.colour, R.drawable.bodyparts,R.drawable.school,R.drawable.mathematic,R.drawable.maze,R.drawable.transportation};
    String teks[] = new String[]{"Animal","Fruit","Color","Body Parts","School","Mathematic","Maze","Transportation"};
	
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
				long arg3) {
			// TODO Auto-generated method stub
			if (arg2<5 || arg2==7)
			{
			   startActivity(new Intent(getApplicationContext(), PlayGamePictureActivity.class).putExtra("pil", arg2));
			}else if (arg2==6){
				  startActivity(new Intent(getApplicationContext(), MazeMenuActivity.class));
			}
			else if (arg2==5)
			{
			   startActivity(new Intent(getApplicationContext(), PlayGameNumberActivity.class));
			}
		}
	};
	
	
	

}
