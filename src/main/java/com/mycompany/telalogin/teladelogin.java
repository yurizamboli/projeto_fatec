package com.mycompany.telalogin;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.Properties;
import javax.swing.*;
import java.awt.*;
public class teladelogin extends javax.swing.JFrame {
    
    CadastroRepository cadastro = new CadastroRepository();
    
    public teladelogin() {
        setUndecorated(true);
        initComponents();

        //setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        
        //Customização do tamanho do checkboxLembrar.
        checkboxLembrar.setIcon(new CustomCheckBoxIcon(24)); // quadrado maior
        checkboxLembrar.setSelectedIcon(new CustomCheckBoxIcon(24)); // mesmo tamanho para marcado
        checkboxLembrar.setText("");      
        
        textEmail.setText(carregarEmail());        
    }
    
    //Funções de validação
    public boolean emailValido(String email){
        //Checa se esta vazio ou nulo
        if (email == null || email.isEmpty()){
            return false;
        }
        
        //Checa o formato do email
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(regex)) {
            return false; 
        }
        
        //Checa se esta cadastrado
        if (!cadastro.consultaEmail(email)){
            return false;
        }
        
        //Tudo Checado e certo
        return true;
    }

    public boolean senhaValida(String email,String senha, CadastroRepository cadastro){
        //Checa se esta nulo ou com menos de 8 caracter
        if(senha == null || senha.length()<8){
            return false;
        }
        //Tudo checado e certo
        return cadastro.consultaSenha(email,senha);
    }
    
    //Funções do checkbox
    public void salvarEmail(String email){    
        try{
            Properties prop = new Properties();
            prop.setProperty("ultimoEmail",email);
            FileOutputStream fos = new FileOutputStream("config.properties");
        prop.store(fos, "Configurações do login");
        fos.close();
        } 
        catch (IOException e) {
        e.printStackTrace();
        }    
    }
    
    public String carregarEmail(){
     try {
        Properties prop = new Properties();
        File file = new File("config.properties");
        if (!file.exists()) return ""; // se não existir, retorna vazio

        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        fis.close();

        return prop.getProperty("ultimoEmail", "");
    } 
     catch (IOException e) {
        e.printStackTrace();
        return "";
    }
    }
    
    //Classe para customizar o checkboxLembrar
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

        textEmail = new javax.swing.JTextField();
        labelEmailERRO = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        labelSenhaERRO = new javax.swing.JLabel();
        checkboxLembrar = new javax.swing.JCheckBox();
        buttonLogin = new javax.swing.JButton();
        buttonEsqueciSenha = new javax.swing.JButton();
        buttonCadastro = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        labelFundoImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textEmail.setBorder(null);
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        getContentPane().add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 150, 389, 40));

        labelEmailERRO.setForeground(new java.awt.Color(255, 51, 0));
        labelEmailERRO.setToolTipText("");
        getContentPane().add(labelEmailERRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 196, 380, 20));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 256, 389, 40));

        labelSenhaERRO.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(labelSenhaERRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 380, 20));

        checkboxLembrar.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        checkboxLembrar.setContentAreaFilled(false);
        checkboxLembrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxLembrarActionPerformed(evt);
            }
        });
        getContentPane().add(checkboxLembrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 330, 30, 30));

        buttonLogin.setBackground(new java.awt.Color(148, 195, 92));
        buttonLogin.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Entrar");
        buttonLogin.setToolTipText("");
        buttonLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 392, 140, 60));

        buttonEsqueciSenha.setForeground(new java.awt.Color(0, 86, 179));
        buttonEsqueciSenha.setBorder(null);
        buttonEsqueciSenha.setContentAreaFilled(false);
        buttonEsqueciSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEsqueciSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEsqueciSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEsqueciSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 210, 20));

        buttonCadastro.setBackground(new java.awt.Color(251, 253, 252));
        buttonCadastro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonCadastro.setForeground(new java.awt.Color(56, 142, 60));
        buttonCadastro.setBorder(null);
        buttonCadastro.setContentAreaFilled(false);
        buttonCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 526, 390, 44));

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-X.png"))); // NOI18N
        buttonClose.setBorder(null);
        buttonClose.setContentAreaFilled(false);
        buttonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 1, 50, 50));

        labelFundoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundoLogin.png"))); // NOI18N
        labelFundoImagem.setPreferredSize(new java.awt.Dimension(1060, 600));
        getContentPane().add(labelFundoImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastroActionPerformed
        teladeregistro telaRegistro = new teladeregistro();
        telaRegistro.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCadastroActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void buttonEsqueciSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEsqueciSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEsqueciSenhaActionPerformed

    private void checkboxLembrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxLembrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxLembrarActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        CadastroRepository repo = new CadastroRepository();
        repo.testarConexao();
        
            //Valição dos dados de login
        
            String email = textEmail.getText();
            String senha = new String(jPasswordField1.getPassword());
            boolean erro = false;
            
            // Checa o email
            try{
                if(!emailValido(email)){
                    labelEmailERRO.setText("E-mail incorreto ou não cadastrado.");
                    erro = true;
                } else{
                    labelEmailERRO.setText("");
                }
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(this,
                        "Ocorreu um problema ao acessar o banco. Tente novamente mais tarde.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                erro = true;
            }
            
            //Checa a senha
            try{
                if(!senhaValida(email,senha,cadastro)){
                    labelSenhaERRO.setText("Senha incorreta.");
                    erro = true;
                } else{
                    labelSenhaERRO.setText("");
                }
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(this,
                        "Ocorreu um problema ao acessar o banco. Tente novamente mais tarde.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                erro = true;
            }    

                //Situaçao sem Erro
                if(!erro){
                    if(checkboxLembrar.isSelected()){
                        salvarEmail(email);
                    }else{
                        salvarEmail("");
                    }
                    telahome telaHome = new telahome();
                    telaHome.setVisible(true);
                     dispose();    
                    System.out.println("Login Realizado com Sucesso!");
                }
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(teladelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teladelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teladelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teladelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teladelogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastro;
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonEsqueciSenha;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JCheckBox checkboxLembrar;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel labelEmailERRO;
    private javax.swing.JLabel labelFundoImagem;
    private javax.swing.JLabel labelSenhaERRO;
    private javax.swing.JTextField textEmail;
    // End of variables declaration//GEN-END:variables
}
