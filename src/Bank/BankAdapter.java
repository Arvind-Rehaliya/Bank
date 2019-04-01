package Bank;

import GUI.login.LOGIN_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.CREATE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public class BankAdapter implements BankProcedure {
	
	// blank implementation of all methods of BankProcedure
	
	@Override
	public void turnBankServerOn() {}
	
	@Override
	public void createAccount(CREATE_Page cp) {}
	@Override
	public void addBalance(ADDBALANCE_Page ad) {}
	
	@Override
	public void showBalance(SHOW_Page sp) {}
	
	@Override
	public void authentic(LOGIN_Page lp) {}
	
	@Override
	public void generateAccountNo() {}
	
	@Override
	public void addBalance1(ADDBALANCE_Page ad) {}	 
	
	@Override
	public void showDetails(STATUS_Page st) {}

}
