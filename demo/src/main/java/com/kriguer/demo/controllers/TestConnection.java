package com.kriguer.demo.controllers;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/product";
        String user = "root";
        String pass = "1234";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Conexão bem-sucedida!");
        }
    }
}