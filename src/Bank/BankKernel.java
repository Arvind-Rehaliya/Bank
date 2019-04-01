package Bank;

import GUI.login.LOGIN_Page;
import GUI.DS.DSLogin;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class BankKernel {
	private Connection con;
	private Statement st;
	
	public BankKernel() {
		/* If Exception not occurs then SQL mode is selected
		 * and ReserveBank class is created 
		 * and as homePage of bank always LOGIN_Page will open.
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
		      st = con.createStatement();
			  ReserveBank rb = new ReserveBank(st); new LOGIN_Page(rb);
		} catch(Exception e) {
			/* If Exception occurs then DS mode is selected
			 * and WhenSQLExceptionOccurs() class is created 
			 * and as homePage of bank always DSLogin will open.
			 */
			    System.out.println(e);
			    System.out.print("\n\nMySQLExceptionOccurs! But, Don't Worry\nIt is also handled by me ....\n");
				System.out.println("\nThis info is only for debug purpose only that can be eleminate by me But ..\n");
				WhenSQLExceptionOccurs sq = new WhenSQLExceptionOccurs();
			    new DSLogin(sq);
		  }
		
	}

}
