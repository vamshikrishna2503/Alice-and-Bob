
public class CashPayment implements PaymentMethod{

	private double amount;
	
	public CashPayment(double amount) {
		
		this.amount = amount;
	}
	
	@Override
	public double getSurchargeAmount() {
		return 0;
	}

	@Override
	public double getTotalAmount() {
		
		return this.amount;
	}

	
}
