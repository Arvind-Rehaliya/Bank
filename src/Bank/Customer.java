package Bank;

import GUI.login.LOGIN_Page;

public class Customer extends BankAdapter  {
	
	public static void main(String[] args) {
		System.out.printf("Welcome to Reserve Bank");
		ReserveBank rb = new ReserveBank();
		rb.turnBankServerOn();
		new LOGIN_Page(rb);     
	}
}