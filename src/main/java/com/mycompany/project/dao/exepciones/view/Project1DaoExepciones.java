
package com.mycompany.project.dao.exepciones.view;

import com.mycompany.project.dao.exepciones.controller.FuncionarioController;
import com.mycompany.project.dao.exepciones.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class Project1DaoExepciones {
    public static void createOneFun (FuncionarioController funcionarioController){ 
        try {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite el tipo de documento");
        String tipoDocumen = sc.nextLine();
        System.out.println("Tipo de documento" + tipoDocumen);
        System.out.println("---------------------------------");
        
        System.out.println("Digite el número de identificación:");
        String numeroIdentificacion = sc.nextLine();
        System.out.println("Número de identificación: " + numeroIdentificacion);
        System.out.println("---------------------------------");

        System.out.println("Digite los nombres:");
        String nombres = sc.nextLine();
        System.out.println("Nombres: " + nombres);
        System.out.println("---------------------------------");

        System.out.println("Digite los apellidos:");
        String apellidos = sc.nextLine();
        System.out.println("Apellidos: " + apellidos);
        System.out.println("---------------------------------");

        System.out.println("Digite el estado civil:");
        String estadoCivil = sc.nextLine();
        System.out.println("Estado civil: " + estadoCivil);
        System.out.println("---------------------------------");

        System.out.println("Digite el sexo:");
        String sexo = sc.nextLine();
        System.out.println("Sexo: " + sexo);
        System.out.println("---------------------------------");

        System.out.println("Digite la dirección:");
        String direccion = sc.nextLine();
        System.out.println("Dirección: " + direccion);
        System.out.println("---------------------------------");

        System.out.println("Digite el teléfono:");
        String telefono = sc.nextLine();
        System.out.println("Teléfono: " + telefono);
        System.out.println("---------------------------------");

        System.out.println("Digite la fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = sc.nextLine();
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("---------------------------------");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setTipoIdentificacion(tipoDocumen);
        funcionario.setNumeroIdentificacion(numeroIdentificacion);
        funcionario.setNombres(nombres);
        funcionario.setApellidos(apellidos);
        funcionario.setEstadoCivil(estadoCivil);
        funcionario.setSexo(sexo);
        funcionario.setDireccion(direccion);
        funcionario.setTelefono(telefono);
        funcionario.setFechaNacimiento(fechaNacimiento);
        funcionarioController.createFun(funcionario);
        System.out.println("CREADO CON EXITO");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void getTodFunc (FuncionarioController funcionarioController){
        try {
            List<Funcionario> funcionarios = funcionarioController.getListFun();
            if(funcionarios.isEmpty()){
              System.out.println("No hay elementos");  
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("ID = " + funcionario.getIdFuncionario());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Tipo de Identificación = " + funcionario.getTipoIdentificacion());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Número de Identificación = " + funcionario.getNumeroIdentificacion());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Nombres = " + funcionario.getNombres());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Apellidos = " + funcionario.getApellidos());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Estado Civil = " + funcionario.getEstadoCivil());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Sexo = " + funcionario.getSexo());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Dirección = " + funcionario.getDireccion());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Teléfono = " + funcionario.getTelefono());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Fecha de Nacimiento = " + funcionario.getFechaNacimiento());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        //createOneFun(funcionarioController);
        getTodFunc(funcionarioController);
    }
}
