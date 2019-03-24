package Bank;

import java.sql.*;
import java.sql.ResultSet;

import GUI.login.CREATE_Page;
import GUI.login.LOGIN_Page;
import GUI.login.ADDBALANCE_Page;
import GUI.login.STATUS_Page;
import GUI.login.SHOW_Page;

public class ReserveBank extends BankAdapter {
	Connection con;
	Statement st;
	ResultSet rs;
	private boolean serverStatus = false;
	private Byte flag = new Byte("0");
	private String fname, lname, country, address, username;
	private String gender;
	private Integer age = null;
	private Long pno; private Integer account; private Float balance = new Float(0);
	
	public ReserveBank() {}
	@Override
	public void turnBankServerOn() {
		try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
		  st = con.createStatement();
		  serverStatus = true;
		 
		} catch(Exception e) {
			e.printStackTrace(); System.out.println("Wait until Bank Server On"); }
		
   }
	// Implementation for Create Account for given Account_No. and Customer Name
	@Override
	public void createAccount(ReserveBank rb, CREATE_Page cp) {
		String fname = cp.tf_fnm.getText();
		String lname = cp.tf_lnm.getText();
		String gender; if(cp.bg.getSelectedCheckbox().getLabel().equals("Male")) gender = "M"; else gender = "F";
		Integer age = (Integer)cp.sp.getValue();
		String addrss = cp.ta_addrss.getText();
		Long pno = Long.parseLong(cp.tf_pno.getText());
		String country = (String)cp.jcb_cnt.getSelectedItem();
		String user = cp.tf_user.getText();
		String pass = cp.tf_pass.getText();
		System.out.println(fname+" "+lname+" "+gender+" "+age+" "+addrss+" "+pno+" "+country+" "+user+" "+pass);
		try {
		    rb.st.executeUpdate("Insert into user_database(First_Name, Last_Name, Gender, Age, Phone_Number, Address, Country, Username, Password) values('"+fname+"', '"+lname+"', '"+gender+"', "+age+", "+pno+", '"+addrss+"', '"+country+"', '"+user+"', '"+pass+"');");
			System.out.println("Account Successfully Created for : "+fname+" "+lname);
			rb.fname = fname; rb.lname = lname; rb.country = country; rb.address = addrss; rb.gender = gender; rb.age = age; rb.pno = pno; rb.username = user;
			generateAccountNo(rb); 
			new LOGIN_Page(rb); cp.dispose();
		} catch(Exception e) {System.out.println(e+"\nAccount Not Created for "+fname+" "+lname);}
   }
	// Implementation for Add Balance for given Account_No. and Balance
	@Override
	public void addBalance(ReserveBank rb, ADDBALANCE_Page ad) {
        String bal = ad.tf_bal.getText();
		Float f = Float.parseFloat(bal);
		try {
    		rb.rs = rb.st.executeQuery("SElect * from user_database;");
		while(rb.rs.next()) 
    	if(rb.account.intValue() == rb.rs.getInt(11)) {
    		rb.balance += f;
    		rb.st.executeUpdate("update user_database set Balance = "+f+" where Account_No = "+rb.account.intValue()+";");
    		showBalance(rb, new SHOW_Page(rb)); ad.dispose();
    	}
    	}catch(Exception e) {System.out.println(e);}
   }
	public void addBalance1(ReserveBank rb, ADDBALANCE_Page ad) {
	   ad.l_gname.setText(rb.fname+" "+rb.lname);
	   ad.l_gaccnt.setText(rb.account.toString());
	   ad.l_gpno.setText(rb.pno.toString());
    }
    // Implementation for Show Balance for given Account_No.	
	public int showBalance(ReserveBank rb, SHOW_Page sp) {
		try { 
	       rb.rs = rb.st.executeQuery("Select * from user_database;");
    	   while(rb.rs.next()) 
    		if(rb.account.intValue() == rb.rs.getInt(11)) {
                sp.l_gname.setText(rb.fname+" "+rb.lname);
                sp.l_gaccnt.setText(rb.account.toString());
                sp.l_gpno.setText(rb.pno.toString());
                sp.l_avlbal.setText(rb.balance.toString());
    		}
    	
		} catch(Exception e) {System.out.println("Exception from showBalance()"); return 0;}
    	return 0;
   }
	// Implementation for display
//	private void display() {
//		System.out.println("\nName : "+name+"\nAccnt_No : "+accnt+"\nBalance : "+bal);  
//	}
	
	public void authentic(LOGIN_Page lp, ReserveBank rb) {
		Byte b = 0;
		String pass = lp.pass.getText();
		String user = lp.user.getText();
		
		try {
		rb.rs = rb.st.executeQuery("Select * from user_database;");
		while(rb.rs.next())
		if(user.equals(rb.rs.getString(8)) && pass.equals(rb.rs.getString(9))) {
			rb.fname = rb.rs.getString(1); rb.lname = rb.rs.getString(2); rb.country = rb.rs.getString(7); rb.address = rb.rs.getString(6); rb.gender = rb.rs.getString(3); rb.age = rb.rs.getInt(4); rb.pno = rb.rs.getLong(5); rb.username = rb.rs.getString(8); rb.balance = rb.rs.getFloat(10);  
			lp.jl_err.setVisible(false); rb.account = rb.rs.getInt(11);
		    lp.addbal.setEnabled(true); lp.show.setEnabled(true); lp.status.setEnabled(true); b = 1;
		}
		if(b == 0) lp.jl_err.setVisible(true);
		} catch(Exception ex) {System.out.println(ex+"Exception From authentic()");};
	}
	
	// Implementation for generateAccountN using rb
	public void generateAccountNo(ReserveBank rb) {
		byte acc = 0;
		try {
		rb.rs = rb.st.executeQuery("Select Account_No from user_database;");
		while(rb.rs.next()) acc++; 
		rb.account = 982461454+(acc-1);
		rb.st.executeUpdate("Update user_database set Account_No ="+rb.account+" where Phone_Number = "+rb.pno+";");
		} catch(Exception ex) {System.out.println(ex+"Exception From generateAccount_No()");}
	}
	public void showDetails(ReserveBank rb, STATUS_Page st) {
		st.jl_gfnm.setText(rb.fname);
		st.jl_glnm.setText(rb.lname);
		st.jl_gage.setText(rb.age.toString());
		st.jl_gcnt.setText(rb.country);
		st.jl_ggender.setText(rb.gender);
		st.jl_gpno.setText(rb.pno.toString());
        st.ta_addrss.setText(rb.address);		
	}

}











