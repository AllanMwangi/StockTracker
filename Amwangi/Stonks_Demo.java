package Amwangi;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Stonks_Demo {

		
	
	static Stonks_Interface<String> MyStonks=new Stonks();
	static Stonks_Interface<Integer> PriceOfShares=new Stonks();
	static Stonks_Interface<Integer> NumberOfSharesBought=new Stonks();
	
	//Buying of the stock
	static int numberOfInvestments=0;
	static int TotalPurchaseValue;
	static int [] sharesArray;
	static int TotalCurrentValue;
	
	//method to buy the stock
	public static  void buy() {
		
	 String Input;
	 String InvestmentName;
	 int CostPerShare;
	 int NumberOfShares;
	 
	 
	 
	Input=JOptionPane.showInputDialog("Enter the name of your investment");
	InvestmentName = Input;
	
	
	Input=JOptionPane.showInputDialog("Enter the costs per share for your investment");
	CostPerShare = Integer.parseInt(Input);
	
	Input=JOptionPane.showInputDialog("Enter the number of shares investment you wish to purchase");
	NumberOfShares = Integer.parseInt(Input);
	
	int purchaseValue=CostPerShare*NumberOfShares;
	
	String CostPerShareString=Integer.toString(CostPerShare);
	String NumberOfSharesString=Integer.toString(NumberOfShares);

	TotalPurchaseValue+=purchaseValue;
	numberOfInvestments++;
	MyStonks.push(InvestmentName);
	PriceOfShares.push(CostPerShare);
	NumberOfSharesBought.push(NumberOfShares);
	
	
	}
	
	
	
	
	//Keeping track of the stock
	//method to keep track of the stock
	public static  int check() {
		System.out.println("The total Value you invested is "+TotalPurchaseValue);
		System.out.println("You have a total of "+numberOfInvestments);
		String top= MyStonks.peek();
		System.out.println("The last investment was "+top);
		
		
		
	
		int []numberOfSharesArray;
		String []nameOfSharesArray;
		int []currentPriceArray;
		int currentValue;
		int totalCurrentValue = 0;
		
		
		nameOfSharesArray=new String[numberOfInvestments];
		numberOfSharesArray=new int[numberOfInvestments];
		currentPriceArray=new int[numberOfInvestments];
		
		if (MyStonks.isEmpty()!=true && numberOfInvestments!=0) {	
			for(int i=0;i<numberOfInvestments;i++) {
				
				String topName=MyStonks.pop();
				int topNumberOfShares=NumberOfSharesBought.pop();
				
		
			
		
			nameOfSharesArray[i]=topName;
			numberOfSharesArray[i]=topNumberOfShares;
			
			
			
			System.out.println("Enter the current value of "+ topName);
			Scanner keyboard=new Scanner(System.in);
			int currentPrice=keyboard.nextInt();
			currentPriceArray[i]=currentPrice;
			currentValue=currentPrice*topNumberOfShares;
			totalCurrentValue+=currentValue;
			
			
		
		}
		}
		
		for(int j=0;j<numberOfInvestments;j++) {
			String firstInvestment=nameOfSharesArray[j];
			int FirstNumberOfShares=numberOfSharesArray[j];
			MyStonks.push(firstInvestment);
			NumberOfSharesBought.push(FirstNumberOfShares);
			
		}
	
		int profit=totalCurrentValue-TotalPurchaseValue;
		System.out.println("The total current value of your stock is "+ totalCurrentValue);
		System.out.println("The total profit of your porfolio is "+ profit);
		System.out.println("");
		System.out.println("");
		System.out.println("");


		return totalCurrentValue;
	}

	
	

	//Selling the stock
	//method to sell the stock
	public static void sell() {	
			String top=MyStonks.pop();
			int topShares=NumberOfSharesBought.pop();
			int topPriceOfShares=PriceOfShares.pop();
		if (MyStonks.isEmpty()!=true && numberOfInvestments!=0) {

			
			System.out.println("About to sell a stock");
			
			System.out.println("Would you like to sell the whole stock? (Y/N)");
			Scanner keyboard=new Scanner(System.in);
			String sellAmount=keyboard.nextLine();
			
			sellAmount = sellAmount.toLowerCase();
			if(sellAmount.equals("y")) 
			if (sellAmount.equals("y")) {
				
				System.out.println("What is the current value of the stock? "+top);
				Scanner keyboard1=new Scanner(System.in);
				int currentPrice=keyboard1.nextInt();
				
				numberOfInvestments--;
				int sellingValue=currentPrice*topShares;
				System.out.println("You have succesfully sold "+top +" at "+sellingValue);
	
				System.out.println(" You now have a total of "+numberOfInvestments + " investments");
			


			}
			else {
				System.out.println("Enter the number of shares of "+top);

				Scanner keyboard3=new Scanner(System.in);
				int numberofSharesToSell=keyboard3.nextInt();
				
				
				topShares-=numberofSharesToSell;
				MyStonks.push(top);
				NumberOfSharesBought.push(topShares);
				PriceOfShares.push(topPriceOfShares);
				}
				
			}
			
			
			
			
			
			
			

			
		}
			
			
			
		
		
	
 public static void main(String[] args) {
	 
	buy();
	buy();

	
	check();
	sell();
	check();
	sell();
	
	
	
	
 }
	
}


