/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.repository;

import br.devmontenegro.dao.ConnectionFactory;
import br.devmontenegro.entity.Vendas;
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
public class VendaRepositorio {

    private Connection con;

    public VendaRepositorio() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void adicionarVenda(Vendas v) {
        try {
            String sql = "insert into vendas (cliente_id, data_venda, total_venda, obs, local_inicio, local_final, qtd) values (?, ?, ?, ?, ?, ?,?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, v.getCliente().getId());
            stm.setString(2, v.getData_venda());
            stm.setDouble(3, v.getTotal_venda());
            stm.setString(4, v.getObs());
            stm.setString(5, v.getLocal_inicio());
            stm.setString(6, v.getLocal_final());
            stm.setInt(7, v.getQtd());
            

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda! " + e);
        }
    }

    public void alterarVenda(Vendas v) {
        try {
            String sql = "update vendas set cliente_id=?, data_venda=?, total_venda, obs=?, local_inicio=?, local_final=?, qtd=? where id =?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, v.getCliente().getId());
            stm.setString(2, v.getData_venda());
            stm.setDouble(3, v.getTotal_venda());
            stm.setString(4, v.getObs());
            stm.setString(5, v.getLocal_inicio());
            stm.setString(6, v.getLocal_final());
            stm.setInt(7, v.getQtd());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda! " + e);
        }
    }

    public void removerVenda(Vendas v) {

        try {
            String sql = "delete from vendas where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, v.getId());

            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar venda" + e);
        }
    }

    public List<Vendas> listarVendas() {

        try {
            List<Vendas> lista = new ArrayList<>();

            String sql = "select * from vendas";

            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Vendas v = new Vendas();

                v.setId(rs.getInt("id"));
                v.getCliente().setId(rs.getInt("cliente_id"));
                v.setData_venda(rs.getString("data_venda"));
                v.setTotal_venda(rs.getDouble("total_venda"));
                v.setObs(rs.getString("obs"));
                v.setLocal_inicio(rs.getString("local_inicio"));
                v.setLocal_final(rs.getString("local_final"));
                v.setQtd(rs.getInt("qtd"));

                lista.add(v);
            }

            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar venda! " + e);
            return null;
        }
    }

}
