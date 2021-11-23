/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.services;

import br.devmontenegro.entity.Clientes;
import br.devmontenegro.exceptions.ExceptionCliente;
import br.devmontenegro.interfaces.services.IClienteServico;
import br.devmontenegro.repository.ClienteRepositorio;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Montenegro
 */
public class ClienteServico implements IClienteServico {

    ClienteRepositorio cr = new ClienteRepositorio();

    @Override
    public void cadastrarCliente(Clientes c) throws ExceptionCliente {
        try {
            if ("".equals(c.getNome()) || "".equals(c.getRg()) || "".equals(c.getEndereco()) || "".equals(c.getCidade()) || "".equals(c.getBairro()) || "".equals(c.getNumero())) {
                throw new ExceptionCliente("AS INFORMAÇÕES NÃO PODEM ESTAR EM BRANCO AO SALVAR UM CLIENTE!");
            }
            cr.adicionarCliente(c);
        } catch (ExceptionCliente e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void alterarCliente(Clientes c) throws ExceptionCliente {
        try {
            if ("".equals(c.getNome()) || "".equals(c.getRg()) || "".equals(c.getEndereco()) || "".equals(c.getCidade()) || "".equals(c.getBairro()) || "".equals(c.getNumero())) {
                throw new ExceptionCliente("AS INFORMAÇÕES NÃO PODEM ESTAR EM BRANCO AO EDITAR UM CLIENTE!");
            }
            cr.alterarCliente(c);
        } catch (ExceptionCliente e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void removerCliente(Clientes c) throws ExceptionCliente {
        try {
            cr.removerCliente(c);
        } catch (Exception e) {
        }
    }

    @Override
    public void listarClientePorCodigo(Clientes c) throws ExceptionCliente {

    }

}
