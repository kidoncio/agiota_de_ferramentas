package DAO;

import Model.Database;
import java.util.ArrayList;
import Model.Amigo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author lucas
 */
public class AmigoDAO {
    public static ArrayList<Amigo> MinhaLista = new ArrayList<Amigo>();

    public AmigoDAO() {
    }

    public int getMaiorID() throws SQLException {
        int maiorID = 0;

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM amigos");

            res.next();

            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public ArrayList<Amigo> getMinhaLista() {
        MinhaLista.clear();

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM amigos");

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String email = res.getString("email");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo();
                objeto.setId(id);
                objeto.setNome(nome);
                objeto.setEmail(email);
                objeto.setTelefone(telefone);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public boolean InsertAmigoDB(Amigo objeto) {
        String sql = "INSERT INTO amigos(id,nome,email,telefone) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean DeleteAmigoDB(int id) {
        try {
            Statement stmt = Database.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM amigos WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateAmigoDB(Amigo objeto) {

        String sql = "UPDATE amigos set nome = ? ,email = ? ,telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmail());
            stmt.setString(3, objeto.getTelefone());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo();

        objeto.setId(id);

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM amigos WHERE id = " + id);

            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setEmail(res.getString("email"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();
        } catch (SQLException erro) {
        }

        return objeto;
    }
}
