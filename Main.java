import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<CreditCardPayment> cardSales = new ArrayList<CreditCardPayment>();
	public static ArrayList<CashPayment> cashSales = new ArrayList<CashPayment>();
	
	public static void main(String[] args) {
		
		int userChoice = -1;
		Scanner input = new Scanner(System.in);
		
		do {
			
			menu();
			System.out.print("Enter your choice: ");
			userChoice = input.nextInt();
			
			System.out.println();
			
			switch(userChoice) {
				case 1: System.out.print("Enter sales amount: ");
						double cashAmount = input.nextDouble();
						input.nextLine();
						cashSales.add(new CashPayment(cashAmount));
						break;
				
				case 2: System.out.print("Enter sales amount: ");
						double cardAmount = input.nextDouble();
						
						System.out.println();
						System.out.println("Enter 1 for Mastercard");
						System.out.println("Enter 2 for Visa");
						System.out.println("Enter 3 for Amex");
						System.out.print("Enter your choice: ");
						
						int cardType = input.nextInt();
						
						if(cardType == 1) {
							cardSales.add(new MastercardPayment(cardAmount));
						}
						else if(cardType == 2) {
							cardSales.add(new VisaPayment(cardAmount));
						}
						else if(cardType == 3) {
							cardSales.add(new AmexPayment(cardAmount));
						}
						break;
						
				case 3: System.out.println("Total cash sales: " + getTotalCashSales());
						break;
						
				case 4: System.out.println("Total card sales: " + getTotalCardSales());
						break;
						
				case 5: System.out.println("Total card surcharges: " + getTotalSurchageAmount());
						break;
				
				case 6: System.out.println("Total product sales: " + getTotalProductSales());
						break;
				
				case 7: return;
			}
			
		}while(userChoice != 7);
	}


	public static void menu() {
		System.out.println();
		System.out.println("1. Enter sale");
		System.out.println("2. Display total cash sales");
		System.out.println("3. Display total card sales");
		System.out.println("4. Display total card surcharges");
		System.out.println("5. Display total product sales");
		System.out.println("6. Exit");
	}
	
	public static double getTotalCashSales() {
		
		double total = 0;
		
		for(int i = 0; i < cashSales.size(); i++) {
			
			total += cashSales.get(i).getTotalAmount();
		}
		
		return total;
	}
	
	public static double getTotalCardSales() {
		
		double total = 0;
		
		for(int i = 0; i < cardSales.size(); i++) {
			
			total += cardSales.get(i).getTotalAmount();
		}
		
		return total;
	}
	
	public static double getTotalSurchageAmount() {
		
		double total = 0;
		
		for(int i = 0; i < cardSales.size(); i++) {
			
			total += cardSales.get(i).getSurchargeAmount();
		}
		
		return total;
	}
	
	public static double getTotalProductSales() {
		
		return getTotalCashSales() + getTotalCardSales();
	}
}
