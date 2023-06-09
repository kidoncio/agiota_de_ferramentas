package View;

import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroEmprestimo extends javax.swing.JFrame {

    private Emprestimo objetoEmprestimo;
    private ArrayList<Ferramenta> ferramentas;
    private ArrayList<Amigo> amigos;

    public CadastroEmprestimo() {
        initComponents();
        this.objetoEmprestimo = new Emprestimo();

        this.c_id_ferramenta.removeAllItems();
        this.c_id_amigo.removeAllItems();

        this.ferramentas = new Ferramenta().getDao().getMinhaLista();

        for (Ferramenta ferramenta : ferramentas) {
            c_id_ferramenta.addItem(ferramenta.getNome());
        }

        this.amigos = new Amigo().getDao().getMinhaLista();

        for (Amigo amigo : amigos) {
            c_id_amigo.addItem(amigo.getNome());
        }

        if (this.amigos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Cadastre um amigo antes de cadastrar um empréstimo.");
            this.setVisible(false);

            return;
        }

        if (this.ferramentas.size() == 0) {
            JOptionPane.showMessageDialog(null, "Cadastre uma ferramenta antes de cadastrar um empréstimo.");
            this.setVisible(false);

            return;
        }

        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_quantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        c_id_ferramenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        c_id_amigo = new javax.swing.JComboBox<>();
        c_data_emprestimo = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setTitle("Cadastro de emprestimo");
        setResizable(false);

        jLabel1.setText("Ferramenta:");

        jLabel2.setText("Quantidade: ");

        jLabel4.setText("Data empréstimo:");

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        c_id_ferramenta.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Amigo:");

        c_id_amigo.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(jLabel1,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4,
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(c_quantidade,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(171, 171, 171))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(c_data_emprestimo)
                                                                .addContainerGap())))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(b_cancelar)
                                                .addGap(53, 53, 53)
                                                .addComponent(b_cadastrar)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(c_id_amigo, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(c_id_ferramenta,
                                                                javax.swing.GroupLayout.Alignment.TRAILING, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap()))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_id_ferramenta, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(c_id_amigo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(c_data_emprestimo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b_cadastrar)
                                        .addComponent(b_cancelar))
                                .addGap(28, 28, 28)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b_cadastrarActionPerformed

        try {
            // recebendo e validando dados da interface gr�fica.
            Date emprestimo;
            int id_amigo = 0;
            int id_ferramenta = 0;
            int quantidade = 0;

            if (this.c_quantidade.getText().length() < 0) {
                throw new Mensagens("Quantidade deve ser n�mero e maior ou igual a zero.");
            } else {
                quantidade = Integer.parseInt(this.c_quantidade.getText());
            }

            if (this.c_data_emprestimo.getText().length() < 2) {
                throw new Mensagens("Data empréstimo deve ser preenchido.");
            } else if (this.c_data_emprestimo.getText().length() != 10) {
                throw new Mensagens("O formato da data de empréstimo deve ser dd/mm/aaaa");
            } else {
                try {
                    emprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(this.c_data_emprestimo.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                    throw new Mensagens("O formato da data de empréstimo deve ser dd/mm/aaaa");
                }
            }

            if (this.c_id_amigo.getSelectedIndex() < 0) {
                throw new Mensagens("Selecione um amigo.");
            } else {
                id_amigo = this.amigos.get(this.c_id_amigo.getSelectedIndex()).getId();
            }

            if (this.c_id_ferramenta.getSelectedIndex() < 0) {
                throw new Mensagens("Selecione uma ferramenta.");
            } else {
                Ferramenta ferramenta = this.ferramentas.get(this.c_id_ferramenta.getSelectedIndex());
                ArrayList<Emprestimo> emprestimosDaFerramenta = new Emprestimo().getDao()
                        .getMinhaListaEmprestimosAtivosDaFerramenta(ferramenta.getId());

                int ferramentasEmpresatadas = 0;

                for (Emprestimo emprestimoDaFerramenta : emprestimosDaFerramenta) {
                    ferramentasEmpresatadas += emprestimoDaFerramenta.getQuantidade();
                }

                int ferramentasDisponiveis = ferramenta.getQuantidade() - ferramentasEmpresatadas;

                if (quantidade > ferramentasDisponiveis) {
                    throw new Mensagens(
                            "Quantidade de ferramentas emprestadas maior que a quantidade disponível. Atualmente essa ferramenta tem "
                                    + ferramentasDisponiveis + " ferramentas disponíveis.");
                }

                id_ferramenta = ferramenta.getId();
            }

            this.objetoEmprestimo.setQuantidade(quantidade);
            this.objetoEmprestimo.setEmprestimo(emprestimo);
            this.objetoEmprestimo.setId_amigo(id_amigo);
            this.objetoEmprestimo.setId_ferramenta(id_ferramenta);

            // envia os dados para o Controlador cadastrar
            if (this.objetoEmprestimo.InsertEmprestimoDB()) {
                JOptionPane.showMessageDialog(rootPane, "Empréstimo cadastrado com sucesso!");

                this.limpaCampos();
            }

            System.out.println(this.objetoEmprestimo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } catch (SQLException ex) {
            Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_b_cadastrarActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

    }// GEN-LAST:event_b_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmprestimo().setVisible(true);
            }
        });
    }

    private void limpaCampos() {
        this.c_data_emprestimo.setText("");
        this.c_quantidade.setText("");
        this.c_id_amigo.setSelectedIndex(-1);
        this.c_id_ferramenta.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_data_emprestimo;
    private javax.swing.JComboBox<String> c_id_amigo;
    private javax.swing.JComboBox<String> c_id_ferramenta;
    private javax.swing.JTextField c_quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
