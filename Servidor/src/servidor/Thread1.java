package servidor;
import Classes.Mensagem;
import Classes.Pessoa;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Thread1 extends Thread{
    Socket cSocket; //socket conectado com clientes
    String opcao;
    PrintStream EnviaClient;       
    BufferedReader RecebClient;
    static ArrayList<Pessoa> pessoas = new ArrayList();
    
    public Thread1(Socket cSocket){
        this.cSocket = cSocket;
    }
    
    @Override
    public void run(){
        try {
            System.err.println("Trhead criada");
            ObjectOutputStream envia = null;
            ObjectInputStream recebe = null;
            
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem msg = (Mensagem) recebe.readObject();
            System.err.println("Recebido");
            opcao = msg.getAcao();
                
            switch (opcao){
                case "Inserir":
                    if(inserir(msg.getPessoa())){
                        envia = new ObjectOutputStream(cSocket.getOutputStream());
                        envia.writeObject(msg);
                    }
                    else{
                        deuErro(envia);
                    }
                break;
                case "Pesquisar":
                    Pessoa pessoaPesquisar = pesquisar(msg.getPessoa());
                    if(!pessoaPesquisar.getNome().equalsIgnoreCase("erro")){
                        msg.setPessoa(pessoaPesquisar);
                        envia = new ObjectOutputStream(cSocket.getOutputStream());
                        envia.writeObject(msg);
                    }
                    else{
                        deuErro(envia);
                    }
                break;
                case "Alterar":
                    Pessoa pessoaAlterar = alterar(msg.getPessoa());
                    if(!pessoaAlterar.getNome().equalsIgnoreCase("erro")){
                        msg.setPessoa(pessoaAlterar);
                        envia = new ObjectOutputStream(cSocket.getOutputStream());
                        envia.writeObject(msg);
                    }
                    else{
                        deuErro(envia);
                    }
                break;
                case "Excluir":
                    if(excluir(msg.getPessoa())){
                        envia = new ObjectOutputStream(cSocket.getOutputStream());
                        envia.writeObject(msg);
                    }
                    else{
                        deuErro(envia);
                    }
                break;
                default:
                    deuErro(envia);
                break;
            }

            envia.close();
            recebe.close();
            cSocket.close();
                
        } catch (Exception ex) {
            System.err.println("erro:" + ex.getMessage());
        }
    }
    
    public boolean inserir(Pessoa p){
        try{
            synchronized(pessoas){
                pessoas.add(p);
            }
            System.out.println("LISTA APÓS CADASTRO:" + pessoas.toString());
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
    public boolean excluir(Pessoa pessoa){
        for(Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(pessoa.getNome())){
                synchronized(pessoas){
                    pessoas.remove(p);
                }
                return true;
            }
        }
        return false;
    }
    
    public Pessoa pesquisar(Pessoa pessoa){
        try{
            for(Pessoa p : pessoas){
                if(p.getNome().equalsIgnoreCase(pessoa.getNome())){
                    pessoa.setIdade(p.getIdade());
                    pessoa.setSexo(p.getSexo());
                    return pessoa;
                }
            }
            return new Pessoa("erro", 0, "erro");
        }
        catch(Exception ex){
            return new Pessoa("erro", 0, "erro");
        }
    }
     
     public Pessoa alterar(Pessoa pessoa){
        for(Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(pessoa.getNome())){
                synchronized(pessoas){
                    p.setIdade(pessoa.getIdade());
                    p.setSexo(pessoa.getSexo());
                }
                return pessoa;
            }
        }
        return new Pessoa("erro", 0, "erro");
    }
    
    public void deuErro(ObjectOutputStream envia){
        try{
            Mensagem deuErro = new Mensagem();
            deuErro.setPessoa(new Pessoa());
            deuErro.setAcao("Erro");

            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(deuErro);
        }
        catch (Exception ex) {
            System.err.println("erro:" + ex.getMessage());
        }
    }
}
