/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IVendaRepo;
import Model.Bean.Cliente;
import Model.Bean.Funcionario;
import Model.Bean.Venda;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilgn
 */
public class VendaDAO implements IVendaRepo {

    Connection con;

    @Override
    public boolean create(Venda v) {
        con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            Cliente c = v.getC();
            Funcionario f = v.getF();

            stmt = con.prepareStatement("INSERT INTO \"VENDA\"\n"
                    + "(\"IDFUNC\", \"IDCLIENTE\", \"DTVENDA\" )\n"
                    + "VALUES (?,?,CURRENT_DATE)");
            stmt.setInt(1, f.getIdfunc());
            stmt.setInt(2, c.getIdcliente());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    @Override
    public Venda getVenda() {
        con = ConnectionFactory.getConnection();
        Venda v = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int maxId = 0;

        try {
            stmt = con.prepareStatement("SELECT MAX(idvenda) as maxId FROM VENDA");
            rs = stmt.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("maxId");
            }
            v = Venda.NewInstance(maxId);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return v;
    }

    @Override
    public List<Venda> read() {
        con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> Vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT \n"
                    + "    V.IDVenda, NMFunc, NMCliente, DtVenda,  SUM(QTD * PRECOVD)  AS TOTAL\n"
                    + "FROM\n"
                    + "    VendaProduto VP,\n"
                    + "    Venda V,\n"
                    + "    Funcionario F,\n"
                    + "    Cliente C\n"
                    + "WHERE\n"
                    + "    V.IDvenda = Vp.IdVenda\n"
                    + "        AND V.IDFunc = F.IdFunc\n"
                    + "        AND V.IdCliente = C.IdCliente\n"
                    + "GROUP BY V.IDVenda, NMFunc, NMCliente, DtVenda\n"
                    + "ORDER BY V.IDVENDA;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("NMCLIENTE"));
                Funcionario f = new Funcionario(rs.getString("NMFUNC"));
                Venda v = Venda.NewInstance(c, f);
                v.setIdVenda(rs.getInt("IDVENDA"));
                v.setDtVendaBD(rs.getDate("DTVENDA"));
                v.setTotal(rs.getDouble("TOTAL"));

                Vendas.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Vendas;

    }

    @Override
    public List<Venda> readForNMAT(String Nm) {
        con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> Vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT \n"
                    + "    V.IDVenda, NMFunc, NMCliente, DtVenda,  SUM(QTD * PRECOVD)  AS TOTAL\n"
                    + "FROM\n"
                    + "    VendaProduto VP,\n"
                    + "    Venda V,\n"
                    + "    Funcionario F,\n"
                    + "    Cliente C\n"
                    + "WHERE\n"
                    + "    V.IDvenda = Vp.IdVenda\n"
                    + "        AND V.IDFunc = F.IdFunc\n"
                    + "        AND V.IdCliente = C.IdCliente\n"
                    + "        AND NMFUNC LIKE ?\n"
                    + "GROUP BY V.IDVenda, NMFunc, NMCliente, DtVenda;");
            stmt.setString(1, "%" + Nm + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("NMCLIENTE"));
                Funcionario f = new Funcionario(rs.getString("NMFUNC"));
                Venda v = Venda.NewInstance(c, f);
                v.setIdVenda(rs.getInt("IDVENDA"));
                v.setDtVendaBD(rs.getDate("DTVENDA"));
                v.setTotal(rs.getDouble("TOTAL"));

                Vendas.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Vendas;

    }

    @Override
    public List<Venda> readForNMCL(String Nm) {
        con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> Vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT \n"
                    + "    V.IDVenda, NMFunc, NMCliente, DtVenda,  SUM(QTD * PRECOVD)  AS TOTAL\n"
                    + "FROM\n"
                    + "    VendaProduto VP,\n"
                    + "    Venda V,\n"
                    + "    Funcionario F,\n"
                    + "    Cliente C\n"
                    + "WHERE\n"
                    + "    V.IDvenda = Vp.IdVenda\n"
                    + "        AND V.IDFunc = F.IdFunc\n"
                    + "        AND V.IdCliente = C.IdCliente\n"
                    + "        AND NMCLIENTE LIKE ?\n"
                    + "GROUP BY V.IDVenda, NMFunc, NMCliente, DtVenda;");
            stmt.setString(1, "%" + Nm + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("NMCLIENTE"));
                Funcionario f = new Funcionario(rs.getString("NMFUNC"));
                Venda v = Venda.NewInstance(c, f);
                v.setIdVenda(rs.getInt("IDVENDA"));
                v.setDtVendaBD(rs.getDate("DTVENDA"));
                v.setTotal(rs.getDouble("TOTAL"));

                Vendas.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Vendas;

    }

}

//Vai Ser Importante SELECT MAX(id) FROM "PUBLIC"."PRODUTO"
