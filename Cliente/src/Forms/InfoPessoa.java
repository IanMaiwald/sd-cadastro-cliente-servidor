package Forms;

import Classes.Mensagem;
import Classes.Pessoa;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class InfoPessoa extends javax.swing.JFrame {
    ArrayList<Pessoa> pessoas = new ArrayList();
    Socket cSocket = null;  //SOCKET DO CLIENTE
    ObjectOutputStream envia = null; //OBJETO PARA MANDAR MENSAGEM PARA O SERVIDOR
    ObjectInputStream recebe = null; //OBJETO PARA LER AS MENSAGENS RECEBIDAS DO SERVIDOR
    String ip =  null;
    boolean estadoDoSistema = false;
    
    public InfoPessoa() {
        initComponents();
        diretoNoCodigo();
        init();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfIdade = new javax.swing.JTextField();
        rbFeminino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btnInserir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();
        lbServ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Idade:");

        jLabel3.setText("Sexo:");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");

        buttonGroup1.add(rbMasculino);
        rbMasculino.setText("Masculino");

        taDescricao.setEditable(false);
        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        labelHora.setText("Hora");

        lbServ.setText("                                                           ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbServ, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbFeminino)
                                        .addComponent(rbMasculino)))))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbFeminino)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbMasculino))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelHora)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(lbServ, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnPesquisar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        inserir();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoPessoa().setVisible(true);
            }
        });
    }
    
    public void ip(String str){
        ip = str;
        System.out.print("CONECTOU");
    }
    
    public void init(){
        if(ip == null){
            ip = JOptionPane.showInputDialog("Digite o IP do servidor ");            
        }if(ip.equals("") || null == ip){
            System.out.println("Preencha o campo com um IP válido");
            System.exit(0);
        }else{
            System.out.print("SERVIDOR: "+ip);
            lbServ.setText("SERVIDOR: "+ip);
        }
    }
    
    public void inserir(){
        try {
            cSocket = new Socket(ip, 7000);            
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        int idade = Integer.parseInt(tfIdade.getText());
        String nome = tfNome.getText();
        String sexo = pegaSexo();

        Pessoa pessoaNova = new Pessoa(nome, idade, sexo);
        Mensagem msg = new Mensagem(pessoaNova, "Inserir");
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Erro na inserção.");
            }else{
                limpar();
                taDescricao.setText("Inserido com sucesso.");
            }
            envia.close();
            recebe.close();
            cSocket.close();
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }
    public void pesquisar(){
        try {
            cSocket = new Socket(ip,7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        Pessoa p = new Pessoa();
        p.setNome(nome);
        Mensagem msg = new Mensagem(p, "Pesquisar");
        try {
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            InputStream iptStream = cSocket.getInputStream();
            recebe = new ObjectInputStream(iptStream);
            Mensagem resp = (Mensagem) recebe.readObject();
            
            try{
                if(resp.getAcao().contains("Erro")){
                    taDescricao.setText("Erro ao pesquisar.");
                }
                else{
                    if(!estadoDoSistema){
                        btnAlterar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                        btnInserir.setEnabled(false);
                    }
                    String n = resp.getPessoa().getNome();
                    String i = resp.getPessoa().getIdade() + "";
                    String s = resp.getPessoa().getSexo();
                    taDescricao.setText(resp.getPessoa().toString());                  
                    tfNome.setText(n);
                    tfIdade.setText(i);
                    rbFeminino.setSelected(s.equalsIgnoreCase("Feminino"));
                    rbMasculino.setSelected(s.equalsIgnoreCase("Masculino"));
                }
            }
            catch(Exception ex){
                System.err.println("Erro 1 = "+ex);
            }
            
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }
    
    public String pegaSexo(){
        return rbMasculino.isSelected()?"Masculino":"Feminino";
    }
    
    public void alterar(){
        try {
            cSocket = new Socket(ip,7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        int idade = Integer.parseInt(tfIdade.getText());
        String sexo = pegaSexo();
        
        Pessoa p = new Pessoa(nome,idade,sexo);
        Mensagem msg = new Mensagem(p, "Alterar");
        
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            System.out.println(resp.getAcao());
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Falha ao alterar.");
            }
            else{
                limpar();
                taDescricao.setText("Alterado com sucesso.");
            }
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }
    
    public void excluir(){
        try {
            cSocket = new Socket(ip,7000);
        
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        Pessoa p = new Pessoa();
        p.setNome(nome);
        Mensagem msg = new Mensagem(p, "Excluir");
        
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            System.out.println(resp.getAcao());
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Falha ao excluir.");
            }
            else{
                limpar();
                taDescricao.setText("Excluído com sucesso");
            }
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }
    
    public void limpar(){
        tfIdade.setText("");
        tfNome.setText("");
        rbFeminino.setSelected(false);
        rbMasculino.setSelected(false);
        taDescricao.setText("");
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnInserir.setEnabled(true);
    }
    
    
    
    public void diretoNoCodigo(){
        MyThread t1 = new MyThread("1", 1);
        t1.start();
        System.out.println(MyThread.currentThread());
        labelHora.setText("Hora");        
    }
    
    class MyThread extends Thread{
    DateFormat dateFormat = null;
    Date date = null;
    String time;
    int delay;
    String name;
    
    public MyThread(String name,  int delay){
        this.delay = delay;
        this.name = name;
    }
    
    public void run() {
        for(int j=0;j<100;j++) {   
            for (int i=0; i<999999999; i++){
                try{
                    sleep(delay);
                }
                catch(InterruptedException e){
                    continue;
                }
                labelHora.setText(this.getTime());
            }
        }
    }
    
    public String getTime(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        time = dateFormat.format(date);
        return this.time;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel lbServ;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}