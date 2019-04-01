package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import GUI.DS.DSAddbalance;
import GUI.DS.DSCreate;
import GUI.DS.DSShow;
import GUI.DS.DSStatus;
import GUI.DS.DSLogin;

public class WhenSQLExceptionOccurs {
	private ArrayList<String> a_fname = new ArrayList<String>();
	private ArrayList<String> a_lname = new ArrayList<String>();
	private ArrayList<String> a_gender = new ArrayList<String>();
	private ArrayList<String> a_country = new ArrayList<String>();
	private ArrayList<String> a_user = new ArrayList<String>();
	private ArrayList<String> a_pass = new ArrayList<String>();
	private ArrayList<Long> a_pno = new ArrayList<Long>();
	private ArrayList<Long> a_accntno = new ArrayList<Long>();
	private ArrayList<Double>  a_bal = new ArrayList<>();
	private ArrayList<Integer> a_age = new ArrayList<>();
	private ArrayList<String> a_addrss = new ArrayList<>();
    
	private String fname, lname, country, address, username, gender;
	private Integer age;
	private Long pno; private Long account = new Long(98445844); private Double bal = new Double(0);
	private int i = 0;
	
	public void createAccount(DSCreate cp) { 
		try {
		String fname = cp.tf_fnm.getText();
		String lname = cp.tf_lnm.getText();
		String gender; if(cp.bg.getSelectedCheckbox().getLabel().equals("Male")) gender = "Male"; else gender = "Female";
		Integer age = (Integer)cp.sp.getValue();
		String addrss = cp.ta_addrss.getText();
		Long pno = Long.parseLong(cp.tf_pno.getText());
		String country = (String)cp.jcb_cnt.getSelectedItem();
		String user = cp.tf_user.getText();
		String pass = cp.tf_pass.getText();
		System.out.println(fname+" "+lname+" "+gender+" "+age+" "+addrss+" "+pno+" "+country+" "+user+" "+pass);
	
		a_fname.add(fname); a_lname.add(lname); a_gender.add(gender); a_age.add(age); a_addrss.add(addrss); a_pno.add(pno); a_country.add(country); a_user.add(user); a_pass.add(pass); 
		generateAccount(); a_accntno.add(account); a_bal.add(0.0);  
		new DSLogin(this); cp.dispose();
		} catch(Exception ex) {cp.l_err.setVisible(true);}
		
	}
	public void addBalance(DSAddbalance addbal) {
	    try {
		String bal = addbal.tf_bal.getText();
		this.bal += Double.parseDouble(bal);
		this.a_bal.set(i, this.bal);
		showBalance(new DSShow(this)); addbal.l_err.setVisible(false); addbal.dispose();
    	} catch(Exception ex) {addbal.l_err.setVisible(true);}
	}
	public void addBalance1(DSAddbalance addbal) {
		 addbal.l_gname.setText(this.fname+" "+this.lname);
		 addbal.l_gaccnt.setText(this.account.toString());
		 addbal.l_gpno.setText(this.pno.toString());
	}
	
	public void showBalance(DSShow show) {
		  show.l_gname.setText(this.fname+" "+this.lname);
          show.l_gaccnt.setText(this.account.toString());
          show.l_gpno.setText(this.pno.toString());
          show.l_avlbal.setText(this.bal.toString());
	}
	
	public void authentic(DSLogin ds) {
         try {
		  String user = ds.user.getText();
		  String pass = ds.pass.getText();
		 if(user.equals("") || pass.equals("")) throw new Exception();
		 
		  ListIterator<String> lu = a_user.listIterator();
		  ListIterator<String> lp = a_pass.listIterator();
	      if(!(lu.hasNext())) throw new MyBankException();
		  while(lu.hasNext()) { 
			    if(lu.next().equals(user)){
			    	if(lp.next().equals(pass)) {
				        ds.addbal.setEnabled(true); ds.bt_show.setEnabled(true); ds.bt_status.setEnabled(true); ds.jl_err.setVisible(false);
				        i = lu.nextIndex()-1; this.fillValues(i); this.bal = a_bal.get(i); showDetails(new DSStatus(this)); ds.dispose();
				    }
			    	else {
				    	//lp.next();
				        ds.addbal.setEnabled(false); ds.bt_show.setEnabled(false); ds.bt_status.setEnabled(false); ds.jl_err.setVisible(true);
				    }
			    }
			    else {
			    	lp.next();
			        ds.addbal.setEnabled(false); ds.bt_show.setEnabled(false); ds.bt_status.setEnabled(false); ds.jl_err.setVisible(true);
			    }
			    
		    }
		  
         } catch(MyBankException mb) {ds.jl_err.setText("Create Account First");ds.jl_err.setVisible(true);}
           catch(Exception ex) {ds.jl_err.setText("Fill both TextFields");ds.jl_err.setVisible(true);}
	}
	
	public void generateAccount() {
        Long l = new Long(0);
		Iterator<Long> li = a_accntno.iterator();
		while(li.hasNext()) {li.next(); l++;}
		this.account = 975448795L + l;
	}
	
	public void showDetails(DSStatus status) {
		status.jl_gfnm.setText(this.fname+" "+this.lname);
		status.jl_gage.setText(this.age.toString());
		status.jl_gcnt.setText(this.country);
		status.jl_ggender.setText(this.gender.toString());
		status.jl_gpno.setText(this.pno.toString());
        status.ta_addrss.setText(this.address);		
        status.jl_user.setText(this.username);
   }
	
	private void fillValues(int i) {
	     this.fname = a_fname.get(i);
		 this.lname = a_lname.get(i);
		 this.gender = a_gender.get(i);
		 this.country = a_country.get(i);
		 this.username = a_user.get(i);
		 this.pno = a_pno.get(i);
		 this.account = a_accntno.get(i);
		 this.bal = a_bal.get(i);
		 this.address = a_addrss.get(i);
		 this.age = a_age.get(i);
	}
}




































