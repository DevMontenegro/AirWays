/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.repository;

import br.devmontenegro.dao.ConnectionFactory;
import br.devmontenegro.entity.Clientes;
import br.devmontenegro.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Montenegro
 */
public class UserRepositorio {

    private Connection con;

    public UserRepositorio() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void adicionarUser(User u) {
        try {
            String sql = "insert into user (nome, nick, senha, nivelDeAcesso) values (?, ?, ?, ?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, u.getNome());
            stm.setString(2, u.getNick());
            stm.setString(3, u.getSenha());
            stm.setString(4, u.getNivelDeAcesso());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Funcionário operador cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário operador!");
        }
    }

    public void editarUser(User u) {
        try {
            String sql = "update user set nome =?, nick=?, senha=?, nivelDeAcesso=? where id=?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, u.getNome());
            stm.setString(2, u.getNick());
            stm.setString(3, u.getSenha());
            stm.setString(4, u.getNivelDeAcesso());
            stm.setInt(5, u.getId());

            JOptionPane.showMessageDialog(null, "Funcionário operador alterado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar funcionário operador!");
        }
    }

    public List<User> listarUser() {
        try {
            List<User> lista = new ArrayList<>();

            String sql = "select * from user";

            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                User u = new User();

                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setNick(rs.getString("nick"));
                u.setSenha(rs.getString("senha"));
                u.setNivelDeAcesso("nivelDeAcesso");

                lista.add(u);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar operador! " + e);
            return null;
        }
    }

    public boolean checkLogin(String nick, String senha) {

        boolean check = false;
        try {

            String sql = "select * from user WHERE nick=? and senha= ?";

            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, nick);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                check = true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao caregar usuario :" + "  " + e);

        }
        return check;

    }

}
