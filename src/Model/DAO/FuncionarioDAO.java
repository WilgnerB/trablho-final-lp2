/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Interfaces.IFuncionarioRepo;
import Model.Bean.Funcionario;
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
 * @author wilgn
 */
public class FuncionarioDAO implements IFuncionarioRepo {
    Connection con;

    @Override
    public List<Funcionario> read() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> Funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario WHERE STATUS='A' ORDER BY idfunc;");
            rs = stmt.executeQuery();
            

            while (rs.next()) {

                Funcionario Funcionario = new Funcionario(rs.getInt("idFunc"));

                Funcionario.setNmfunc(rs.getString("nmFunc"));
                Funcionario.setTelefone(rs.getString("telefone"));
                Funcionario.setDtnascBD(rs.getDate("dtnasc"));

                Funcionarios.add(Funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Funcionarios;

    }
}
