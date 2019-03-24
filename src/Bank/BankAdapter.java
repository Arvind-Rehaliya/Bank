package Bank;

import GUI.login.LOGIN_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.CREATE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public class BankAdapter implements BankProcedure {
	@Override
	public void turnBankServerOn() {}
	
	@Override
	public void createAccount(ReserveBank rb, CREATE_Page cp) {}
	@Override
	public void addBalance(ReserveBank rb, ADDBALANCE_Page ad) {}
	
	@Override
	public int showBalance(ReserveBank rb, SHOW_Page sp) {return 0;}
	
	@Override
	public void authentic(LOGIN_Page lp, ReserveBank rb) {}
	
	@Override
	public void generateAccountNo(ReserveBank rb) {}
	
	@Override
	public void addBalance1(ReserveBank rb, ADDBALANCE_Page ad) {}	 
	
	@Override
	public void showDetails(ReserveBank rb, STATUS_Page st) {}

}
