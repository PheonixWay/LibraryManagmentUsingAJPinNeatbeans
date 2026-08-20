# Library Management System 📚

> A desktop-based Java application to manage library book records, student issues, and returns efficiently.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=flat-square&logo=apache-netbeans&logoColor=white)

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
