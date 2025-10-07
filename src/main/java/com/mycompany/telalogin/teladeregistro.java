/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telalogin;

/**
 *
 * @author ecoz
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
public class teladeregistro extends javax.swing.JFrame {


    public teladeregistro() {
        
        setUndecorated(true);
        
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.foreground", Color.BLACK);
        initComponents();
        //setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        jCheckTermos.setIcon(new CustomCheckBoxIcon(24)); // quadrado maior
        jCheckTermos.setSelectedIcon(new CustomCheckBoxIcon(24)); // mesmo tamanho para marcado
        jCheckTermos.setText("");
        
        //Configs do tooltip da senha
        ToolTipManager.sharedInstance().setInitialDelay(100);
        labelAjudaSenha.setToolTipText(
        "<html>A senha dever conter:<br>"+
        "- Números (1-9)<br>"+
        "- Símbolos (@, !, #...)<br>"+
        "- Letras maiúsculas (A-Z)<br>"+
        "- Letras minúsculas (a-)<br>"+        
        "- Mínimo de 8 caracteres</html>"          
        );
   
    }
    
    

    //VALIDAÇÕES

    public boolean checarEmailCAD(String emailCAD){
        emailCAD = emailCAD.trim();
        
        if(emailCAD.isEmpty()){
            labelCADemailERROR.setText("O campo de e-mail não pode ficar vazio.");
            return false;
        }
        if(emailCAD.contains(" ")){
            labelCADemailERROR.setText("O e-mail não pode conter espaços.");
            return false;
        }
        if(!emailCAD.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
            labelCADemailERROR.setText("Digite um e-mail válido. Ex: usuario@dominio.com");
            return false;
        }
         CadastroRepository checkrepo = new CadastroRepository(); 
        if(checkrepo.consultaEmail(emailCAD)){
            labelCADemailERROR.setText("Este E-mail já está cadastrado.");
            return false;
        }
        
        labelCADemailERROR.setText("");
        return true;
    }
    
    public boolean checarSenhaCAD(String senhaCAD){
        
        if(senhaCAD == null || senhaCAD.length() == 0){
            labelCADsenhaERROR.setText("O campo senha não pode ficar vazio.");
            return false;
        }
        if(senhaCAD.length()<8){
            labelCADsenhaERROR.setText("A senha deve ter no mínimo 8 caracteres.");
            return false;
        }       
        if(!senhaCAD.matches(".*[A-Z].*")){
            labelCADsenhaERROR.setText("A senha deve conter pelo menos uma letra maiúscula.");
            return false;
        }
        if(!senhaCAD.matches(".*[a-z].*")){
            labelCADsenhaERROR.setText("A senha deve conter pelo menos uma letra minúscula.");
            return false;
        }
        if(!senhaCAD.matches(".*\\d.*")){
            labelCADsenhaERROR.setText("A senha deve conter pelo menos um número.");
            return false;
        }
        if(!senhaCAD.matches(".*[@!#\\$%&*^+=].*")){
            labelCADsenhaERROR.setText("A senha deve conter pelo menos um símbolo(!@#$...).");
            return false;
        }
        labelCADsenhaERROR.setText("");
        return true;
    }
    
    public boolean checarConfirmSenhaCAD(String confirmSenhaCAD, String senhaCAD){
        
        if(confirmSenhaCAD == null || confirmSenhaCAD.length() == 0){
            labelCADconfirmERROR.setText("Confirme sua senha.");
            return false;
        }
        if (!confirmSenhaCAD.equals(senhaCAD)){
            labelCADconfirmERROR.setText("As senhas não são iguais. Tente Novamente.");
            return false;
        }
        labelCADconfirmERROR.setText("");
        return true;  
    }
    
    public boolean checarNascCAD(String nascimentoCAD){
        nascimentoCAD = nascimentoCAD.trim();
        if(nascimentoCAD.contains("_") || nascimentoCAD.isEmpty()){
        labelCADnascERROR.setText("<html>Preencha a data de nascimento.</html>");
        return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date data;
        try{
            data = sdf.parse(nascimentoCAD);
        } catch (ParseException e){
        labelCADnascERROR.setText("<html>Data de nascimento inválida.</html>");
        return false;
        }
        if(data.after(new Date())){
        labelCADnascERROR.setText("<html>A data não pode ser no futuro.</html>");
        return false;
        }
        labelCADnascERROR.setText("");
        return true;
        
    }
    
    //Custom checkboxCheck
        public class CustomCheckBoxIcon implements Icon {
    private final int size;
    public CustomCheckBoxIcon(int size) {
        this.size = size;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        JCheckBox cb = (JCheckBox) c;
        Graphics2D g2 = (Graphics2D) g.create();

        
        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, size - 1, size - 1);
        if (cb.isSelected()) {
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLUE);
            g2.drawLine(x + 4, y + size / 2, x + size / 3, y + size - 5);
            g2.drawLine(x + size / 3, y + size - 5, x + size - 5, y + 5);
        }
        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return size;
    }
    @Override
    public int getIconHeight() {
        return size;
    }
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textCadEmail = new javax.swing.JTextField();
        jPasswordFieldCad = new javax.swing.JPasswordField();
        labelAjudaSenha = new javax.swing.JLabel();
        jPasswordFieldCadConfirm = new javax.swing.JPasswordField();
        jFormattedTextFieldNasc = new javax.swing.JFormattedTextField();
        labelCADemailERROR = new javax.swing.JLabel();
        labelCADsenhaERROR = new javax.swing.JLabel();
        labelCADconfirmERROR = new javax.swing.JLabel();
        labelCADnascERROR = new javax.swing.JLabel();
        buttonTermos = new javax.swing.JButton();
        jCheckTermos = new javax.swing.JCheckBox();
        buttomConcluir = new javax.swing.JButton();
        buttonRetornaLogin = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        labelCADtermosERROR = new javax.swing.JLabel();
        labelFundoRegistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textCadEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textCadEmail.setBorder(null);
        textCadEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCadEmailActionPerformed(evt);
            }
        });
        getContentPane().add(textCadEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 96, 370, 46));

        jPasswordFieldCad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordFieldCad.setBorder(null);
        getContentPane().add(jPasswordFieldCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 202, 370, 46));

        labelAjudaSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sinal-duvida.png"))); // NOI18N
        getContentPane().add(labelAjudaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 30, 30));

        jPasswordFieldCadConfirm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordFieldCadConfirm.setBorder(null);
        getContentPane().add(jPasswordFieldCadConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 309, 370, 46));

        jFormattedTextFieldNasc.setBorder(null);
        jFormattedTextFieldNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("##/##/####"))));
        jFormattedTextFieldNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextFieldNasc.setToolTipText("");
        jFormattedTextFieldNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jFormattedTextFieldNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldNascActionPerformed(evt);
            }
        });
        getContentPane().add(jFormattedTextFieldNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 424, 100, 38));
        try {
            javax.swing.text.MaskFormatter formatoData = new javax.swing.text.MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter('_'); // mostra sublinhado nos espaços vazios
            jFormattedTextFieldNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatoData));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelCADemailERROR.setForeground(new java.awt.Color(255, 51, 0));
        labelCADemailERROR.setToolTipText("");
        getContentPane().add(labelCADemailERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 148, 370, -1));

        labelCADsenhaERROR.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(labelCADsenhaERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 253, 370, 20));

        labelCADconfirmERROR.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(labelCADconfirmERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 361, 370, -1));

        labelCADnascERROR.setForeground(new java.awt.Color(255, 51, 0));
        labelCADnascERROR.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(labelCADnascERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 432, 250, 20));

        buttonTermos.setBackground(new java.awt.Color(242, 249, 245));
        buttonTermos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonTermos.setForeground(new java.awt.Color(0, 86, 179));
        buttonTermos.setBorderPainted(false);
        buttonTermos.setContentAreaFilled(false);
        buttonTermos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(buttonTermos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 160, 20));

        jCheckTermos.setBackground(new java.awt.Color(242, 249, 245));
        jCheckTermos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckTermos.setContentAreaFilled(false);
        jCheckTermos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckTermosActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckTermos, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 483, 30, 30));

        buttomConcluir.setBackground(new java.awt.Color(148, 195, 92));
        buttomConcluir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttomConcluir.setForeground(new java.awt.Color(255, 255, 255));
        buttomConcluir.setText("Criar Conta");
        buttomConcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttomConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(buttomConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 541, 191, 52));

        buttonRetornaLogin.setBackground(new java.awt.Color(242, 249, 245));
        buttonRetornaLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonRetornaLogin.setForeground(new java.awt.Color(0, 86, 179));
        buttonRetornaLogin.setBorderPainted(false);
        buttonRetornaLogin.setContentAreaFilled(false);
        buttonRetornaLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRetornaLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonRetornaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetornaLoginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRetornaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 550, 70, 30));

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-X.png"))); // NOI18N
        buttonClose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 1, 50, 50));

        labelCADtermosERROR.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(labelCADtermosERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 360, 20));

        labelFundoRegistro.setBackground(new java.awt.Color(255, 255, 255));
        labelFundoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundoRegistro.png"))); // NOI18N
        labelFundoRegistro.setPreferredSize(new java.awt.Dimension(1060, 600));
        getContentPane().add(labelFundoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textCadEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCadEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCadEmailActionPerformed

    private void jFormattedTextFieldNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldNascActionPerformed

    private void jCheckTermosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckTermosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckTermosActionPerformed

    private void buttomConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomConcluirActionPerformed
        String emailCAD = textCadEmail.getText();
        String senhaCAD = new String(jPasswordFieldCad.getPassword());
        String confirmSenhaCAD = new String (jPasswordFieldCadConfirm.getPassword());
        String nascimentoCAD = jFormattedTextFieldNasc.getText();
        nascimentoCAD = nascimentoCAD.replaceAll("[^\\d]", "");
        if (nascimentoCAD.matches("\\d{8}")) {
            nascimentoCAD = nascimentoCAD.substring(0,2) + "/" +
            nascimentoCAD.substring(2,4) + "/" +
            nascimentoCAD.substring(4);
        }
        boolean erro = false;
        
        CadastroRepository repo = new CadastroRepository();  
        repo.testarConexao();   
        //Checar o email no banco
       // if(repo.consultaEmail(emailCAD)){
       //     labelCADemailERROR.setText("Este E-mail já está cadastrado.");
        //    erro = true;
       // }
        //Validações
        if(!checarEmailCAD(emailCAD)){
            erro = true;
        }
        if(!checarSenhaCAD(senhaCAD)){
            erro = true;
        }
        if(!checarConfirmSenhaCAD(confirmSenhaCAD, senhaCAD)){
            erro = true;
        }
        if(!checarNascCAD(nascimentoCAD)){
            erro = true;
        }
        if(!jCheckTermos.isSelected()){
            labelCADtermosERROR.setText("Você precisa aceitar os termos de uso para continuar.");
            erro = true;
        }else{
            labelCADtermosERROR.setText("");            
        }
        
        
        //Sem erros OK
        if(!erro){
            boolean sucesso = repo. inserirCadastro(emailCAD,senhaCAD,nascimentoCAD);
            if(sucesso){
            JOptionPane.showMessageDialog(this, "Cadastro conlcuido com Sucesso.");
            this.dispose();
            teladelogin telaLogin = new teladelogin();
            telaLogin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar. Tente Novamente.");
            }
            
        }
    }//GEN-LAST:event_buttomConcluirActionPerformed

    private void buttonRetornaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetornaLoginActionPerformed
        teladelogin telaLogin = new teladelogin();
        telaLogin.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRetornaLoginActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
       dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(teladeregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teladeregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teladeregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teladeregistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teladeregistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttomConcluir;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonRetornaLogin;
    private javax.swing.JButton buttonTermos;
    private javax.swing.JCheckBox jCheckTermos;
    private javax.swing.JFormattedTextField jFormattedTextFieldNasc;
    private javax.swing.JPasswordField jPasswordFieldCad;
    private javax.swing.JPasswordField jPasswordFieldCadConfirm;
    private javax.swing.JLabel labelAjudaSenha;
    private javax.swing.JLabel labelCADconfirmERROR;
    private javax.swing.JLabel labelCADemailERROR;
    private javax.swing.JLabel labelCADnascERROR;
    private javax.swing.JLabel labelCADsenhaERROR;
    private javax.swing.JLabel labelCADtermosERROR;
    private javax.swing.JLabel labelFundoRegistro;
    private javax.swing.JTextField textCadEmail;
    // End of variables declaration//GEN-END:variables
}
