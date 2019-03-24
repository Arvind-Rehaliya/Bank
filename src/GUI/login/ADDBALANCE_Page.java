package GUI.login;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import Bank.ReserveBank;

public class ADDBALANCE_Page extends JFrame implements ActionListener{
	public JButton login, create, show, status, addbal, ok;
	public TextField user;
	public JPasswordField pass;
	public JLabel usr, pss;
	
    public JLabel l_name, l_accnt, l_pno, l_bal, l_gname, l_gaccnt, l_gpno;
    public JTextField tf_bal;
	public JButton bt_cnf;
    public Container c;
	public ReserveBank rb;
	
	public ADDBALANCE_Page(ReserveBank rb) {
		   c = getContentPane(); c.setBackground(Color.black);
		   c.setLayout(null); this.rb = rb;

		   login = new JButton("Login"); login.setBackground(Color.darkGray); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 200, 60); login.setMnemonic('l'); login.setToolTipText("LogIn");                                     
		   create = new JButton("Create Account"); create.setBackground(Color.darkGray); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 110, 200, 60); create.setMnemonic('c'); create.setToolTipText("Create Account");
		   addbal = new JButton("Add Balance"); addbal.setBackground(Color.black); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 170, 200, 60); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
	 	   show = new JButton("Show Balance"); show.setBackground(Color.darkGray); show.setForeground(Color.white); show.setFont(new Font("Helvetica", Font.PLAIN, 15)); show.setBounds(0, 230, 200, 60); show.setMnemonic('w'); show.setToolTipText("Show Balance");
	       status = new JButton("Status"); status.setBackground(Color.darkGray); status.setForeground(Color.white); status.setFont(new Font("Helvetica", Font.PLAIN, 15)); status.setBounds(0, 290, 200, 60); status.setMnemonic('s'); status.setToolTipText("Account Status");
	       
			c.add(login); c.add(create); c.add(addbal); c.add(show); c.add(status);
		
			l_name = new JLabel("Account Holder Name", JLabel.RIGHT);  l_name.setBackground(Color.black); l_name.setForeground(Color.yellow); l_name.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_name.setBounds(200, 100, 200, 30); 
			l_accnt = new JLabel("Account Number", JLabel.RIGHT); l_accnt.setBackground(Color.black); l_accnt.setForeground(Color.yellow); l_accnt.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_accnt.setBounds(200, 150, 200, 30); 
			l_pno = new JLabel("Phone Number", JLabel.RIGHT); l_pno.setBackground(Color.black); l_pno.setForeground(Color.yellow); l_pno.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_pno.setBounds(200, 200, 200, 30); 
			l_bal = new JLabel("Enter Amount", JLabel.RIGHT); l_bal.setBackground(Color.black); l_bal.setForeground(Color.yellow); l_bal.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_bal.setBounds(200, 250, 200, 30); 
			
			l_gname = new JLabel(); l_gname.setBackground(Color.black); l_gname.setForeground(Color.white); l_gname.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_gname.setBounds(420, 100, 300, 30); 
			l_gaccnt = new JLabel(); l_gaccnt.setBackground(Color.black); l_gaccnt.setForeground(Color.white); l_gaccnt.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_gaccnt.setBounds(420, 150, 300, 30); 
			l_gpno = new JLabel(); l_gpno.setBackground(Color.black); l_gpno.setForeground(Color.white); l_gpno.setFont(new Font("Helvetica", Font.PLAIN, 17)); l_gpno.setBounds(420, 200, 300, 30); 
			tf_bal = new JTextField("", 20); tf_bal.setBackground(Color.black); tf_bal.setForeground(Color.white); tf_bal.setFont(new Font("Helvetica", Font.PLAIN, 17)); tf_bal.setBounds(420, 250, 100, 30); 
			
			bt_cnf = new JButton("Confirm"); bt_cnf.setBackground(Color.red); bt_cnf.setForeground(Color.white); bt_cnf.setFont(new Font("Helvetica", Font.PLAIN, 17)); bt_cnf.setBounds(420, 300, 100, 30); 
            c.add(l_name); c.add(l_pno); c.add(l_accnt); c.add(l_bal); c.add(l_gname); c.add(l_gpno); c.add(l_gaccnt); c.add(tf_bal); c.add(bt_cnf);
			
            login.addActionListener(this);
    	    create.addActionListener(this);
    	    show.addActionListener(this);
    	    status.addActionListener(this);
    	    bt_cnf.addActionListener(this);
            
            this.setSize(620, 430); this.setResizable(false); this.setVisible(true); this.setTitle("Add Balance");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == bt_cnf) {rb.addBalance(rb, this);} 
		if(ae.getSource() == login) {LOGIN_Page login = new LOGIN_Page(rb); this.dispose();}
		if(ae.getSource() == create) {CREATE_Page create = new CREATE_Page(rb); this.dispose();}
		if(ae.getSource() == show) {SHOW_Page show = new SHOW_Page(rb); rb.showBalance(rb, show);	 this.dispose();}
		if(ae.getSource() == status) {STATUS_Page status = new STATUS_Page(rb); rb.showDetails(rb, status); this.dispose();}
	}
}











