/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IMarcaRepo;
import Model.Bean.Marca;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasAugusto
 */
public class MarcaDAO implements IMarcaRepo {

    Connection con;

    @Override
    public boolean create(Marca m) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO MARCA(NOME,STATUS) VALUES(?,'A')");
            stmt.setString(1, m.getNome());
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
    public List<Marca> read() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM MARCA WHERE STATUS='A' ORDER BY idMarca;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca m = Marca.newinstance( rs.getString("Nome"));
                m.setIdmarca(rs.getInt("IdMarca"));
                marcas.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return marcas;

    }
}
