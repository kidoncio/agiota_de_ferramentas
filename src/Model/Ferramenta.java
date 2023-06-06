/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.FerramentaDAO;

public class Ferramenta {
    private int id;
    private String nome;
    private String marca;
    private int quantidade;
    private int custo;
    private final FerramentaDAO dao;

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public int getCusto() {
        return this.custo;
    }

    public FerramentaDAO getDao() {
        return this.dao;
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Marca: " + this.getMarca()
                + "\n Quantidade: " + this.getQuantidade()
                + "\n Custo: " + this.getCusto()
                + "\n -----------";
    }

    public ArrayList<Ferramenta> getMinhaLista() {
        return this.dao.getMinhaLista();
    }

    public boolean InsertFerramentaDB() throws SQLException {
        int id = this.dao.getMaiorID() + 1;

        Ferramenta objeto = new Ferramenta();

        objeto.setId(id);
        objeto.setCusto(this.custo);
        objeto.setMarca(this.marca);
        objeto.setNome(this.nome);
        objeto.setQuantidade(this.quantidade);

        this.dao.InsertFerramentaDB(objeto);

        return true;
    }

    public boolean UpdateFerramentaDB() {
        Ferramenta objeto = new Ferramenta();

        objeto.setId(this.id);
        objeto.setCusto(this.custo);
        objeto.setMarca(this.marca);
        objeto.setNome(this.nome);
        objeto.setQuantidade(this.quantidade);

        this.dao.UpdateFerramentaDB(objeto);

        return true;
    }

    public boolean DeleteFerramentaDB() {
        this.dao.DeleteFerramentaDB(this.id);

        return true;
    }
}
