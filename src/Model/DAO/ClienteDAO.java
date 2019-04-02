/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IClienteRepo;
import Model.Bean.Cliente;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class ClienteDAO implements IClienteRepo {
    Connection con;

    @Override
    public boolean create(Cliente c) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO \"PUBLIC\".\"CLIENTE\"\n"
                    + "(\"NMCLIENTE\", \"TELEFONE\", \"DTNASC\",\"STATUS\" )\n"
                    + "VALUES (?,?,?,'A')");
            stmt.setString(1, c.getNmcliente());
            stmt.setString(2, c.getTelefone());
            stmt.setDate(3, new Date(c.getDtnasc().getTime()));
            
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
    public List<Cliente> read() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> Clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE STATUS='A' ORDER BY idcliente;");
            rs = stmt.executeQuery();
            

            while (rs.next()) {

                Cliente cliente = Cliente.NewInstace((rs.getString("nmcliente")),rs.getString("telefone"),rs.getDate("dtnasc"));

                cliente.setIdcliente(rs.getInt("idcliente"));


                Clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Clientes;

    }

    @Override
    public List<Cliente> readForNm(String Nm) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> Clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE NMCLIENTE LIKE ? ORDER BY idcliente;"
                    + " AND STATUS='A'");
            stmt.setString(1, "%" + Nm + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = Cliente.NewInstace((rs.getString("nmcliente")),rs.getString("telefone"),rs.getDate("dtnasc"));

                cliente.setIdcliente(rs.getInt("idcliente"));

                Clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Clientes;

    }
    @Override
    public boolean update(Cliente c) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE CLIENTE SET NMCLIENTE=?,TELEFONE=?,DTNASC=? WHERE IDCLIENTE=?");
            stmt.setString(1, c.getNmcliente());
            stmt.setString(2, c.getTelefone());
            stmt.setDate(3,new Date (c.getDtnasc().getTime()));
            stmt.setInt(4, c.getIdcliente());

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
    public boolean delete(Cliente c) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE CLIENTE SET STATUS='D' WHERE IDCLIENTE = ?");
            stmt.setInt(1, c.getIdcliente());

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

}
