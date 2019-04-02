/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IProdutoVendaRepo;
import Model.Bean.Produto;
import Model.Bean.ProdutoVenda;
import Model.Bean.Venda;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wilgn
 */
public class ProdutoVendaDAO implements IProdutoVendaRepo {

    Connection con;

    @Override
    public boolean create(ProdutoVenda pv) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO VENDAPRODUTO"
                    + "(IDPROD, IDVENDA, QTD, PRECOVD )"
                    + "VALUES (?,?,?,?)");
            List<Produto> produtos = pv.getP();
            Venda v = pv.getV();

            for (int i = 0; i < produtos.size(); i++) {
                Produto get = produtos.get(i);
                
                stmt.setInt(1, get.getIdprod());
                stmt.setInt(2, v.getIdVenda());
                stmt.setInt(3, get.getQtd());
                stmt.setDouble(4, get.getPreco());

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
