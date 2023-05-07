package kreis.aula;

public class Client {
	private String CPF;
    private String Nome;
    private int Idade;
    private double LimiteCredito;
   
    public Client(String cpf, String nome, int idade, double limiteCredito) {
        this.CPF = cpf;
        this.Nome = nome;
        this.Idade = idade;
        this.LimiteCredito = limiteCredito;
    }
   
    public String getCPF() {
        return this.CPF;
    }
   
    public String getNome() {
        return this.Nome;
    }
   
    public int getIdade() {
        return this.Idade;
    }
   
    public double getLimiteCredito() {
        return this.LimiteCredito;
    }
}


