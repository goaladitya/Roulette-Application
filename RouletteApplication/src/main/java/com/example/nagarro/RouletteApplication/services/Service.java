package com.example.nagarro.RouletteApplication.services;

import java.util.Random;

import com.example.nagarro.RouletteApplication.models.Bet;

public class Service {
	
	public static int generateRandom(){
		Random generator = new Random();
		int random = generator.nextInt(Integer.MAX_VALUE);
		return random%37;
	}
	
	public static int getTotalBet(Bet bet){
		int total=0;
		total=bet.getEven()+bet.getFirst12()+bet.getFirst18()+bet.getOdd()+bet.getSecond12()+bet.getSecond18()+bet.getThird12()+bet.getZero();
		return total;
	}
	
	public static int calculateProfit(Bet bet,int random){
		int profit=0;
		
		if(random==0)
			return bet.getZero()*10;
		
		if(random>0 && random<=18)
		{
			profit+=((bet.getFirst18()*125)/100);
		}
		
		if(random>18 && random<=36)
		{
			profit+=((bet.getSecond18()*125)/100);
		}

		if(random>0 && random<=12)
		{
			profit+=((bet.getFirst12()*15)/10);
		}
		
		if(random>=13 && random<=24)
		{
			profit+=((bet.getSecond12()*15)/10);
		}
		if(random>24 && random<=36)
		{
			profit+=((bet.getThird12()*15)/10);
		}
		if(random%2==0)
		{
			profit+=((bet.getEven()*125)/100);
		}
		if(random%2!=0)
		{
			profit+=((bet.getOdd()*125)/100);
		}
		return profit;
	}

}
