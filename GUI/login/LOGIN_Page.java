package login;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;

public class LOGIN_Page extends JFrame {
	JButton login, create, show, status, addbal, ok;
	JTextField user, pass;
	JLabel usr, pss;
	
	public LOGIN_Page() {
	   Container c = getContentPane(); c.setBackground(Color.black);
	   c.setLayout(null);

	   login = new JButton("Login"); login.setBackground(Color.darkGray); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(0, 50, 300, 100); login.setMnemonic('l'); login.setToolTipText("LogIn");
	   create = new JButton("Create Account"); create.setBackground(Color.darkGray); create.setForeground(Color.white); create.setFont(new Font("Helvetica", Font.PLAIN, 15)); create.setBounds(0, 150, 300, 100); create.setMnemonic('c'); create.setToolTipText("Create Account");
	   addbal = new JButton("Add Balance"); addbal.setBackground(Color.darkGray); addbal.setForeground(Color.white); addbal.setFont(new Font("Helvetica", Font.PLAIN, 15)); addbal.setBounds(0, 250, 300, 100); addbal.setMnemonic('b'); addbal.setToolTipText("Add Balance");
 	   show = new JButton("Show Balance"); show.setBackground(Color.darkGray); show.setForeground(Color.white); show.setFont(new Font("Helvetica", Font.PLAIN, 15)); show.setBounds(0, 50, 350, 100); show.setMnemonic('s'); show.setToolTipText("Show Balance");
       status = new JButton("Status"); status.setBackground(Color.darkGray); status.setForeground(Color.white); status.setFont(new Font("Helvetica", Font.PLAIN, 15)); status.setBounds(0, 450, 300, 100); status.setMnemonic('t'); status.setToolTipText("Account Status");
       
       user = new JTextField(30); user.setFont(new Font("Helvetica", Font.PLAIN, 15)); user.setBounds(250, 200, 200, 50); user.setBackground(Color.gray); user.setForeground(Color.white);
       pass = new JTextField(30); pass.setFont(new Font("Helvetica", Font.PLAIN, 15)); pass.setBounds(250, 300, 200, 50); pass.setBackground(Color.gray);  user.setBackground(Color.white);
       ok = new JButton("Confirm"); login.setBackground(Color.red); login.setForeground(Color.white); login.setFont(new Font("Helvetica", Font.PLAIN, 15)); login.setBounds(250, 380, 100, 20); ok.setToolTipText("Confirm");
       
       usr = new JLabel("Username", JLabel.CENTER); usr.setFont(new Font("Helvetica", Font.PLAIN, 15)); usr.setBounds(190, 200, 200, 50); usr.setForeground(Color.yellow); usr.setBackground(Color.darkGray);
       pss = new JLabel("Password", JLabel.CENTER); pss.setFont(new Font("Helvetica", Font.PLAIN, 15)); pss.setBounds(190, 300, 200, 50); pss.setBackground(Color.darkGray); pss.setBackground(Color.yellow);
       
       c.add(login); c.add(create); c.add(addbal); c.add(show); c.add(status); c.add(user); c.add(pass); c.add(usr); c.add(pss); c.add(ok);
	
	   this.setSize(800, 800);
	   this.setVisible(true);
	   this.setTitle("Bank LogIn Page");
	}
}
