package Bank;

import GUI.login.LOGIN_Page;
import GUI.login.CREATE_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public interface BankProcedure {
    void turnBankServerOn();
	void createAccount(CREATE_Page cp);
	void addBalance(ADDBALANCE_Page ad);
    void addBalance1(ADDBALANCE_Page ad);    
    void showBalance(SHOW_Page sp);
    void authentic(LOGIN_Page lp);
    void generateAccountNo();
    void showDetails(STATUS_Page st);
}
