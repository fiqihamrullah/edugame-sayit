package com.game.sayit;

import java.util.ArrayList;
import java.util.Random;

public class SoalGambarPlayer
{
  private SoalGambar currentSoal;
  private GameScore gscore;
  private int idxsoal=0;	
  private int MAX_SOAL=10;
  private int nsoal = 0;
  private int listhistory[];
  public SoalGambarPlayer(SoalGambar currentSoal) 
  {
	// TODO Auto-generated constructor stub
	  this.currentSoal = currentSoal;
	  gscore = new GameScore(20, 5, 0);
	  listhistory = new int[MAX_SOAL];
	  
  }
  
  private boolean isExist(int idx){
	  boolean b = false;
	  for(int i=0;i<MAX_SOAL;i++) 
	  {
		  if (listhistory[i]==idx)
		  {
			  b=true;
			  break;
		  }
	  }
	  return b;
  }
  
  private void addToHistoryList(int idx)
  {
	  listhistory[nsoal]= idx;
  }
  
  private int randomPicture() {
	  int r=0;
	  Random rnd = new Random();
	  do{
	  r = rnd.nextInt(currentSoal.getBanyakSoal());
	  }while (isExist(r));
	  return r;
  }
  
  public int firstPicture()
  {
	  idxsoal=randomPicture();
	  addToHistoryList(idxsoal);
	  return currentSoal.getSoal(idxsoal);
  }
  
  public int nextPicture()
  {
	  idxsoal=randomPicture();
	  nsoal ++;
	  addToHistoryList(idxsoal);
	  return currentSoal.getSoal(idxsoal);
  }
  
  public boolean IsLastPicture()
  {
	  boolean hasil=false;
	  if ((nsoal+1)==MAX_SOAL) {
	      hasil= true;
	  }
	  return hasil;
  }
  
  public boolean checkJawaban(String jawab)
  {
	  boolean b= false;
	  if (IsTrueAnswer(jawab))
	  {
		  b=true;
		//  gscore.addBenar();
	  }else {
		//  gscore.addSalah();
	  }
	  return b;
  }
  
  public GameScore getGameScore()
  {
	  return gscore;
  }
  
  public String getCurrentJawaban()
  {
	  return currentSoal.getJawaban(idxsoal); 
  }
  
  
  private boolean IsTrueAnswer(String jawab)
  {
	  
	  return currentSoal.getJawaban(idxsoal).toLowerCase().equals(jawab);
  }
  
 
  
}
