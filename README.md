# Bank
This is a project on Bank which specifies some features of any bank such as Create Account, Log in, Add Balance, Show Balance, Show Status .

Many more interesting features will add soon such as (send/receive payment using Networking concept of Java and adjust appearance of this project and many many more :)

This project basically uses MySQL Database for permanent storage of Account Holder Details(Such as First Name, Last Name, Gender, Country, Username, Password, age etc ..) 
But if there is no MySQL database on your PC then, It automatically redirect it to Data Structure version of Bank which is also in this project and user details will store as soon as you didn't close this project(Not Permanent).

If you have MySQL installed, then ---

*Commands enclosed in Square Brackets are SQL Commands*

1. open your DataBase console, and set username as root(which is default username) and password = blank(which is default password, press enter only) then ---
2. Create database named bank in your DataBase console, as [Create database bank;]
3. Now, Create table named user_database, as [Create table user_database(First_Name char(30), Last_Name char(30), Gender char(6), Age int, Phone_Number long, Address char(40), Country char(20),       Username char(20), Password char(20), Balance float, Account_No int );]
4. Now, Confirm your table [user_database] is created or not, as [desc user_database;]
5. Now download MySQL Java Connector which is .jar file(mysql-connector-java-8.0.15.jar) and go to java folder in your computer and store it in Java -> jre -> lib -> ext directory.
6. Correct! Now you are ready to use this project in DataBase mode.

# To Run this project
go to --                                                                          
bank -> src -> Bank -> Customer.java and Compile this .

There can be bug(s) in this project, Feel Free to publish your issues to be fixed later .
