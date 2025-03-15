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
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
         String sql = "INSERT INTO produtos(nome, valor) VALUES "
                    + "(?, ?, ?)";
                try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    stmt.setString(1, produto.getNome());
                     stmt.setInt(2, produto.getValor());
                     
                       stmt.execute();
            
                } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto!" , "Erro", JOptionPane.ERROR_MESSAGE);
    
}
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

