/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.repository;

import br.devmontenegro.dao.ConnectionFactory;
import br.devmontenegro.entity.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Montenegro
 */
public class ClienteRepositorio {

    private Connection con;

    public ClienteRepositorio() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Clientes> buscarClientePorNome(String nome) {
        try {
            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from clientes where nome like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setEndereco(rs.getString("endereco"));
                c.setCep(rs.getString("cep"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                
                lista.add(c);
            }
            return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no método listar do repositório do cliente! "+e);
            return null;
        }
    }
    
        public Clientes buscarClientePorCpf(String cpf) {
        try {

            String sql = "select * from clientes where cpf = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            Clientes c = new Clientes();
            
            
            if (rs.next()) {
         
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setEndereco(rs.getString("endereco"));
                c.setCep(rs.getString("cep"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));

            }
            return c;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado! "+e);
            return null;
        }
    }

    public void adicionarCliente(Clientes c) {
        try {
            String sql = "insert into clientes (nome, rg, cpf, endereco, cep, cidade, uf, numero, bairro) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.getNome());
            stm.setString(2, c.getRg());
            stm.setString(3, c.getCpf());
            stm.setString(4, c.getEndereco());
            stm.setString(5, c.getCep());
            stm.setString(6, c.getCidade());
            stm.setString(7, c.getUf());
            stm.setString(8, c.getNumero());
            stm.setString(9, c.getBairro());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente! " + e);
        }
    }

    public void alterarCliente(Clientes c) {
        try {
            String sql = "update clientes set nome = ?, rg =?, cpf=?, endereco=?, cep=?, cidade=?, uf=?, numero=?, bairro=? where id =?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, c.getNome());
            stm.setString(2, c.getRg());
            stm.setString(3, c.getCpf());
            stm.setString(4, c.getEndereco());
            stm.setString(5, c.getCep());
            stm.setString(6, c.getCidade());
            stm.setString(7, c.getUf());
            stm.setString(8, c.getNumero());
            stm.setString(9, c.getBairro());
            stm.setInt(10, c.getId());

            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente! " + e);
        }
    }

    public void removerCliente(Clientes c) {

        try {
            String sql = "delete from clientes where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, c.getId());

            stm.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente" + e);
        }

    }

    public List<Clientes> listarClientes() {

        try {
            List<Clientes> lista = new ArrayList<>();

            String sql = "select * from clientes";

            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setEndereco(rs.getString("endereco"));
                c.setCep(rs.getString("cep"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));

                lista.add(c);
            }

            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cliente! " + e);
            return null;
        }
    }

}
