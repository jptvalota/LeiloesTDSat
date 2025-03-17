/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

import java.util.ArrayList;


public class ProdutosDAO {
    
     private conectaDAO conexao;
                private Connection conn; 
                 ArrayList<ProdutosDTO> listagem = new ArrayList<>();
                 
                public ProdutosDAO() {
                this.conexao = new conectaDAO();
                this.conn = this.conexao.connectDB();
            }
  
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
         String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                    + "(?, ?, ?)";
                try {
                    PreparedStatement prep = this.conn.prepareStatement(sql);
                    prep.setString(1, produto.getNome());
                     prep.setInt(2, produto.getValor());
                     prep.setString(3, produto.getStatus());
                     
                       prep.execute();
            
                } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto!" , "Erro", JOptionPane.ERROR_MESSAGE);
    
}
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

