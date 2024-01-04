package com.game.sayit;

import android.content.res.Resources;

public class SoalGambar
{
	public static int KATEGORI_HEWAN=0;
	public static int KATEGORI_BUAH2AN=1;
	public static int KATEGORI_COLOR=3;
	public static int KATEGORI_BODYPARTS=4;
	public static int KATEGORI_SCHOOLS=5;
	public static int KATEGORI_TRANSPORTATION=6;	
	
	private int imAnimals[] = new int[]
	{
	    		R.drawable.a1,
	    		R.drawable.a2,
	    		R.drawable.a3,
	    		R.drawable.a4,
	    		R.drawable.a5,
	    		R.drawable.a6,
	    		R.drawable.a7,
	    		R.drawable.a8,
	    		R.drawable.a9,
	    		R.drawable.a10,
	    		R.drawable.a11,
	    		R.drawable.a12,
	    		R.drawable.a13,
	    		R.drawable.a14,
	    		R.drawable.a15,
	    		R.drawable.a16,
	    		R.drawable.a17,
	    		R.drawable.a18,
	    		R.drawable.a19,
	    		R.drawable.a20,
	    		R.drawable.a21,
	    		R.drawable.a22,
	    		R.drawable.a23,
	    		R.drawable.a24,
	    		R.drawable.a25,
	    		R.drawable.a26,
	    		R.drawable.a27,
	    		R.drawable.a28,
	    		R.drawable.a29,
	    		R.drawable.a30,
	    		R.drawable.a31,
	    		R.drawable.a32,
	    		R.drawable.a33,
	    		R.drawable.a34,
	    		R.drawable.a35,
	    		R.drawable.a36,
	    		R.drawable.a37,
	    		R.drawable.a38,
	    		R.drawable.a39,
	    		R.drawable.a40,
	    		R.drawable.a41,
	    		R.drawable.a42,
	    		R.drawable.a43,
	    		R.drawable.a44,
	    		R.drawable.a45,
	    		R.drawable.a46,
	    		R.drawable.a47,
	    		R.drawable.a48,
	    		R.drawable.a49,
	    		R.drawable.a50
	    };
	    
	    private int imFruits[] = new int[]
	    {
	    	   R.drawable.f01,
	    	   R.drawable.f02,
	    	   R.drawable.f03,
	    	   R.drawable.f04,
	    	   R.drawable.f05,
	    	   R.drawable.f06,
	    	   R.drawable.f07,
	    	   R.drawable.f08,
	    	   R.drawable.f09,
	    	   R.drawable.f10,
	    	   R.drawable.f11,
	    	   R.drawable.f12,
	    	   R.drawable.f13,
	    	   R.drawable.f14,
	    	   R.drawable.f15,
	    	   R.drawable.f16,
	    	   R.drawable.f17,
	    	   R.drawable.f18,
	    	   R.drawable.f19,
	    	   R.drawable.f20,
	    	   R.drawable.f21,
	    	   R.drawable.f22,
	    	   R.drawable.f23,
	    	   R.drawable.f24,
	    	   R.drawable.f25,
	    	   R.drawable.f26,
	    	   R.drawable.f27,
	    	   R.drawable.f28,
	    	   R.drawable.f29,
	    	   R.drawable.f30,
	    	   R.drawable.f31,
	    	   R.drawable.f32,
	    	   R.drawable.f33,
	    	   R.drawable.f34,
	    	   R.drawable.f35
	    	   
	    };
	    
	    private int imColors[] = new int[]
	                                     {
	    		R.drawable.c01_1,
	    		R.drawable.c02_1,
	    		R.drawable.c03_1,
	    		R.drawable.c04_1,
	    		R.drawable.c05_1,
	    		R.drawable.c06_1,
	    		R.drawable.c07_1,
	    		R.drawable.c08_1,
	    		R.drawable.c09_1,
	    		R.drawable.c10_1,
	    		R.drawable.c11_1,
	    		R.drawable.c12_1,
	    		R.drawable.c13_1,
	    		R.drawable.c14_1,
	    		R.drawable.c15_1,
	    		R.drawable.c16_1,
	    		R.drawable.c17_1,
	    		R.drawable.c18_1,
	    		R.drawable.c19_1,
	    		R.drawable.c20_1,
	    		R.drawable.c21_1,
	    		R.drawable.c22_1,
	    		R.drawable.c23_1,
	    		R.drawable.c24_1,
	    		R.drawable.c25_1    		
	    		
	                                     };
	    
	    private int imbodyparts[] = new int[]
	                                     {
	    		R.drawable.b01,
	    		R.drawable.b02,
	    		R.drawable.b03,
	    		R.drawable.b04,
	    		R.drawable.b05,
	    		R.drawable.b06,
	    		R.drawable.b07,
	    		R.drawable.b08,
	    		R.drawable.b09,
	    		R.drawable.b10,
	    		R.drawable.b11,
	    		R.drawable.b12,
	    		R.drawable.b13,
	    		R.drawable.b14,
	    		R.drawable.b15,
	    		R.drawable.b16,
	    		R.drawable.b17,
	    		R.drawable.b18,
	    		R.drawable.b19,
	    		R.drawable.b20,
	    		R.drawable.b21,
	    		R.drawable.b22,
	    		R.drawable.b23,
	    		R.drawable.b24,
	    		R.drawable.b25,
	    		R.drawable.b26,
	    		R.drawable.b27,
	    		R.drawable.b28,
	    		R.drawable.b29,
	    		R.drawable.b30,
	    		R.drawable.b31,
	    		R.drawable.b32,
	    		R.drawable.b33,
	    		R.drawable.b34,
	    		R.drawable.b35,
	    		R.drawable.b36,
	    		R.drawable.b37,
	    		R.drawable.b38,
	    		R.drawable.b39,
	    		R.drawable.b40,
	    		R.drawable.b41,
	    		R.drawable.b42,
	    		R.drawable.b43,
	    		R.drawable.b44,
	    		R.drawable.b45
	                                     };
	    private int imschools[] = new int[]
	                                        {
	    		R.drawable.s01,
	    		R.drawable.s02,
	    		R.drawable.s03,
	    		R.drawable.s04,
	    		R.drawable.s05,
	    		R.drawable.s06,
	    		R.drawable.s07,
	    		R.drawable.s08,
	    		R.drawable.s09,
	    		R.drawable.s10,
	    		R.drawable.s11,
	    		R.drawable.s12,
	    		R.drawable.s13,
	    		R.drawable.s14,
	    		R.drawable.s15,
	    		R.drawable.s16,
	    		R.drawable.s17,
	    		R.drawable.s18,
	    		R.drawable.s19,
	    		R.drawable.s20,
	    		R.drawable.s21,
	    		R.drawable.s22,
	    		R.drawable.s23,
	    		R.drawable.s24,
	    		R.drawable.s25,
	    		R.drawable.s26,
	    		R.drawable.s27,
	    		R.drawable.s28,
	    		R.drawable.s29,
	    		R.drawable.s30,
	    		R.drawable.s31,
	    		R.drawable.s32,
	    		R.drawable.s33,
	    		R.drawable.s34,
	    		R.drawable.s35,
	    		R.drawable.s36,
	    		R.drawable.s37,
	    		R.drawable.s38,
	    		R.drawable.s39,
	    		R.drawable.s40,
	    		R.drawable.s41,
	    		R.drawable.s42,
	    		R.drawable.s43,
	    		R.drawable.s44,
	    		R.drawable.s45
	                                        };
	    
	    private int imtransports[] = new int[]
	                                         {
	     		R.drawable.t01,
	     		R.drawable.t02,
	     		R.drawable.t03,
	     		R.drawable.t04,
	     		R.drawable.t05,
	     		R.drawable.t06,
	     		R.drawable.t07,
	     		R.drawable.t08,
	     		R.drawable.t09,
	     		R.drawable.t10,
	     		R.drawable.t11,
	     		R.drawable.t12,
	     		R.drawable.t13,
	     		R.drawable.t14,
	     		R.drawable.t15,
	     		R.drawable.t16,
	     		R.drawable.t17,
	     		R.drawable.t18,
	     		R.drawable.t19,
	     		R.drawable.t20,
	     		R.drawable.t21,
	     		R.drawable.t22,
	     		R.drawable.t23,
	     		R.drawable.t24,
	     		R.drawable.t25
	      };
	    
	
	/*
	int kathewan[] = new int[]{R.drawable.anjing,
			                   R.drawable.cicak,
			                   R.drawable.elang,
			                   R.drawable.harimau,
			                   R.drawable.jerapah,
			                   R.drawable.kambing,
			                   R.drawable.katak,
			                   R.drawable.kelinci,
			                   R.drawable.kuda,
			                   R.drawable.lebah,
			                   R.drawable.monyet,
			                   R.drawable.sapi,
			                   R.drawable.tikus};*/
	
	
	//String jawabanhewan[] = new String[]{"dog","lizard","eagle","tiger","giraffe","goat","frog","rabbit","horse","bee","monkey","cow","mouse"};
	    
	
           
	
	int katbuah2an[] = new int[]{ };
	int katcolor[] = new int[]{};
	int katbodyparts[] = new int[]{};
	int katschools[] = new int[]{};
	int kattransportation[] = new int[]{};
	
	int soalaktif[];
	String jawabanaktif[];
	public SoalGambar() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void setSoal(Resources res,int pil)
	{
		 
		if (pil==KATEGORI_HEWAN) 
		{
			soalaktif = new int[imAnimals.length];
			jawabanaktif = res.getStringArray(R.array.nama_hewan_inggris);//new String[imAnimals.length];
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imAnimals[i];
				//jawabanaktif[i] = jawabanhewan[i];
			}
		}else if (pil==KATEGORI_BUAH2AN) 
		{
			soalaktif = new int[imFruits.length];
			jawabanaktif = res.getStringArray(R.array.nama_buah_inggris);
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imFruits[i];
				 
			}
		}else if (pil==KATEGORI_COLOR) 
		{
			soalaktif = new int[imColors.length];
			jawabanaktif = res.getStringArray(R.array.nama_warna_inggris);
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imColors[i];
				 
			}
		}else if (pil==KATEGORI_BODYPARTS) 
		{
			soalaktif = new int[imbodyparts.length];
			jawabanaktif = res.getStringArray(R.array.nama_bodyparts_inggris);
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imbodyparts[i];
			 
			}
		}else if (pil==KATEGORI_SCHOOLS) 
		{
			soalaktif = new int[imschools.length];
			jawabanaktif = res.getStringArray(R.array.nama_school_inggris);
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imschools[i];
				
			}
		}else if (pil==KATEGORI_TRANSPORTATION) 
		{
			soalaktif = new int[imtransports.length];
			jawabanaktif = res.getStringArray(R.array.nama_transports_inggris);
			for(int i=0;i<soalaktif.length;i++)
			{
				soalaktif[i] = imtransports[i];
				 
			}
		}
	}
	
	public int getSoal(int i){
		return soalaktif[i];
	}
	
	public String getJawaban(int i)
	{
		return jawabanaktif[i];
	}
	
	public int getBanyakSoal()
	{
		return soalaktif.length;		
	}

}
