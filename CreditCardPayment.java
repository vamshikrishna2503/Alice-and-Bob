
public abstract class CreditCardPayment implements PaymentMethod{
	
	private double amount;
	private double surcharge;
	
	public CreditCardPayment(double amount, double surcharge) {
		this.amount = amount;
		this.surcharge = surcharge;
	}
	
	public double getSurchargeAmount() {
		
		return amount * surcharge;
	}
	
	public double getTotalAmount() {
		
		return amount + (amount * surcharge);
	}
	
	
}
