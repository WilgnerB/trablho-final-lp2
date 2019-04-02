/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IProdutoRepo;
import Model.Bean.Marca;
import Model.Bean.Produto;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO implements IProdutoRepo {

    Connection con;

    @Override
    public boolean create(Produto p) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PRODUTO(NOME,QTD,PRECO,DATAENT,STATUS,IDMARCA) "
                    + "VALUES (?,?,?,CURRENT_DATE,'A',?)");
            
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4,p.getMarca().getIdmarca());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    @Override
    public List<Produto> read() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT IDPROD ,P.NOME,QTD,PRECO,DATAENT,M.IDMARCA,M.NOME\n"
                    + "FROM PRODUTO P,MARCA M\n"
                    + "WHERE P.IDMARCA=M.IDMARCA\n"
                    + "AND P.STATUS = 'A';");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca m = Marca.newinstance(rs.getString("MARCA.NOME"));
                m.setIdmarca(rs.getInt("MARCA.IDMARCA"));
                Produto produto = Produto.newinstance(rs.getInt("idprod"), rs.getString("Produto.NOME"), rs.getInt("qtd"), rs.getDouble("preco"), m);
                produto.setDataEnt(rs.getDate("DATAENT"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    @Override
    public List<Produto> readForDesc(String desc) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT IDPROD ,P.NOME,QTD,PRECO,DATAENT,M.IDMARCA,M.NOME\n"
                    + "FROM PRODUTO P,MARCA M\n"
                    + "WHERE P.NOME LIKE ? AND P.IDMARCA=M.IDMARCA\n"
                    + "AND P.STATUS = 'A';");
            
                        stmt.setString(1, "%" + desc + "%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Marca m = Marca.newinstance(rs.getString("MARCA.NOME"));
                m.setIdmarca(rs.getInt("MARCA.IDMARCA"));
                Produto produto = Produto.newinstance(rs.getInt("idprod"), rs.getString("Produto.NOME"), rs.getInt("qtd"), rs.getDouble("preco"), m);
                produto.setDataEnt(rs.getDate("DATAENT"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    @Override
    public boolean update(Produto p) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET PRODUTO.NOME = ? ,QTD = ?,PRECO = ?,IDMARCA=? WHERE IDPROD = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getMarca().getIdmarca());
            stmt.setInt(5, p.getIdprod());

            stmt.executeUpdate();

            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    @Override
    public boolean delete(Produto p) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET STATUS='D' WHERE IDPROD = ?");
            stmt.setInt(1, p.getIdprod());

            stmt.executeUpdate();
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    @Override
    public boolean update(List<Produto> p) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            for (int i = 0; i < p.size(); i++) {
                Produto get = p.get(i);
                stmt = con.prepareStatement("UPDATE PRODUTO SET qtd = ? WHERE IDPROD = ?");

                stmt.setInt(1, get.getQtd());
                stmt.setInt(2, get.getIdprod());

                stmt.executeUpdate();
                stmt.clearParameters();
            }
            ConnectionFactory.closeConnection(con, stmt);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

}
