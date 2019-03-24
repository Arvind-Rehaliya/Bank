package BankGUIWork;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;

public class BankGUI_LOGIN extends JFrame {
	JButton login, create, show, status, addbal;
	
	Container c = getContentPane();
	c.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

	login = new JButton("Login");
	create = new JButton("Create Account");
	addbal = new JButton("Add Balance");
	show = new JButton("Show Balance");
    status = new JButton("Status");
	
}
