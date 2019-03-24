package Bank;

import GUI.login.LOGIN_Page;
import GUI.login.CREATE_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public interface BankProcedure {
    void turnBankServerOn();
	void createAccount(ReserveBank rb, CREATE_Page cp);
	void addBalance(ReserveBank rb, ADDBALANCE_Page ad);
    void addBalance1(ReserveBank rb, ADDBALANCE_Page ad);    
    int showBalance(ReserveBank rb, SHOW_Page sp);
    void authentic(LOGIN_Page lp, ReserveBank rb);
    void generateAccountNo(ReserveBank rb);
    void showDetails(ReserveBank rb, STATUS_Page st);
}
