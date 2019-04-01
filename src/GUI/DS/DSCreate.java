package GUI.DS;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import Bank.WhenSQLExceptionOccurs;

public class DSCreate extends JFrame implements ActionListener {
	public JButton login, create, show, status, addbal, cnf;
	public CheckboxGroup bg;
	public Checkbox rb_ml, rb_fl;
	public JTextField tf_fnm, tf_lnm, tf_pno, tf_user;
	public JSpinner sp;
	public JComboBox<String> jcb_cnt;
	public JLabel l_fnm, l_lnm, gender, age, addrss, info, l_pno, l_terms, l_terms2, l_cnt, jl_user, jl_pass, l_err;
	public JTextArea ta_addrss;
	public JCheckBox cb_terms;
	public JPasswordField tf_pass;
    public Container c;
	public WhenSQLExceptionOccurs sq;
	
	public DSCreate(WhenSQLExceptionOccurs sq) {
	   c = getContentPane(); c.setBackground(Color.black);
	   c.setLayout(null); this.sq = sq;
	   
	   login = new JButton("Login"); login.setBackground(Color.darkGray); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 200, 60); login.setMnemonic('l'); login.setToolTipText("LogIn");                                     
	   create = new JButton("Create Account"); create.setBackground(Color.black); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 110, 200, 60); create.setMnemonic('c'); create.setToolTipText("Create Account");
	   addbal = new JButton("Add Balance"); addbal.setBackground(Color.darkGray); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 170, 200, 60); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
 	   show = new JButton("Show Balance"); show.setBackground(Color.darkGray); show.setForeground(Color.white); show.setFont(new Font("Helvetica", Font.PLAIN, 15)); show.setBounds(0, 230, 200, 60); show.setMnemonic('w'); show.setToolTipText("Show Balance");
       status = new JButton("Status"); status.setBackground(Color.darkGray); status.setForeground(Color.white); status.setFont(new Font("Helvetica", Font.PLAIN, 15)); status.setBounds(0, 290, 200, 60); status.setMnemonic('s'); status.setToolTipText("Account Status");
       
       create.setEnabled(true); addbal.setEnabled(false); 	show.setEnabled(false); status.setEnabled(false);     
       c.add(login); c.add(create); c.add(addbal); c.add(show); c.add(status);
       
       l_fnm = new JLabel("First Name *"); l_fnm.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_fnm.setBounds(250, 80, 100, 20); l_fnm.setBackground(Color.gray); l_fnm.setForeground(Color.white);
       l_lnm = new JLabel("Last Name *");  l_lnm.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_lnm.setBounds(250, 120, 100, 20); l_lnm.setBackground(Color.gray); l_lnm.setForeground(Color.white);
       gender = new JLabel("Gender"); gender.setFont(new Font("Helvetica", Font.PLAIN, 17)); gender.setBounds(250, 160, 100, 20); gender.setBackground(Color.gray); gender.setForeground(Color.white);
       age = new JLabel("Age *"); age.setFont(new Font("Helvetica", Font.PLAIN, 17)); age.setBounds(250, 230, 100, 20); age.setBackground(Color.gray); age.setForeground(Color.white);
       addrss = new JLabel("Address *"); addrss.setFont(new Font("Helvetica", Font.PLAIN, 17)); addrss.setBounds(250, 312, 100, 20); addrss.setBackground(Color.gray); addrss.setForeground(Color.white);
       
       info = new JLabel("Fields marked with * are Mandetory");  info.setFont(new Font("Helvetica", Font.PLAIN, 17)); info.setBackground(Color.black); info.setForeground(Color.red); info.setBounds(400, 35, 300, 20);
       sp = new JSpinner(); sp.setBounds(360, 230, 50, 20); sp.setForeground(Color.red); sp.setBackground(Color.black); sp.setFont(new Font("Helvetica", Font.BOLD, 13));
       ta_addrss = new JTextArea(10, 20); ta_addrss.setFont(new Font("Helvetica", Font.PLAIN, 15)); ta_addrss.setBounds(360, 312, 200, 100); ta_addrss.setBackground(Color.darkGray); ta_addrss.setForeground(Color.white); ta_addrss.setLineWrap(true);
       bg = new CheckboxGroup();
       rb_ml = new Checkbox("Male", bg, true); rb_ml.setFont(new Font("Helvetica", Font.PLAIN, 15)); rb_ml.setBackground(Color.black); rb_ml.setForeground(Color.white); rb_ml.setBounds(360, 160, 100, 20); 
       rb_fl = new Checkbox("Female", bg, false); rb_fl.setFont(new Font("Helvetica", Font.PLAIN, 15)); rb_fl.setBackground(Color.black); rb_fl.setForeground(Color.white); rb_fl.setBounds(360, 190, 100, 20);
       //bg.add(rb_ml) bg.add(rb_fl);
       
       tf_fnm = new JTextField("", 25); tf_fnm.setFont(new Font("Verdana", Font.PLAIN, 15)); tf_fnm.setBounds(360, 80, 150, 22); tf_fnm.setBackground(Color.darkGray); tf_fnm.setForeground(Color.white);
       tf_lnm = new JTextField("", 25); tf_lnm.setFont(new Font("Verdana", Font.PLAIN, 15)); tf_lnm.setBounds(360, 120, 150, 22); tf_lnm.setBackground(Color.darkGray); tf_lnm.setForeground(Color.white); 
       
       l_pno = new JLabel("Mobile Number"); l_pno.setFont(new Font("Helvetica", Font.PLAIN, 15)); l_pno.setBounds(250, 270, 150, 22); l_pno.setBackground(Color.black); l_pno.setForeground(Color.white); 
       tf_pno = new JTextField("", 100); tf_pno.setFont(new Font("Verdana", Font.PLAIN, 15)); tf_pno.setBounds(360, 270, 150, 22); tf_pno.setBackground(Color.darkGray); tf_pno.setForeground(Color.white); 
       l_terms = new JLabel("I accept all Terms and Conditions of Reserve Bank"); l_terms.setFont(new Font("Verdana", Font.PLAIN, 15)); l_terms.setBounds(280, 552, 600, 20); l_terms.setBackground(Color.black); l_terms.setForeground(Color.white); 
       l_terms2 = new JLabel("Confirms all the provided details are true");  l_terms2.setFont(new Font("Verdana", Font.PLAIN, 15)); l_terms2.setBounds(280, 572, 600, 20); l_terms2.setBackground(Color.black); l_terms2.setForeground(Color.white);
       cb_terms = new JCheckBox("", true); cb_terms.setBounds(250, 552, 20, 20); cb_terms.setBackground(Color.black); 
       jcb_cnt = new JComboBox<>();  jcb_cnt.addItem("Bhutan"); jcb_cnt.addItem("China"); jcb_cnt.addItem("France"); jcb_cnt.addItem("Germany"); jcb_cnt.addItem("India"); jcb_cnt.addItem("Iran"); jcb_cnt.addItem("Iraq"); jcb_cnt.addItem("Isreal"); jcb_cnt.addItem("Japan"); jcb_cnt.addItem("Maldives"); jcb_cnt.addItem("Mayamar"); jcb_cnt.addItem("Nepal"); jcb_cnt.addItem("Russia"); jcb_cnt.addItem("Shri Lanka"); jcb_cnt.addItem("South Korea"); jcb_cnt.addItem("Turkey"); jcb_cnt.addItem("United Arab Emirates"); jcb_cnt.addItem("United States of America"); 
       jcb_cnt.setBackground(Color.darkGray);jcb_cnt.setFont(new Font("Tahoma", Font.PLAIN, 16)); jcb_cnt.setForeground(Color.white); jcb_cnt.setBounds(360, 432, 200, 20); 
       l_cnt = new JLabel("Country *"); l_cnt.setBackground(Color.black); l_cnt.setForeground(Color.white); l_cnt.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_cnt.setBounds(250, 432, 100, 20); 
       cnf = new JButton("Confirm");  cnf.setFont(new Font("Helvetica", Font.BOLD, 15)); cnf.setBounds(280, 620, 100, 30); cnf.setBackground(Color.red); cnf.setForeground(Color.white); 
       cb_terms.addChangeListener(e -> {if(cb_terms.isSelected()) cnf.setEnabled(true); else cnf.setEnabled(false); });
       
       jl_user = new JLabel("Username *");  jl_user.setFont(new Font("Helvetica", Font.PLAIN, 17)); jl_user.setBounds(250, 472, 100, 20); jl_user.setBackground(Color.red); jl_user.setForeground(Color.white); 
       tf_user = new JTextField(25);  tf_user.setFont(new Font("Helvetica", Font.PLAIN, 17)); tf_user.setBounds(360, 472, 150, 20); tf_user.setBackground(Color.darkGray); tf_user.setForeground(Color.white); 
       jl_pass = new JLabel("Password *");  jl_pass.setFont(new Font("Helvetica", Font.PLAIN, 17)); jl_pass.setBounds(250, 502, 100, 20); jl_pass.setBackground(Color.red); jl_pass.setForeground(Color.white); 
       tf_pass = new JPasswordField(25);  tf_pass.setFont(new Font("Helvetica", Font.PLAIN, 17)); tf_pass.setBounds(360, 502, 150, 20); tf_pass.setBackground(Color.darkGray); tf_pass.setForeground(Color.white); 
       l_err = new JLabel("Enter Details Correctly"); l_err.setBackground(Color.black); l_err.setForeground(Color.red); l_err.setFont(new Font("Helvetica", Font.PLAIN, 13)); l_err.setBounds(280, 590, 300, 30); l_err.setVisible(false); c.add(l_err); 
       
       c.add(l_fnm); c.add(l_lnm); c.add(gender); c.add(age); c.add(addrss); c.add(sp); c.add(ta_addrss); c.add(rb_ml); c.add(rb_fl); c.add(tf_fnm); c.add(tf_lnm); c.add(info); c.add(l_pno); c.add(tf_pno); c.add(jcb_cnt); c.add(l_cnt); c.add(cnf); c.add(l_terms); c.add(cb_terms); c.add(l_terms2); c.add(jl_user); c.add(jl_pass); c.add(tf_user); c.add(tf_pass);     
	   
       this.setSize(690, 700); this.setResizable(false);  this.setTitle("Create Account"); this.setVisible(true);
	
        login.addActionListener(this);
	    addbal.addActionListener(this);
	    show.addActionListener(this);
	    status.addActionListener(this);
	    cnf.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == cnf) { sq.createAccount(this);} 
		if(ae.getSource() == login) {new DSLogin(sq); this.dispose();}
		if(ae.getSource() == addbal) {sq.addBalance1(new DSAddbalance(sq)); this.dispose();}
		if(ae.getSource() == show) {sq.showBalance(new DSShow(sq)); this.dispose();}
		if(ae.getSource() == status) {sq.showDetails(new DSStatus(sq)); this.dispose();}
	}
}










