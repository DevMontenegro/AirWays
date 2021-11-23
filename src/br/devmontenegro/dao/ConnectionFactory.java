/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gustavo Montenegro
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/airways?user=root&password=GTXGuuh12@&serverTimezone=UTC & characterEncoding = UTF-8 & useUnicode = yes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
