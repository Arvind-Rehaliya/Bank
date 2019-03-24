package GUI.login;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Bank.ReserveBank;

public class STATUS_Page extends JFrame implements ActionListener {
	public JButton login, create, show, status, addbal;	
	public JLabel jl_fnm, jl_lnm, jl_gender, jl_age, jl_addrss, jl_pno, jl_cnt, jl_gfnm, jl_glnm, jl_ggender, jl_gage, jl_gpno, jl_gcnt;
	public JTextArea ta_addrss;
    public Container c;
	public ReserveBank rb;
    
	public STATUS_Page(ReserveBank rb) {
	    c = getContentPane();
	    c.setLayout(null); c.setBackground(Color.black); this.rb = rb;
	    
	    login = new JButton("Login"); login.setBackground(Color.darkGray); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 200, 60); login.setMnemonic('l'); login.setToolTipText("LogIn");                                     
		create = new JButton("Create Account"); create.setBackground(Color.darkGray); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 110, 200, 60); create.setMnemonic('c'); create.setToolTipText("Create Account");
		addbal = new JButton("Add Balance"); addbal.setBackground(Color.darkGray); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 170, 200, 60); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
	 	show = new JButton("Show Balance"); show.setBackground(Color.darkGray); show.setForeground(Color.white); show.setFont(new Font("Helvetica", Font.PLAIN, 15)); show.setBounds(0, 230, 200, 60); show.setMnemonic('w'); show.setToolTipText("Show Balance");
	    status = new JButton("Status"); status.setBackground(Color.black); status.setForeground(Color.white); status.setFont(new Font("Helvetica", Font.PLAIN, 15)); status.setBounds(0, 290, 200, 60); status.setMnemonic('s'); status.setToolTipText("Account Status");
	       
	    c.add(login); c.add(create); c.add(addbal); c.add(show); c.add(status);
		
	    
	    jl_fnm = new JLabel("Account Holder Name", JLabel.RIGHT); jl_fnm.setBackground(Color.black); jl_fnm.setForeground(Color.red); jl_fnm.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_fnm.setBounds(200, 100, 200, 30);
	  //  jl_lnm = new JLabel(); jl_lnm.setBackground(Color.black); jl_lnm.setForeground(Color.red); jl_lnm.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_lnm.setBounds(0, 200, 150, 60);
	    jl_gender = new JLabel("Gender", JLabel.RIGHT); jl_gender.setBackground(Color.black); jl_gender.setForeground(Color.red); jl_gender.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_gender.setBounds(200, 150, 200, 30);
	    jl_age = new JLabel("Age", JLabel.RIGHT); jl_age.setBackground(Color.black); jl_age.setForeground(Color.red); jl_age.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_age.setBounds(200, 200, 200, 30);
	    jl_addrss = new JLabel("Address", JLabel.RIGHT); jl_addrss.setBackground(Color.black); jl_addrss.setForeground(Color.red); jl_addrss.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_addrss.setBounds(200, 250, 200, 30);
	    jl_pno = new JLabel("Phone Number", JLabel.RIGHT); jl_pno.setBackground(Color.black); jl_pno.setForeground(Color.red); jl_pno.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_pno.setBounds(200, 370, 200, 30);
	    jl_cnt = new JLabel("Country", JLabel.RIGHT); jl_cnt.setBackground(Color.black); jl_cnt.setForeground(Color.red); jl_cnt.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_cnt.setBounds(300, 420, 100, 30);
		
	    jl_gfnm = new JLabel("fsfsdf"); jl_gfnm.setBackground(Color.black); jl_gfnm.setForeground(Color.white); jl_gfnm.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_gfnm.setBounds(420, 100, 100, 30);
	    jl_glnm = new JLabel("fsfsdf"); jl_glnm.setBackground(Color.black); jl_glnm.setForeground(Color.white); jl_glnm.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_glnm.setBounds(530, 100, 100, 30);
	    jl_ggender = new JLabel("fsfsdf"); jl_ggender.setBackground(Color.black); jl_ggender.setForeground(Color.white); jl_ggender.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_ggender.setBounds(420, 150, 150, 30);
	    jl_gage = new JLabel("fsfsdf"); jl_gage.setBackground(Color.black); jl_gage.setForeground(Color.white); jl_gage.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_gage.setBounds(420, 200, 150, 30);
	    jl_gpno = new JLabel("fsfsdf"); jl_gpno.setBackground(Color.black); jl_gpno.setForeground(Color.white); jl_gpno.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_gpno.setBounds(420, 370, 100, 30);
	    jl_gcnt = new JLabel("fsfsdf"); jl_gcnt.setBackground(Color.black); jl_gcnt.setForeground(Color.white); jl_gcnt.setFont(new Font("Helvetica", Font.PLAIN, 15)); jl_gcnt.setBounds(420, 420, 250, 30);


	    ta_addrss = new JTextArea(10, 20); ta_addrss.setBackground(Color.black); ta_addrss.setForeground(Color.white); ta_addrss.setFont(new Font("Helvetica", Font.PLAIN, 15)); ta_addrss.setBounds(420, 250, 220, 100); ta_addrss.setEditable(false); ta_addrss.setLineWrap(true); ta_addrss.setBorder(BorderFactory.createEtchedBorder(5, Color.cyan, Color.yellow));
	    c.add(jl_fnm); c.add(jl_gender); c.add(jl_age); c.add(jl_addrss); c.add(jl_pno); c.add(jl_cnt); c.add(jl_gfnm); c.add(jl_glnm); c.add(jl_ggender); c.add(jl_gage); c.add(ta_addrss); c.add(jl_gpno); c.add(jl_gcnt);
	
	    this.setSize(660, 530);	this.setVisible(true); this.setResizable(false); this.setTitle("User Status");
	    
	    login.addActionListener(this);
	    create.addActionListener(this);
	    addbal.addActionListener(this);
	    show.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {LOGIN_Page login = new LOGIN_Page(rb); this.dispose();}
		if(ae.getSource() == create) {CREATE_Page create = new CREATE_Page(rb); this.dispose();}
		if(ae.getSource() == addbal) {ADDBALANCE_Page bal = new ADDBALANCE_Page(rb); rb.addBalance1(rb, bal); this.dispose();}
		if(ae.getSource() == show) {SHOW_Page show = new SHOW_Page(rb);  rb.showBalance(rb, show);	 this.dispose();}
	}
}
