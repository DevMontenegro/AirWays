/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.interfaces.services;

import br.devmontenegro.entity.Clientes;
import br.devmontenegro.exceptions.ExceptionCliente;

/**
 *
 * @author Gustavo Montenegro
 */
public interface IClienteServico {

	public void cadastrarCliente (Clientes c) throws ExceptionCliente;
	public void alterarCliente (Clientes c) throws ExceptionCliente;
	public void removerCliente (Clientes c) throws ExceptionCliente;
	public void listarClientePorCodigo (Clientes c) throws ExceptionCliente;

}
