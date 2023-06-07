package DAO;

import Model.Database;
import java.util.ArrayList;
import Model.Ferramenta;
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
public class FerramentaDAO {
    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();

    public FerramentaDAO() {
    }

    public int getMaiorID() throws SQLException {
        int maiorID = 0;

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM ferramentas");

            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public ArrayList<Ferramenta> getMinhaLista() {
        MinhaLista.clear();

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas");

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                int quantidade = res.getInt("quantidade");
                int custo = res.getInt("custo");

                Ferramenta objeto = new Ferramenta();
                objeto.setId(id);
                objeto.setNome(nome);
                objeto.setMarca(marca);
                objeto.setQuantidade(quantidade);
                objeto.setCusto(custo);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public boolean InsertFerramentaDB(Ferramenta objeto) {
        String sql = "INSERT INTO ferramentas(id,nome,marca,quantidade,custo) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setInt(4, objeto.getQuantidade());
            stmt.setInt(5, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean DeleteFerramentaDB(int id) {
        try {
            Statement stmt = Database.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM emprestimos WHERE id_ferramenta = " + id);
            stmt.close();

            stmt = Database.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM ferramentas WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateFerramentaDB(Ferramenta objeto) {

        String sql = "UPDATE ferramentas set nome = ? ,marca = ? ,quantidade = ?, custo = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setInt(3, objeto.getQuantidade());
            stmt.setInt(4, objeto.getCusto());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();

        objeto.setId(id);

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas WHERE id = " + id);

            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setQuantidade(res.getInt("quantidade"));
            objeto.setCusto(res.getInt("custo"));

            stmt.close();
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
