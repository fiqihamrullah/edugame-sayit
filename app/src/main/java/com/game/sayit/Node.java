package com.game.sayit;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

public class Node 
{
	    private List<Node> strCC;
	    private String name="";
	    private boolean isEndPoint;
	    private boolean isEnd;
	    private boolean isStart;
	    private Point pt;
	    
	    
	    public Node(String name,Point pt) 
	    {
	        strCC = new ArrayList<Node>();
	        this.name = name;
	        isEndPoint = false;
	        isEnd = false;
	        this.pt = pt;
	    }
	    
	    public Point getPoint() {
			return pt;
		}
	    
	    public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
	    
	    public void setEndPoint(boolean isEndPoint) {
			this.isEndPoint = isEndPoint;
		}
	    
	    public void setStart(boolean isStart) {
			this.isStart = isStart;
		}
	    
	    public boolean isEnd() {
			return isEnd;
		}
	    public boolean isEndPoint() {
			return isEndPoint;
		}
	    public boolean isStart() {
			return isStart;
		}
	    
	    
	    public int getNodeCCCount()
	    {
	        return strCC.size();
	    }
	    
	    public Node getNodeCC(int i)
	    {
	        return strCC.get(i);
	    }
	    
	    public void AddConnectedNode(Node node){
	        strCC.add(node);
	            
	    }
	    
	    public String getName()
	    {
	        return name;
	    }
	    
	    
}
