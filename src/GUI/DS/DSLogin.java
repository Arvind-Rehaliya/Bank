package GUI.DS;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JButton;
import Bank.WhenSQLExceptionOccurs;

public class DSLogin extends JFrame implements ActionListener {
	public JButton login, create, bt_show, bt_status, addbal, ok;
	public TextField user;
	public JPasswordField pass;
	public JLabel usr, pss, jl_err;
    public Container c;
	public WhenSQLExceptionOccurs sq;
	
	public DSLogin(WhenSQLExceptionOccurs sq) {
	   c = getContentPane(); c.setBackground(Color.black);
	   c.setLayout(null); this.sq = sq;

	   login = new JButton("Login"); login.setBackground(Color.black); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 200, 60); login.setMnemonic('l'); login.setToolTipText("LogIn");                                     
	   create = new JButton("Create Account"); create.setBackground(Color.darkGray); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 110, 200, 60); create.setMnemonic('c'); create.setToolTipText("Create Account");
	   addbal = new JButton("Add Balance"); addbal.setBackground(Color.darkGray); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 170, 200, 60); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
 	   bt_show = new JButton("Show Balance"); bt_show.setBackground(Color.darkGray); bt_show.setForeground(Color.white); bt_show.setFont(new Font("Helvetica", Font.PLAIN, 15)); bt_show.setBounds(0, 230, 200, 60); bt_show.setMnemonic('w'); bt_show.setToolTipText("Show Balance");
       bt_status = new JButton("Status"); bt_status.setBackground(Color.darkGray); bt_status.setForeground(Color.white); bt_status.setFont(new Font("Helvetica", Font.PLAIN, 15)); bt_status.setBounds(0, 290, 200, 60); bt_status.setMnemonic('s'); bt_status.setToolTipText("Account Status");
       
       user = new TextField(30); user.setFont(new Font("Helvetica", Font.PLAIN, 16)); user.setBounds(350, 150, 200, 25); user.setBackground(Color.darkGray); user.setForeground(Color.white);
       pass = new JPasswordField(); pass.setFont(new Font("Helvetica", Font.PLAIN, 17)); pass.setBounds(350, 195, 200, 25); pass.setBackground(Color.darkGray);  pass.setForeground(Color.white);
       ok = new JButton("Login"); ok.setBackground(Color.red); ok.setForeground(Color.white); ok.setFont(new Font("Helvetica", Font.PLAIN, 15)); ok.setBounds(350, 250, 100, 30);
       
       usr = new JLabel("Username", JLabel.CENTER); usr.setFont(new Font("Helvetica", Font.BOLD, 16)); usr.setBounds(200, 146, 200, 35); usr.setForeground(Color.cyan); usr.setBackground(Color.darkGray);
       pss = new JLabel("Password", JLabel.CENTER); pss.setFont(new Font("Helvetica", Font.BOLD, 16)); pss.setBounds(200, 191, 200, 35); pss.setBackground(Color.darkGray); pss.setForeground(Color.cyan);
       jl_err = new JLabel("Invalid Username or Password"); jl_err.setFont(new Font("Helvetica", Font.PLAIN, 13)); jl_err.setBounds(350, 225, 230, 20); jl_err.setBackground(Color.black); jl_err.setForeground(Color.red);
       jl_err.setVisible(false);
      
        addbal.setEnabled(false); 	bt_show.setEnabled(false); bt_status.setEnabled(false);
		c.add(login); c.add(create); c.add(addbal); c.add(bt_show); c.add(bt_status); c.add(user); c.add(pass); c.add(usr); c.add(pss); c.add(ok); c.add(jl_err);
	
	   this.setSize(650, 430); this.setResizable(false); this.setVisible(true);  this.setTitle("Bank LogIn Page");
	   
	    ok.addActionListener(this);
	    create.addActionListener(this);
	    addbal.addActionListener(this);
	    bt_show.addActionListener(this);
	    bt_status.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ok) {sq.authentic(this);}
		if(ae.getSource() == create) {new DSCreate(sq); this.dispose();}
		if(ae.getSource() == addbal) {sq.addBalance1(new DSAddbalance(sq)); this.dispose();}
		if(ae.getSource() == bt_show) {sq.showBalance(new DSShow(sq)); this.dispose();}
		if(ae.getSource() == bt_status) {sq.showDetails(new DSStatus(sq)); this.dispose();}
	}
}





















