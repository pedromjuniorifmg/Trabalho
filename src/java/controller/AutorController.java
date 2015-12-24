/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelo.Autor;
import dao.AutorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lsiqueira
 */
public class AutorController {
    
    public static void salvar(String nome){
        Autor a = new Autor(nome);
        new AutorDAO().salvar(a);
    }
    
    public static void editar(String id, String nome){
        Autor a = new Autor(Integer.parseInt(id), nome);
        new AutorDAO().alterar(a);
    }
    
    public static void excluir(String id){
        new AutorDAO().excluir(Integer.parseInt(id));
    }
    
  /* public static ModeloTabela listaAutors() {
        AutorDAO dao = new AutorDAO();
        List list = new ArrayList();
        String[] colunas = {"Id", "Nome", "Email", "Telefone", "Status"};
        try {
            list = dao.findAll();      
            ModeloTabela modelo = new ModeloTabela((ArrayList)list, colunas);
            
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar cliente" + e.getLocalizedMessage());
        } catch (Exception ex) {
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
   
   public static boolean procuraAutorId(String id){
      AutorDAO dao = new AutorDAO();
      if(dao.findById(Integer.parseInt(id)) != null)
          return true;
      return false;
      
   }
   /* public static ModeloTabela listaPorNome(String nome) {
        AutorDAO dao = new AutorDAO();
        List list = new ArrayList();
        String[] colunas = {"Id", "Nome", "Email", "Telefone", "Status"};
        try {
            list = dao.listaAutorsPorNome(nome);      
            ModeloTabela modelo = new ModeloTabela((ArrayList)list, colunas);
            
            return modelo;
        } catch (Exception ex) {
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean verificaAtivo(String id){
        AutorDAO clientedao = new AutorDAO();
        Autor cliente = new Autor();
        
        cliente = clientedao.findById(Integer.parseInt(id));
        if (cliente.getStatus().equals("Ativo"))
                return true;
        else
                return false;
    }*/
}
