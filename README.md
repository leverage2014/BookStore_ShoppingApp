# BookStore ShoppingApp by J2EE

## Overview
This application is a web-application with MVC pattern by J2EE (eg. JSP, JDBC and Servlet).

* V: The JSP is used for front-end development;
* M and C: Servlets are used as model and controllers;
* MySQL is used to store the data (such as users' info and order's details).

## Prerequisites

### Git

- A good place to learn about setting up git is [here][git-github]
- Git [home][git-home] (download, documentation)

## Application Directory Layout

````
src/                 --> all of the files to be used in app
   com.bookStoreApp.controller/    --> controllers 
   com.bookStoreApp.domain/        --> mapping tables into Java class
   com.bookStoreApp.service/       --> services
   com.bookStoreApp.emailService/  --> email operation
   com.bookStoreApp.utils/         --> tools operating database
WebContent/
   index.jsp   --> index page
pom.xml        --> maven dependencies
````
    
## Details about the application
### Main features:
#### Front-end:
* User login with verification;
* User information and shopping cart information stored in session;

#### Back-end:
* Data retrieve from and insert into MySQL;
* Send email with Java mail.


## Development with the application
The following docs describe how you can test and develop further this application.


### Importing project

The app is built with Maven in Eclipse. You can import the project in your Eclipse.


### Setting up the MySQL
- Create a database named `shoppingApp`
- Change the configuration in the `db.properties` accordingly

````
url=jdbc:mysql://localhost:3306/shoppingApp
username= ***** // your db user name
password= ***** // your db password
driver=com.mysql.jdbc.Driver
````

- In the database, create three tables `users`, and `orderDetails` and `orderGeneral`
- (1) `users`

````
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(32) | YES  |     | NULL    |                |
| email    | varchar(32) | YES  |     | NULL    |                |
| password | varchar(32) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
````

- (2) `orderDetails `

````
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
| orderId  | varchar(45) | YES  |     | NULL    |                |
| itemName | varchar(45) | YES  |     | NULL    |                |
| itemNum  | int(11)     | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

````

- (3) `orderGeneral `

````
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| orderId    | varchar(45) | NO   | PRI | NULL    |       |
| userId     | int(11)     | NO   |     | NULL    |       |
| totalPrice | double      | YES  |     | NULL    |       |
| orderDate  | datetime    | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
````


### Changing email setting in `EmailSent.java` in `com.bookStoreApp.emailService` package`
- Chang the email setting in the following code:

````
public void sendEmailTo(String toEmail, String sub, String content){
	     
	 // Sender's email ID needs to be mentioned
	 String from = "*****@gmail.com";// Email address the email is from
	 final String username = "*****@gmail.com";// the email account
	 final String password = "*******";// the password
          ......
  }
````
You can invoke the function by following way after create the corresonding object:

````
sendEmailTo([email you sent to], [subject of email], [content in the email]);

````


### Running the app during development

- Open the project in Eclipse
- Right click the `index.jsp` file and choose `Run as -> Run on Server`, the browser will navigate to the index page.


## Contact

For any suggestions and bugs about the project please contact [Me][my-email].


[git-home]: http://git-scm.com
[git-github]: http://help.github.com/set-up-git-redirect
[my-email]: myletter428@gmail.com