/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.services;

import br.devmontenegro.entity.User;
import br.devmontenegro.exceptions.ExceptionUser;
import br.devmontenegro.interfaces.services.IUserServico;
import br.devmontenegro.repository.UserRepositorio;

/**
 *
 * @author Gustavo Montenegro
 */
public class UserServico implements IUserServico{
    
    UserRepositorio ur = new UserRepositorio();

    @Override
    public void cadastrarUsuario(User u) throws ExceptionUser {
        ur.adicionarUser(u);
    }

    @Override
    public void editarUsuario(User u) throws ExceptionUser {
        ur.editarUser(u);
    }
    
}
