/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DAO.EmprestimoDAO;

/**
 *
 * @author kaique
 */
public class Emprestimo {
    private int id;
    private Date emprestimo;
    private Date devolucao;
    private int quantidade;
    private int id_amigo;
    private int id_ferramenta;
    private Amigo amigo;
    private Ferramenta ferramenta;
    private final EmprestimoDAO dao;

    public Emprestimo() {
        this.dao = new EmprestimoDAO();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmprestimo(Date emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setId_amigo(int id_amigo) {
        this.id_amigo = id_amigo;
    }

    public void setId_ferramenta(int id_ferramenta) {
        this.id_ferramenta = id_ferramenta;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public int getId() {
        return this.id;
    }

    public Date getEmprestimo() {
        return this.emprestimo;
    }

    public Date getDevolucao() {
        return this.devolucao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public int getId_amigo() {
        return this.id_amigo;
    }

    public int getId_ferramenta() {
        return this.id_ferramenta;
    }

    public Amigo getAmigo() {
        return this.amigo;
    }

    public Ferramenta getFerramenta() {
        return this.ferramenta;
    }

    public EmprestimoDAO getDao() {
        return this.dao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", emprestimo=" + emprestimo + ", devolucao=" + devolucao + ", quantidade="
                + quantidade + ", id_amigo=" + id_amigo + ", id_ferramenta=" + id_ferramenta + '}';
    }

    public ArrayList<Emprestimo> getMinhaLista() {
        return this.dao.getMinhaLista();
    }

    public boolean InsertEmprestimoDB() throws SQLException {
        int id = this.dao.getMaiorID() + 1;

        Emprestimo objeto = new Emprestimo();

        objeto.setId(id);

        if (this.id_amigo > 0) {
            objeto.setId_amigo(this.id_amigo);
        } else if (this.amigo != null) {
            objeto.setId_amigo(this.amigo.getId());
        }

        if (this.id_ferramenta > 0) {
            objeto.setId_ferramenta(this.id_ferramenta);
        } else if (this.ferramenta != null) {
            objeto.setId_ferramenta(this.ferramenta.getId());
        }

        objeto.setEmprestimo(this.emprestimo);
        objeto.setDevolucao(this.devolucao);
        objeto.setQuantidade(this.quantidade);

        this.dao.InsertEmprestimoDB(objeto);

        return true;
    }

    public boolean UpdateEmprestimoDB() {
        Emprestimo objeto = new Emprestimo();

        objeto.setId(this.id);

        if (this.id_amigo > 0) {
            objeto.setId_amigo(this.id_amigo);
        } else if (this.amigo != null) {
            objeto.setId_amigo(this.amigo.getId());
        }

        if (this.id_ferramenta > 0) {
            objeto.setId_ferramenta(this.id_ferramenta);
        } else if (this.ferramenta != null) {
            objeto.setId_ferramenta(this.ferramenta.getId());
        }

        objeto.setEmprestimo(this.emprestimo);
        objeto.setDevolucao(this.devolucao);
        objeto.setQuantidade(this.quantidade);

        this.dao.UpdateEmprestimoDB(objeto);

        return true;
    }

    public boolean DeleteEmprestimoDB() {
        this.dao.DeleteEmprestimoDB(this.id);

        return true;
    }
}
