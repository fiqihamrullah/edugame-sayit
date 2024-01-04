package com.game.sayit;

 


import java.util.ArrayList;
import java.util.List;

import android.content.Context; 
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GameDatabase 
{
	String dbname = "edugamesayit";
	Context ct;
	 SQLiteDatabase myDB = null;	
	public GameDatabase(Context ct) 
	{
		// TODO Auto-generated constructor stub
	    this.ct = ct;
	   
	 	myDB = ct.openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
	}
	
	public void CloseObject()
	{
		 if (myDB!=null)
    	     myDB.close();
	}
	
 
	public void CreateTablePlayer()
	{
		 SQLiteDatabase myDB = null;	
	 	 myDB = ct.openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
	 	 String sql="create table if not exists player (nmplayer  varchar)";
		 myDB.execSQL(sql);	 
		 
	}
	
	public void CreateTableScore()
	{
		
	 	String sql="create table if not exists score (keyname  varchar,highscore int)";
		myDB.execSQL(sql);
		 
		sql = "select * from score"; 	   
	 	Cursor c= myDB.rawQuery(sql, null);
	 	if (c.getCount()==0)
	 	{
	 		String keyscore[] = new String[] {"Animal","Fruits","Colors","Body Parts","School","Math","Transportations"};
	 		String maze[] = new String[] {"Maze 1","Maze 2","Maze 3"};
	 		
	 		for(int i=0;i<keyscore.length;i++) 
	 		{
	 		    sql="insert into score (keyname, highscore ) values('" + keyscore[i]  + "',0)";
	 		   myDB.execSQL(sql);
	 		}
	 		
	 		for(int i=0;i<maze.length;i++) 
	 		{
	 		    sql="insert into score (keyname, highscore ) values('" + maze[i]  + "',0)";
	 		   myDB.execSQL(sql);
	 		}
	 		
			
	 	     
	        
	 	 }
	}
	
	public boolean hasPlayer()
	{
		String sql = "select * from player"; 	   
	 	Cursor c= myDB.rawQuery(sql, null);
	 	return c.getCount()>0;
	}
	
	public String getPlayerName()
	{
		String sql = "select * from player"; 	   
	 	Cursor c= myDB.rawQuery(sql, null);
	 	c.moveToFirst();
	 	
	 	return c.getString(0);
	}
	
	public void AddPlayer(String nmplayer)
	{
		String sql = "insert into player values('" + nmplayer + "')";
		myDB.execSQL(sql);
	}
	
	public void SetPlayer(String nmplayer)
	{
		String sql = "update player set nmplayer='" + nmplayer + "'";
		myDB.execSQL(sql);
	}
	
	public void SetScore(String keyname,int score)
	{
		String sql = "select * from score "+ " where keyname='" + keyname + "'";
		Cursor c= myDB.rawQuery(sql, null);
		c.moveToFirst();
		if (c.getInt(1)< score) 
		{
		  sql = "update score set highscore=" + String.valueOf(score) + " where keyname='" + keyname + "'";
		  myDB.execSQL(sql);
		}
	}
	
	public List<PlayerScore> GetHighScores()
	{
		List<PlayerScore> listPlayScore = new ArrayList<PlayerScore>();
		String sql = "select * from score"; 	   
	 	Cursor c= myDB.rawQuery(sql, null);
	 	if (c.getCount()>0)
	 	{
	 		c.moveToFirst();
	 		while (!c.isAfterLast())
	 		{
	 			PlayerScore ps = new PlayerScore(c.getString(0), String.valueOf(c.getInt(1)));
	 			listPlayScore.add(ps);
	 			c.moveToNext();
	 		}
	 	}
		
		return listPlayScore;
	}
	
	

}
