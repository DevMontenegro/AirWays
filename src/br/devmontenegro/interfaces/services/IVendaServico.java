/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.interfaces.services;

import br.devmontenegro.entity.Vendas;
import br.devmontenegro.exceptions.ExceptionVendas;

/**
 *
 * @author Gustavo Montenegro
 */
public interface IVendaServico {

    public interface IProdutoServico {

        public void cadastrarVenda(Vendas v) throws ExceptionVendas;

    }
}
