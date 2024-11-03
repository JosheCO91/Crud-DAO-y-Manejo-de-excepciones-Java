package com.mycompany.project.dao.exepciones.data;

import com.mycompany.project.dao.exepciones.config.ConexionConfig;
import com.mycompany.project.dao.exepciones.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
  private static final String GET_FUNCIONARIOS = "SELECT * FROM Funcionarios";
  private static final String CREATE_FUNCIONARIO = "INSERT INTO Funcionarios (tipoIdentificacion, numeroIdentificacion, nombres, apellidos, estadoCivil, sexo, direccion, telefono, fechaNacimiento) "
          + "VALUES(?,?,?,?,?,?,?,?,?)";
  private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM Funcionarios WHERE idFuncionario = ?";
  
  private static final String UPDATE_FUNCIONARIO = "UPDATE Funcionarios set tipoIdentificacion = ?, "
          + "numeroIdentificacion = ?, nombres =?, apellidos = ?, estadoCivil = ?, "
          + "sexo = ?, direccion = ?, telefono = ?, fechaNacimiento = ?";
  private static final String DELETE_FUNCIONARIO = "DELETE FROM Funcionarios WHERE idFuncionario = ?";
  
  public List<Funcionario> getFuncionarios() throws SQLException{
      Connection connection = null;
      PreparedStatement preparedstatement = null;
      ResultSet resultset = null;
      
      List<Funcionario> funcionarios = new ArrayList<>();
      
      try {
          connection = ConexionConfig.getConnection();
          preparedstatement = connection.prepareStatement(GET_FUNCIONARIOS);
          resultset = preparedstatement.executeQuery();
      
        while (resultset.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(resultset.getInt("idFuncionario"));
            funcionario.setTipoIdentificacion(resultset.getString("tipoIdentificacion"));
            funcionario.setNumeroIdentificacion(resultset.getString("numeroIdentificacion"));
            funcionario.setNombres(resultset.getString("nombres"));
            funcionario.setApellidos(resultset.getString("apellidos"));
            funcionario.setEstadoCivil(resultset.getString("estadoCivil"));
            funcionario.setSexo(resultset.getString("sexo"));
            funcionario.setDireccion(resultset.getString("direccion"));
            funcionario.setTelefono(resultset.getString("telefono"));
            funcionario.setFechaNacimiento(resultset.getString("fechaNacimiento"));
            funcionarios.add(funcionario);
        }
        return funcionarios;
      } finally {
          if(connection != null){
              connection.close();
          }
          if(preparedstatement != null){
              preparedstatement.close();
          }
          if(resultset != null){
              resultset.close();
          }
      
      }
      
  }
  
  public void createFuncionario(Funcionario funcionario) throws SQLException {
      Connection connection = null;
      PreparedStatement preparedstatement = null;
      
      try{
          connection = ConexionConfig.getConnection();
          preparedstatement = connection.prepareCall(CREATE_FUNCIONARIO);
          preparedstatement.setString(1, funcionario.getTipoIdentificacion());
          preparedstatement.setString(2, funcionario.getNumeroIdentificacion());
          preparedstatement.setString(3, funcionario.getNombres());
          preparedstatement.setString(4, funcionario.getApellidos());
          preparedstatement.setString(5, funcionario.getEstadoCivil());
          preparedstatement.setString(6, funcionario.getSexo());
          preparedstatement.setString(7, funcionario.getDireccion());
          preparedstatement.setString(8, funcionario.getTelefono());
          preparedstatement.setString(9, funcionario.getFechaNacimiento());
          preparedstatement.executeUpdate();
      }finally{
         if(connection != null){
              connection.close();
          }
          if(preparedstatement != null){
              preparedstatement.close();
          }

      }
  }
    public Funcionario getFuncionario(int id)throws SQLException{
      Connection connection = null;
      PreparedStatement preparedstatement = null;
      ResultSet resultset = null;
       Funcionario funcionario = null;
       try{
          connection = ConexionConfig.getConnection();
          preparedstatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
          preparedstatement.setInt(1, id);
          resultset = preparedstatement.executeQuery();
          
          if(resultset.next()){
             funcionario = new Funcionario();
             funcionario.setIdFuncionario(resultset.getInt("idFuncionario"));
             funcionario.setTipoIdentificacion(resultset.getString("tipoIdentificacion"));
             funcionario.setNumeroIdentificacion(resultset.getString("numeroIdentificacion"));
             funcionario.setNombres(resultset.getString("nombres"));
             funcionario.setApellidos(resultset.getString("apellidos"));
             funcionario.setEstadoCivil(resultset.getString("estadoCivil"));
             funcionario.setSexo(resultset.getString("sexo"));
             funcionario.setDireccion(resultset.getString("direccion"));
             funcionario.setTelefono(resultset.getString("telefono"));
             funcionario.setFechaNacimiento(resultset.getString("fechaNacimiento"));
          }
           return funcionario;
       }finally{
             if(connection != null){
              connection.close();
          }
          if(preparedstatement != null){
              preparedstatement.close();
          }
          if(resultset != null){
              resultset.close();
          }
       }
        
    }
    
    public void updateFuncionario(int id, Funcionario funcionario)throws SQLException{
        Connection connection = null;
      PreparedStatement preparedstatement = null;
      
      try{
          connection = ConexionConfig.getConnection();
          preparedstatement = connection.prepareCall(UPDATE_FUNCIONARIO);
          preparedstatement.setString(1, funcionario.getTipoIdentificacion());
          preparedstatement.setString(2, funcionario.getNumeroIdentificacion());
          preparedstatement.setString(3, funcionario.getNombres());
          preparedstatement.setString(4, funcionario.getApellidos());
          preparedstatement.setString(5, funcionario.getEstadoCivil());
          preparedstatement.setString(6, funcionario.getSexo());
          preparedstatement.setString(7, funcionario.getDireccion());
          preparedstatement.setString(8, funcionario.getTelefono());
          preparedstatement.setString(9, funcionario.getFechaNacimiento());
          preparedstatement.setInt(10, id);
          preparedstatement.executeUpdate();
      }finally{
         if(connection != null){
              connection.close();
          }
          if(preparedstatement != null){
              preparedstatement.close();
          }

      }
    }
    public void deleteFuncionario(int id)throws SQLException{
                Connection connection = null;
      PreparedStatement preparedstatement = null;
      
      try{
          connection = ConexionConfig.getConnection();
          preparedstatement = connection.prepareCall(DELETE_FUNCIONARIO);
          preparedstatement.setInt(1, id);
          preparedstatement.executeUpdate();
      }finally{
         if(connection != null){
              connection.close();
          }
          if(preparedstatement != null){
              preparedstatement.close();
          }

      }
    }
}
