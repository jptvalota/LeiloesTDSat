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
                       JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
                } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o produto!" , "Erro", JOptionPane.ERROR_MESSAGE);
    
}
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
           ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    try {
       
        Connection conn = new conectaDAO().connectDB();
        String sql = "SELECT id, nome, valor, status FROM produtos";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getInt("valor"));
            produto.setStatus(rs.getString("status"));

            listagem.add(produto);
        }

        rs.close();
        pstm.close();
        conn.close();

    } catch (Exception e) {
        System.out.println("erro: " + e.getMessage());
          return null;
    }

    return listagem;
    }
     public void venderProduto(int id) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        try {
            PreparedStatement prep = this.conn.prepareStatement(sql);
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            prep.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
        
}

