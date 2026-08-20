# Library Management System 📚

> A desktop-based Java application to manage library book records, student issues, and returns efficiently.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=flat-square&logo=apache-netbeans&logoColor=white)

## 🎥 Project Demo & My Developer Journey

<img width="1280" height="720" alt="LibraryManagmentSystemDemo" src="https://github.com/user-attachments/assets/82e7e8c4-1b4e-4da3-91b4-431bf872901b" />


## 📌 Overview
This project is a Library Management System built using Advanced Java and MySQL. It was developed to streamline the daily operations of a library, replacing manual record-keeping with a fast, database-driven desktop interface. 

*Note: This is one of my foundational projects built during my polytechnic studies to master GUI development, object-oriented programming, and database connectivity.*

## ✨ Core Features
* **Book & Member Management:** Register students and track book inventories.
* **Issue & Return Tracking:** Keep accurate logs of when books are borrowed and returned using automated date pickers.
* **Modernized GUI:** Centered, isolated windows with a system-native look and feel.
* **Database Integration:** Secure and reliable data storage using MySQL and JDBC.

## ⚙️ Local Setup Guide

Follow these steps to run the project on your local machine.

### 1. Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE:** [Apache NetBeans](https://netbeans.apache.org/) (Recommended).
* **Database:** MySQL Server (Local installation or Docker).
* **Required Libraries (Add to NetBeans):** 
  * MySQL JDBC Connector (`mysql-connector-j.jar`)
  * JCalendar (`jcalendar-1.4.jar`)

### 2. Database Setup
This repository includes a `database.sql` file that contains all the required table structures. You can set it up in two ways:

```Note
Database connections are hardcoded, so if you are changing the username and password, you have to manually update the connection values on each page 
```

**Option A: Using Docker & Terminal (Recommended)**
```bash
# 1. Start a MySQL container
docker run --name library-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=library_db -p 3306:3306 -d mysql:latest

# 2. Import the schema (Run this in the same folder as your database.sql file)
docker exec -i library-mysql mysql -uroot -proot library_db < database.sql
```

(Note: If port 3306 is in use, change the port mapping to 3307:3306 and update the Java code accordingly).

**Option B: Using GUI (phpMyAdmin / MySQL Workbench)**

```
Create a new database named library_db in your MySQL server.

Open the database and navigate to the Import tab.

Select the database.sql file from this repository and execute it.

```
### 3. Installation & Running
Clone this repository to your local machine:

```Bash
git clone [https://github.com/PheonixWay/LibraryManagmentUsingAJPinNeatbeans.git](https://github.com/PheonixWay/LibraryManagmentUsingAJPinNeatbeans.git)
Open NetBeans IDE.

Go to File > Open Project and select the cloned folder.

Right-click on the Libraries folder in your NetBeans project tree, select Add JAR/Folder, and add the MySQL JDBC Connector and JCalendar .jar files.

Update the database connection credentials in the source code (search for DriverManager.getConnection) to match your local MySQL setup:

```

```Java
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "root");
Right-click on your main class (Main.java or Login.java) and select Run File.

```

### 📂 Tech Stack
**Frontend/GUI**: _Java Swing_

**Backend Logic**:_Core Java_ / _Advanced Java_

**Database**: _MySQL_

**Tooling**: _NetBeans IDE_
