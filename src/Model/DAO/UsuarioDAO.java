/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IUsuarioRepo;
import Model.Bean.Usuario;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements IUsuarioRepo {
    Connection con;

    @Override
    public boolean CheckLogin(String Login, String Senha) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check;
        check = false;

        try {
            stmt = con.prepareStatement("SELECT Login,Senha FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, Login);
            stmt.setString(2, Senha);
            rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario usuario = Usuario.newInstance(rs.getString("Login"), rs.getString("Senha"));
                check = true;
            } else {
                check = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

    @Override
    public boolean create(Usuario u) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO \"PUBLIC\".\"USUARIO\"\n"
                    + "(\"LOGIN\", \"SENHA\" )\n"
                    + "VALUES (?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());

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
