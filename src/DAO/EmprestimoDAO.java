package DAO;

import Model.Amigo;
import Model.Database;
import java.util.ArrayList;
import Model.Emprestimo;
import Model.Ferramenta;

import java.sql.Date;
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
public class EmprestimoDAO {
    public static ArrayList<Emprestimo> MinhaLista = new ArrayList<Emprestimo>();

    public EmprestimoDAO() {
    }

    public int getMaiorID() throws SQLException {
        int maiorID = 0;

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM emprestimos");

            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public ArrayList<Emprestimo> getMinhaLista() {
        MinhaLista.clear();

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM emprestimos");

            while (res.next()) {
                int id = res.getInt("id");
                int id_amigo = res.getInt("id_amigo");
                int id_ferramenta = res.getInt("id_ferramenta");
                int quantidade = res.getInt("quantidade");
                Date emprestimo = res.getDate("emprestimo");
                Date devolucao = res.getDate("devolucao");

                Amigo amigo = new Amigo();

                amigo = amigo.getDao().carregaAmigo(id_amigo);

                Ferramenta ferramenta = new Ferramenta();

                ferramenta = ferramenta.getDao().carregaFerramenta(id_ferramenta);

                Emprestimo objeto = new Emprestimo();

                objeto.setId(id);
                objeto.setId_amigo(id_amigo);
                objeto.setId_ferramenta(id_ferramenta);
                objeto.setEmprestimo(emprestimo);
                objeto.setDevolucao(devolucao);
                objeto.setAmigo(amigo);
                objeto.setFerramenta(ferramenta);
                objeto.setQuantidade(quantidade);

                MinhaLista.add(objeto);
            }

            stmt.close();
        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public ArrayList<Emprestimo> getMinhaListaEmprestimosAtivosDaFerramenta(int idFerramenta) {
        MinhaLista.clear();

        try {
            String sql = "SELECT * FROM emprestimos WHERE id_ferramenta = ? AND devolucao IS NULL";

            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);
            stmt.setInt(1, idFerramenta);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                int id_amigo = res.getInt("id_amigo");
                int id_ferramenta = res.getInt("id_ferramenta");
                int quantidade = res.getInt("quantidade");
                Date emprestimo = res.getDate("emprestimo");
                Date devolucao = res.getDate("devolucao");

                Amigo amigo = new Amigo();

                amigo = amigo.getDao().carregaAmigo(id_amigo);

                Ferramenta ferramenta = new Ferramenta();

                ferramenta = ferramenta.getDao().carregaFerramenta(id_ferramenta);

                Emprestimo objeto = new Emprestimo();

                objeto.setId(id);
                objeto.setId_amigo(id_amigo);
                objeto.setId_ferramenta(id_ferramenta);
                objeto.setEmprestimo(emprestimo);
                objeto.setDevolucao(devolucao);
                objeto.setAmigo(amigo);
                objeto.setFerramenta(ferramenta);
                objeto.setQuantidade(quantidade);

                MinhaLista.add(objeto);
            }

            stmt.close();
        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public boolean InsertEmprestimoDB(Emprestimo objeto) {
        String sql = "INSERT INTO emprestimos(id,emprestimo,devolucao,quantidade,id_amigo,id_ferramenta) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setDate(2, new Date(objeto.getEmprestimo().getTime()));

            if (objeto.getDevolucao() != null) {
                stmt.setDate(3, new Date(objeto.getDevolucao().getTime()));
            } else {
                stmt.setDate(3, null);
            }

            stmt.setInt(4, objeto.getQuantidade());
            stmt.setInt(5, objeto.getId_amigo());
            stmt.setInt(6, objeto.getId_ferramenta());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean DeleteEmprestimoDB(int id) {
        try {
            Statement stmt = Database.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM emprestimos WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean UpdateEmprestimoDB(Emprestimo objeto) {

        String sql = "UPDATE emprestimos set emprestimo = ? ,devolucao = ? ,quantidade = ?, id_amigo = ? ,id_ferramenta = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Database.getConexao().prepareStatement(sql);

            stmt.setDate(1, new Date(objeto.getEmprestimo().getTime()));

            if (objeto.getDevolucao() != null) {
                stmt.setDate(2, new Date(objeto.getDevolucao().getTime()));
            } else {
                stmt.setDate(2, null);
            }

            stmt.setDate(2, new Date(objeto.getDevolucao().getTime()));
            stmt.setInt(3, objeto.getQuantidade());
            stmt.setInt(4, objeto.getId_amigo());
            stmt.setInt(5, objeto.getId_ferramenta());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public Emprestimo carregaEmprestimo(int id) {
        Emprestimo objeto = new Emprestimo();

        objeto.setId(id);

        try {
            Statement stmt = Database.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM emprestimos WHERE id = " + id);

            res.next();

            objeto.setEmprestimo(res.getDate("emprestimo"));

            if (res.getDate("devolucao") != null) {
                objeto.setDevolucao(res.getDate("devolucao"));
            }

            objeto.setQuantidade(res.getInt("quantidade"));
            objeto.setId_amigo(res.getInt("id_amigo"));
            objeto.setId_ferramenta(res.getInt("id_ferramenta"));

            stmt.close();
        } catch (SQLException erro) {
        }

        return objeto;
    }
}
