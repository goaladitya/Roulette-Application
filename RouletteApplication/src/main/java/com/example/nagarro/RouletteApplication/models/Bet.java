package com.example.nagarro.RouletteApplication.models;

public class Bet {
	
	int zero;
	int first12;
	int second12;
	int third12;
	int odd;
	int even;
	int first18;
	public Bet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bet(int zero, int first12, int second12, int third12, int odd, int even, int first18, int second18) {
		super();
		this.zero = zero;
		this.first12 = first12;
		this.second12 = second12;
		this.third12 = third12;
		this.odd = odd;
		this.even = even;
		this.first18 = first18;
		this.second18 = second18;
	}

	int second18;
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getFirst12() {
		return first12;
	}
	public void setFirst12(int first12) {
		this.first12 = first12;
	}
	public int getSecond12() {
		return second12;
	}
	public void setSecond12(int second12) {
		this.second12 = second12;
	}
	public int getThird12() {
		return third12;
	}
	public void setThird12(int third12) {
		this.third12 = third12;
	}
	public int getOdd() {
		return odd;
	}
	public void setOdd(int odd) {
		this.odd = odd;
	}
	public int getEven() {
		return even;
	}
	public void setEven(int even) {
		this.even = even;
	}
	public int getFirst18() {
		return first18;
	}
	public void setFirst18(int first18) {
		this.first18 = first18;
	}
	public int getSecond18() {
		return second18;
	}
	public void setSecond18(int second18) {
		this.second18 = second18;
	}

}
