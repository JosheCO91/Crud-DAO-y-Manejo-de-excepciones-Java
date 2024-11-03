package com.mycompany.project.dao.exepciones.controller;

import com.mycompany.project.dao.exepciones.data.FuncionarioDao;
import com.mycompany.project.dao.exepciones.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioDao funDao;
    
    public FuncionarioController(){
        funDao = new FuncionarioDao();
    }
    public List<Funcionario> getListFun() throws SQLException {
        return funDao.getFuncionarios();
    }
    public void createFun(Funcionario funcionario)throws SQLException {
        funDao.createFuncionario(funcionario);
    }
    
    public Funcionario getByIdFun(int id)  throws SQLException {
        return funDao.getFuncionario(id);
    }
    public void updateFunc(int id, Funcionario funcionario)  throws SQLException {
        funDao.updateFuncionario(id, funcionario);
    }  
    public void deleteFunc(int id)  throws SQLException {
        funDao.deleteFuncionario(id);
    } 
}
