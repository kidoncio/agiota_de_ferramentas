/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.AmigoDAO;

/**
 *
 * @author kaique
 */
public class Amigo {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private final AmigoDAO dao;

    public Amigo() {
        this.dao = new AmigoDAO();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Email inválido!");
        }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefone() {
        return this.telefone;
    }
    
    public AmigoDAO getDao() {
        return this.dao;
    }

    @Override
    public String toString() {
        return "Amigo{" + "id=" + this.id + "nome=" + this.nome + ", email=" + this.email + ", telefone="
                + this.telefone + '}';
    }

    public ArrayList<Amigo> getMinhaLista() {
        return this.dao.getMinhaLista();
    }

    public boolean InsertAmigoDB() throws SQLException {
        int id = this.dao.getMaiorID() + 1;

        Amigo objeto = new Amigo();

        objeto.setId(id);
        objeto.setNome(this.nome);
        objeto.setEmail(this.email);
        objeto.setTelefone(this.telefone);

        this.dao.InsertAmigoDB(objeto);

        return true;
    }

    public boolean UpdateAmigoDB() {
        Amigo objeto = new Amigo();

        objeto.setId(this.id);
        objeto.setNome(this.nome);
        objeto.setEmail(this.email);
        objeto.setTelefone(this.telefone);

        this.dao.UpdateAmigoDB(objeto);

        return true;
    }

    public boolean DeleteAmigoDB() {
        this.dao.DeleteAmigoDB(this.id);

        return true;
    }
}
