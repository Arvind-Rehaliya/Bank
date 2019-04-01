#Bank

 In this section there are two Packages Bank and GUI.

#In Bank package
  There are many *.java files in which logic of this whole Project that is
  Where the User's data will store, How will data flow all over the different Frames(will discuss later) used in this project and many more .
  
  1. Customer.java -- main file or entry point to enter in the bank, used to run this project. 
  
  2. BankKernel.java -- This file actually decide which version of this bank, the user will redirect that is --
   
     a. Data Structure Mode or 
   
     b. MySQL Mode. 
     
   Data Sturc. mode is selected when SQLException occurs else MySQL mode is selected. If MySQL is installed + a database is created named bank + table is created which is described earlier(in root directory of this project there is another README.md file).  
  3. ReserveBank.java -- The logic in this file is used when bank successfully access your MySQL database, Which is already started by you before going to bank with username = root and password = (blank or press enter key) and store user's data in database. 

  4. WhenSQLExceptionOccurs.java -- As name specifies, This file is used when SQLException raises and reason you know that is --
     a. You didn't install DB.
     b. You didn't created database named bank and 
     c. Table as described earlier.
     d. You are not login with username = root and password =  (blank).
     e. After this if any type of Exception raise then, feel free to publish your issue(s).
     And User's data will store in memory(not permanent).
  
  5. BankProcedure.java -- This is Interface in which all the procedure of any bank is mentioned(unimplemented). Notice ; at the end of methods. In this project this class can be eliminated.
   
  6. BankAdapter.java -- This class implements all the methods of BankProcedure.java(which is interface) with curly brackets(blank implementation) which is used when we want to implement only few of methods(not all) and rest have blank implementation(only pair of curly bracket). So, Instead of implementing all the methods of BankProcedure(interface) we use such adapter class which is nothing but contains blank implementation of all the methods of interface and this class will become parent class for that class(s) which uses some of the methods of interface not all and rest methods have blank implementation in parent class(BankAdapter.java). For example : See ReserveBank.java, This file also can be eliminated :)
  
  7. MyBankException.java --- This class extends Exception class to be use as my own Exception class as there is no any Exception to fullfill my requirement.
  MyBankException is throw (not throws) explicitly (in certain condition(s)).
  For Example: when both TextFields are empty a message displays "Fill both Text Fields" which is written in catch block. as ----
    try {
      if(both TextFields contains null or blank)  throw new MyBankException();
      // else block can be use here instead of try catch block here
    } catch(MyBankException mb) {
          "Fill both text"
    }
    This class also can be eliminated.

    *Many of the classes can be eliminated, To understand the concept of JAVA I  used such classes in this project. Such as, Interface, adapter class, custom Exception class are used. But This not means that these classes are useless. They are also used to run this project/*

#GUI

 In GUI directory/folder or package(in java). There are two another packages --
 a. DS
 b. login

# IN DS
 
 Files in this directory is used when User is in Data Structure mode. There are five *.java files.

 1. DSAddbalance.java -- is called when you add balance in authenticated user account.
 2. DSLogin.java -- is called when you see login window, which asks for username and password. To login to user's account.

 3. DSCreate.java -- is called when you pressed create account button.

 4. DSShow.java -- is called when you want to show current user's available balance.

 5. DSStatus.java -- is called when you press status button, to see authenticated user's details. Such as Name, address, Phone No., Gender etc..

# IN login

  Files in this directory is used when User is in MySQL Mode. There are also five .java files which is called accordingly which is discussed above. Look at file name and you will get idea of importance of that class in bank :)
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
