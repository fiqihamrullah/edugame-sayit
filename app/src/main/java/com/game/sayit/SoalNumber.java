package com.game.sayit;

public class SoalNumber {
     private int operandkiri,operandkanan,intoperator;
     private  String operator;
     
     public SoalNumber() {
		// TODO Auto-generated constructor stub
	}
     
     public void setOperator(String operator) {
		this.operator = operator;
	}
     
     public void setIntOperator(int intoperator) {
		this.intoperator = intoperator;
	}
     
     public void setOperandKanan(int operandkanan) {
		this.operandkanan = operandkanan;
	}
     
     public void setOperandKiri(int operandkiri) {
		this.operandkiri = operandkiri;
	}
     
    public int getOperandKanan() {
		return operandkanan;
	}
    
    public int getOperandKiri() {
		return operandkiri;
	}
    
    public String getOperator() {
		return operator;
	}
    
    public int getIntOperator() {
		return intoperator;
	}
    
     
     
}
