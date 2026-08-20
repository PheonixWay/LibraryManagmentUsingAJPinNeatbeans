/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  danish-ansari
 * Created: Aug 20, 2026
 */

CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    catname VARCHAR(255),
    status VARCHAR(50)
);

CREATE TABLE author (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address TEXT,
    phone VARCHAR(50)
);

CREATE TABLE publisher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address TEXT,
    phone VARCHAR(50)
);

CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bname VARCHAR(255),
    category INT,
    author INT,
    publisher INT,
    contents TEXT,
    pages INT,
    edition VARCHAR(50)
);

CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address TEXT,
    phone VARCHAR(50)
);

CREATE TABLE issuebook (
    id INT AUTO_INCREMENT PRIMARY KEY,
    memberid INT,
    bookid INT,
    issuedate DATE,
    returndate DATE
);

CREATE TABLE returnbook (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mid INT,
    mname VARCHAR(255),
    bname VARCHAR(255),
    returndate DATE,
    elp INT,
    fine INT
);