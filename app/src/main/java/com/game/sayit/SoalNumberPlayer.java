package com.game.sayit;

import java.util.Random;

import android.util.Log;

public class SoalNumberPlayer 
{
	private SoalNumber sn;
	private GameScore gscore;
	Random rand ;
	private int angka[] = new int[]{R.drawable.zero,
			 						R.drawable.one,
			 						R.drawable.two,
			 						R.drawable.three,
			 						R.drawable.four,
			 						R.drawable.five,
			 						R.drawable.six,
			 						R.drawable.seven,
			 						R.drawable.eight,
			 						R.drawable.nine};
			 						
			 						
	
	private int operator[] = new int[ ]{R.drawable.tambah,R.drawable.kali};
	private int jawaban;
	private static int MAX_SOAL = 10;
	private int isoal=0;
	
	public SoalNumberPlayer() {
		// TODO Auto-generated constructor stub
		gscore = new GameScore(20, 5, 0);
		sn  = new SoalNumber();
		  rand = new Random();
	}
	
	private int generateNumber()
	{
		
		int h =(int) (rand.nextDouble()*9);
		//Log.i("Acak:", String.valueOf(h));
		return h;
		
	}
	
	private int generateOperator()
	{
		Random rand = new Random();
		int h =rand.nextInt(2);
		
		return h;
		
	}
	
	public String getCurrentJawaban()
	{
		return String.valueOf(jawaban);
	}
	
	public boolean check(String jawab )
	{
		boolean b= false;
		String j = String.valueOf(jawaban);
		if (j.equals(jawab))
		{
			b = true;
			//gscore.addBenar();
		}else{
			b =false;
		//	gscore.addSalah();
		}
		return b;
		
	}
	
	public boolean IsLastofGame()
	{
	  return (isoal==MAX_SOAL);
	}
	
	public GameScore getGameScore(){
		return gscore;
	}
	
	public SoalNumber generateSoal()
	{
		int op1 = generateNumber();
		int op2 = generateNumber();
		int op = generateOperator();
		if (op==0)
		{
			jawaban = op1 + op2;
		}else if (op==1)
		{
			jawaban = op1 * op2;
		}
		sn.setOperandKiri(angka[op1]);
		sn.setOperandKanan(angka[op2]);
		sn.setIntOperator(operator[op]);
		isoal++;
		return sn;
			
	}
	
	

}
