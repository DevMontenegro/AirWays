/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Montenegro
 */
public class Teste {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Deu certo, irraaa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deu errado >:( ");
        }
    }
}
