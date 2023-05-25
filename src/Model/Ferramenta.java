/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.FerramentaDAO;

/**
 *
 * @author lucas
 */
public class Ferramenta {
    // Atributos
    private String nome;
    private String marca;
    private int quantidade;
    private int custo;
    private final FerramentaDAO dao;

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }
    
    
}
