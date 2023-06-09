package View;

import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciaEmprestimo extends javax.swing.JFrame {

    private Emprestimo objetoEmprestimo;
    private ArrayList<Ferramenta> ferramentas;
    private ArrayList<Amigo> amigos;

    public GerenciaEmprestimo() {
        initComponents();

        this.objetoEmprestimo = new Emprestimo();

        this.c_id_ferramenta.removeAllItems();
        this.c_id_amigo.removeAllItems();
        this.b_add_lembrete.setVisible(false);

        this.ferramentas = new Ferramenta().getDao().getMinhaLista();

        for (Ferramenta ferramenta : ferramentas) {
            c_id_ferramenta.addItem(ferramenta.getNome());
        }

        this.amigos = new Amigo().getDao().getMinhaLista();

        for (Amigo amigo : amigos) {
            c_id_amigo.addItem(amigo.getNome());
        }

        this.carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmprestimo = new javax.swing.JTable();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_quantidade = new javax.swing.JTextField();
        c_id_ferramenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        c_id_amigo = new javax.swing.JComboBox<>();
        c_emprestimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_devolucao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        b_add_lembrete = new javax.swing.JButton();

        setTitle("Gerenciamento de emprestimos");
        setResizable(false);

        jTableEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Amigo", "Quantidade", "Emprestado em", "Devolvido em"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmprestimoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmprestimo);
        if (jTableEmprestimo.getColumnModel().getColumnCount() > 0) {
            jTableEmprestimo.getColumnModel().getColumn(0).setMinWidth(30);
            jTableEmprestimo.getColumnModel().getColumn(1).setMinWidth(150);
            jTableEmprestimo.getColumnModel().getColumn(2).setMinWidth(50);
            jTableEmprestimo.getColumnModel().getColumn(3).setMinWidth(50);
            jTableEmprestimo.getColumnModel().getColumn(4).setMinWidth(150);
            jTableEmprestimo.getColumnModel().getColumn(5).setMinWidth(150);
        }

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ferramenta:");

        jLabel2.setText("Quantidade:");

        c_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_quantidadeActionPerformed(evt);
            }
        });

        c_id_ferramenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Amigo:");

        c_id_amigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        c_id_amigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_id_amigoActionPerformed(evt);
            }
        });

        c_emprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_emprestimoActionPerformed(evt);
            }
        });

        jLabel6.setText("Emprestado em:");

        c_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_devolucaoActionPerformed(evt);
            }
        });

        jLabel7.setText("Devolvido em:");

        b_add_lembrete.setText("Adicionar na agenda");
        b_add_lembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add_lembreteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b_apagar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(c_id_amigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(c_emprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(10, 10, 10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(b_cancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b_alterar)
                                                .addGap(129, 129, 129)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(c_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(c_id_ferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(10, 10, 10))))
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(b_add_lembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_id_ferramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_id_amigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_emprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(b_add_lembrete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar)
                    .addComponent(b_alterar)
                    .addComponent(b_apagar))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_add_lembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add_lembreteActionPerformed
        // TODO add your handling code here:
        try {
            Ferramenta ferramenta = this.ferramentas.stream()
                    .filter(f -> f.getNome() == this.c_id_ferramenta.getSelectedItem()).findFirst().get();
            Amigo amigo = this.amigos.stream().filter(f -> f.getNome() == this.c_id_amigo.getSelectedItem()).findFirst()
                    .get();

            String tituloEvento = "Lembrete de emprestimo da ferramenta: " + ferramenta.getNome();
            String descricaoEvento = "O seu amigo " + amigo.getNome() + " pode ser encontrado através do telefone " + amigo.getTelefone() + " ou através do e-mail " + amigo.getEmail() + ".";
            String url = "https://calendar.google.com/calendar/r/eventedit?text=" + URLEncoder.encode(tituloEvento, StandardCharsets.UTF_8.toString()) + "&details=" + URLEncoder.encode(descricaoEvento, StandardCharsets.UTF_8.toString());

            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(GerenciaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Ops. Não foi possível adicionar o lembrete.");
        }
    }//GEN-LAST:event_b_add_lembreteActionPerformed

    private void c_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c_quantidadeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_c_quantidadeActionPerformed

    private void c_emprestimoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c_emprestimoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_c_emprestimoActionPerformed

    private void c_id_amigoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c_id_amigoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_c_id_amigoActionPerformed

    private void c_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_c_devolucaoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_c_devolucaoActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b_cancelarActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_b_cancelarActionPerformed

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b_alterarActionPerformed

        try {
            int id = 0;
            Ferramenta ferramenta = this.ferramentas.stream()
                    .filter(f -> f.getNome() == this.c_id_ferramenta.getSelectedItem()).findFirst().get();
            Amigo amigo = this.amigos.stream().filter(f -> f.getNome() == this.c_id_amigo.getSelectedItem()).findFirst()
                    .get();
            int quantidade = 0;
            Date emprestimo = new Date();
            Date devolucao = new Date();

            if (ferramenta == null) {
                throw new Mensagens("Deve selecionar uma ferramenta.");
            }

            if (amigo == null) {
                throw new Mensagens("Deve selecionar um amigo.");
            }

            if (this.c_quantidade.getText().length() <= 0) {
                throw new Mensagens("Quantidade deve ser n�mero e maior ou igual a zero.");
            } else {
                quantidade = Integer.parseInt(this.c_quantidade.getText());
            }

            if (this.c_emprestimo.getText().length() < 2) {
                throw new Mensagens("Data empréstimo deve ser preenchido.");
            } else if (this.c_emprestimo.getText().length() != 10) {
                throw new Mensagens("O formato da data de empréstimo deve ser dd/mm/aaaa");
            } else {
                try {
                    emprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(this.c_emprestimo.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                    throw new Mensagens("O formato da data de empréstimo deve ser dd/mm/aaaa");
                }
            }

            if (this.c_devolucao.getText().length() > 0 && !"".equals(this.c_devolucao.getText())) {
                if (this.c_devolucao.getText().length() != 10) {
                    throw new Mensagens("O formato da data de devolução deve ser dd/mm/aaaa");
                } else {
                    try {
                        devolucao = new SimpleDateFormat("dd/MM/yyyy").parse(this.c_devolucao.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(CadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                        throw new Mensagens("O formato da data de devolução deve ser dd/mm/aaaa");
                    }
                }
            }

            if (this.jTableEmprestimo.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione um emprestimo para alterar");
            } else {
                id = Integer.parseInt(
                        this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 0).toString());
            }

            this.objetoEmprestimo.setId(id);
            this.objetoEmprestimo.setId_amigo(amigo.getId());
            this.objetoEmprestimo.setId_ferramenta(ferramenta.getId());
            ;
            this.objetoEmprestimo.setQuantidade(quantidade);
            this.objetoEmprestimo.setEmprestimo(emprestimo);

            if (this.c_devolucao.getText().length() > 0) {
                this.objetoEmprestimo.setDevolucao(devolucao);
            }

            if (this.objetoEmprestimo.UpdateEmprestimoDB()) {
                this.limpaCampos();

                JOptionPane.showMessageDialog(rootPane,
                        "Emprestimo alterado com Sucesso!");

            }
            System.out.println(this.objetoEmprestimo.getMinhaLista().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero.");
        } finally {
            this.b_add_lembrete.setVisible(false);
            carregaTabela(); // atualiza a tabela.
        }
    }// GEN-LAST:event_b_alterarActionPerformed

    private void limpaCampos() {
        this.c_quantidade.setText("");
        this.c_devolucao.setText("");
        this.c_emprestimo.setText("");
        this.c_id_amigo.setSelectedIndex(-1);
        this.c_id_ferramenta.setSelectedIndex(-1);
    }

    private void jTableEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableEmprestimoMouseClicked

        if (this.jTableEmprestimo.getSelectedRow() != -1) {

            String nomeFerramenta = this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 1)
                    .toString();
            String nomeAmigo = this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 2).toString();
            String quantidade = this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 3).toString();
            String emprestimo = this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 4).toString();
            String devolucao = this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 5).toString();

            Ferramenta ferramenta = this.ferramentas.stream()
                    .filter(f -> f.getNome() == nomeFerramenta).findFirst().get();

            int indexFerramenta = this.ferramentas.indexOf(ferramenta);

            Amigo amigo = this.amigos.stream()
                    .filter(f -> f.getNome() == nomeAmigo).findFirst().get();

            int indexAmigo = this.amigos.indexOf(amigo);

            this.c_id_ferramenta.setSelectedIndex(indexFerramenta);
            this.c_id_amigo.setSelectedIndex(indexAmigo);
            this.c_quantidade.setText(quantidade);
            this.c_emprestimo.setText(emprestimo);
            this.c_devolucao.setText(devolucao);

            if (devolucao == null || "".equals(devolucao)) {
                this.b_add_lembrete.setVisible(true);
            } else {
                this.b_add_lembrete.setVisible(false);
            }
        }
    }// GEN-LAST:event_jTableEmprestimoMouseClicked

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_b_apagarActionPerformed
        try {
            // validando dados da interface gr�fica.
            int id = 0;

            if (this.jTableEmprestimo.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione uma emprestimo para APAGAR");
            } else {
                id = Integer.parseInt(
                        this.jTableEmprestimo.getValueAt(this.jTableEmprestimo.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro bot�o
            int resposta_usuario = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja APAGAR esta Emprestimo?");

            if (resposta_usuario == 0) {// clicou em SIM

                this.objetoEmprestimo.setId(id);

                if (this.objetoEmprestimo.DeleteEmprestimoDB()) {
                    this.limpaCampos();

                    JOptionPane.showMessageDialog(rootPane,
                            "Emprestimo apagado com sucesso!");
                }

            }

            System.out.println(this.objetoEmprestimo.getMinhaLista().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }// GEN-LAST:event_b_apagarActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTableEmprestimo.getModel();
        modelo.setNumRows(0);

        ArrayList<Emprestimo> minhalista = new ArrayList<>();
        minhalista = objetoEmprestimo.getMinhaLista();

        for (Emprestimo emprestimo : minhalista) {
            Ferramenta ferramenta = this.ferramentas.stream().filter(f -> f.getId() == emprestimo.getId_ferramenta())
                    .findFirst()
                    .get();
            Amigo amigo = this.amigos.stream().filter(f -> f.getId() == emprestimo.getId_amigo()).findFirst().get();

            Date devolucao = emprestimo.getDevolucao();

            String devolucaoToString = "";

            String outputPattern = "dd/MM/yyyy";

            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat outputFormat = new SimpleDateFormat(outputPattern);

            String emprestimoToString = "";

            try {
                Date date = inputFormat.parse(emprestimo.getEmprestimo().toString());
                emprestimoToString = outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (devolucao != null) {
                try {
                    Date date = inputFormat.parse(devolucao.toString());
                    devolucaoToString = outputFormat.format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            Object[] row = new Object[]{
                emprestimo.getId(),
                ferramenta.getNome(),
                amigo.getNome(),
                emprestimo.getQuantidade(),
                emprestimoToString,
                devolucaoToString
            };

            modelo.addRow(row);
        }
    }

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
            java.util.logging.Logger.getLogger(GerenciaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaEmprestimo().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_add_lembrete;
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_devolucao;
    private javax.swing.JTextField c_emprestimo;
    private javax.swing.JComboBox<String> c_id_amigo;
    private javax.swing.JComboBox<String> c_id_ferramenta;
    private javax.swing.JTextField c_quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmprestimo;
    // End of variables declaration//GEN-END:variables
}
