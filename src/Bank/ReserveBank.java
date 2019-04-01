package Bank;

import java.sql.Statement;
import java.sql.ResultSet;

import GUI.login.CREATE_Page;
import GUI.login.LOGIN_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public class ReserveBank extends BankAdapter {
	Statement st;
	ResultSet rs;
	private String fname, lname, country, address, username;
	private String gender;
	private Integer age;
	private Long pno; private Integer account; private Float balance = new Float(0);
	
	public ReserveBank(Statement st) {
		this.st = st;
	}
	
	/* Implementation for Create Account taking parameter of CREATE_Page class 
	 * to retrive data from that class that is entered or required to create account
	 * notice all the components are accessed by cp.*** as prefix
	*/
	@Override
	public void createAccount(CREATE_Page cp) {
		try {
		String fname = cp.tf_fnm.getText(); // retreive entered first name
		String lname = cp.tf_lnm.getText(); // retreive entered last name
		String gender; if(cp.bg.getSelectedCheckbox().getLabel().equals("Male")) gender = "Male"; else gender = "Female";
		Integer age = (Integer)cp.sp.getValue(); // retreive entered age
		String addrss = cp.ta_addrss.getText(); // retreive entered address
		Long pno = Long.parseLong(cp.tf_pno.getText()); // retreive entered Phone Number
		String country = (String)cp.jcb_cnt.getSelectedItem(); // retreive selected country
		String user = cp.tf_user.getText(); // retreive entered user name
		String pass = cp.tf_pass.getText(); // retreive entered password
		System.out.println(fname+" "+lname+" "+gender+" "+age+" "+addrss+" "+pno+" "+country+" "+user+" "+pass);
		    this.st.executeUpdate("Insert into user_database(First_Name, Last_Name, Gender, Age, Phone_Number, Address, Country, Username, Password) values('"+fname+"', '"+lname+"', '"+gender+"', "+age+", "+pno+", '"+addrss+"', '"+country+"', '"+user+"', '"+pass+"');");
			System.out.println("Account Successfully Created for : "+fname+" "+lname);
			this.fname = fname; this.lname = lname; this.country = country; this.address = addrss; this.gender = gender; this.age = age; this.pno = pno; this.username = user;
			cp.l_err.setVisible(false); generateAccountNo();  
			new LOGIN_Page(this); cp.dispose();
		} catch(Exception ex) {System.out.println(ex); cp.l_err.setVisible(true);}
	}
	/* Implementation for Add Balance taking parameter of ADDBALANCE_Page class
	 * to retrieve entered amount.
	 */
	@Override
	public void addBalance(ADDBALANCE_Page ad) {
		try {
        String bal = ad.tf_bal.getText();
		Float f = Float.parseFloat(bal);
    		rs = st.executeQuery("SElect * from user_database;");
		while(rs.next()) 
    	if(account.intValue() == rs.getInt(11)) {
    		balance += f;
    		st.executeUpdate("update user_database set Balance = "+balance+" where Account_No = "+account.intValue()+";");
    		showBalance(new SHOW_Page(this)); ad.dispose();
    	}
    	}catch(Exception e) {ad.l_err.setVisible(true);}
   }
	/* Implementation or addBalance1 method taking parameter of ADDBALANCE_Page class
	 * to display some user's details
	 */
	public void addBalance1(ADDBALANCE_Page ad) {
	   ad.l_gname.setText(fname+" "+lname);
	   ad.l_gaccnt.setText(account.toString());
	   ad.l_gpno.setText(pno.toString());
    }
    /* Implementation for Show Balance taking parameter of SHOW_Page
     * to display name, account_no, Phone No, available balance	
	 */
	public void showBalance(SHOW_Page sp) {
		try { 
	       rs = st.executeQuery("Select * from user_database;");
    	   while(rs.next()) 
    		if(account.intValue() == rs.getInt(11)) {
                sp.l_gname.setText(fname+" "+lname);
                sp.l_gaccnt.setText(account.toString());
                sp.l_gpno.setText(pno.toString());
                sp.l_avlbal.setText(balance.toString());
    		}
    	
		} catch(Exception e) { }
   }
	/* Implementation for authentic method which takes paremeter of LOGIN_Page
	 * which is required to retrive username and password
	 * to chech if they are valid or not
	 */
	public void authentic(LOGIN_Page lp) {
		Integer i = new Integer(0);
		try {
		String pass = lp.pass.getText();
		String user = lp.user.getText();
		if(user.equals("") || pass.equals("")) throw new MyBankException(); 
		
		rs = st.executeQuery("Select * from user_database;");
		while(rs.next())
		if(user.equals(rs.getString(8)) && pass.equals(rs.getString(9))) {
			fname = rs.getString(1); lname = rs.getString(2); country = rs.getString(7); address = rs.getString(6); gender = rs.getString(3); age = rs.getInt(4); pno = rs.getLong(5); username = rs.getString(8); balance = rs.getFloat(10);  
			lp.jl_err.setVisible(false); account = rs.getInt(11);
		    lp.addbal.setEnabled(true); lp.show.setEnabled(true); lp.status.setEnabled(true); //lp.dispose(); this.showDetails(new STATUS_Page(this)); 
		    i = 1;
		}
		if(i == 0) {lp.jl_err.setText("Invalid Username or Password"); lp.jl_err.setVisible(true);}
		} catch(MyBankException ex) {lp.jl_err.setText("Fill both TextFields"); lp.jl_err.setVisible(true);} 
		  catch(Exception ex) {lp.jl_err.setText("Invalid Username or Password"); lp.jl_err.setVisible(true);}
	}
	
	// Implementation for generateAccountN which automatically generates account for user just after creating account
	public void generateAccountNo() {
		byte acc = 0;
		try {
		rs = st.executeQuery("Select Account_No from user_database;");
		while(rs.next()) acc++; 
		this.account = 982461454+(acc-1);
		st.executeUpdate("Update user_database set Account_No ="+account+" where Phone_Number = "+pno+";");
		} catch(Exception ex) {System.out.println(ex+"Exception From generateAccount_No()");}
	}
	
	// Implementation for showDetails method taking parameter of STATUS_Page class to display data
	public void showDetails(STATUS_Page st) {
		st.jl_user.setText(this.username);
		st.jl_gfnm.setText(this.fname+" "+this.lname);
		st.jl_gage.setText(this.age.toString());
		st.jl_gcnt.setText(this.country);
		st.jl_ggender.setText(this.gender);
		st.jl_gpno.setText(this.pno.toString());
        st.ta_addrss.setText(this.address);		
	}

}











