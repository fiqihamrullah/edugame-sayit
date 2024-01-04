package com.game.sayit;

public class GameScore 
{
      int right;
      int wrong;
      int score;
      int rightscore;
      int wrongscore;
      int helpscore;
      int help;      
      
      public GameScore() 
      {
		// TODO Auto-generated constructor stub
	  }
      
      public GameScore(int rightscore,int wrongscore,int score)
      {
    	 right=0;
    	 wrong=0;
    	 this.rightscore=rightscore;
    	 this.wrongscore = wrongscore;
    	 this.score = score;    	 
      }
     
      public void addBenar()
      {
    	 right++;
      }
     
      public void addHelp()
      {
    	 help++;
      }
     
     public void addSalah()
     {
    	wrong++;
     }
     
     public int getTotalQuestionSoFar()
     {
    	 return right+wrong;
     }
     
     
     
     public int getTotalScore(){
    	 return ((right*rightscore)-(wrong*wrongscore)-(helpscore*help));
     }
     
     public int getTotalBenar()
     {
        return right;
     }
     
     public int getTotalSalah()
     {
        return wrong;
     }
     
     
      
}
