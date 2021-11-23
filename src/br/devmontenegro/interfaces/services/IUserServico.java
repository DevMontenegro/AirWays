/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.devmontenegro.interfaces.services;

import br.devmontenegro.entity.User;
import br.devmontenegro.exceptions.ExceptionUser;

/**
 *
 * @author Gustavo Montenegro
 */
public interface IUserServico {

        public void cadastrarUsuario(User u) throws ExceptionUser;
        public void editarUsuario(User u) throws ExceptionUser;
    }