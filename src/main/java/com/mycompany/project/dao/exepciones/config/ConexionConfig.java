package com.mycompany.project.dao.exepciones.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionConfig {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/funcionarios";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
}
