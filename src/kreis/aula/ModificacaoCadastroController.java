package kreis.aula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModificacaoCadastroController {
    private final String path = "C:\\TEMP\\";
   
    private void novoArquivo(List<Client> lista, String nomeArquivo) {
        File file = new File(path + nomeArquivo);
        int contador = 0;
        StringBuffer buffer = new StringBuffer();
       
        for (Client cliente : lista) {
            String linha = cliente.getCPF() + ";" + cliente.getNome() + ";" + cliente.getIdade() + ";" + cliente.getLimiteCredito() + ";\n";
            buffer.append(linha);
            contador++;
        }
       
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(buffer.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
   
    public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito) {
        String nomeArquivo = "Idade " + idadeMax + " limite " + limiteCredito + ".csv";
        List<Client> lista = new ArrayList<Client>();
       
        try {
            File file = new File(path + "cadastro.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
           
            String linha = "";
           
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                String cpf = campos[0];
                String nome = campos[1];
                int idade = Integer.parseInt(campos[2]);
                double limite = Double.parseDouble(campos[3].replace(",", "."));
               
                if (idade >= idadeMin && idade <= idadeMax && limite > limiteCredito) {
                    Client cliente = new Client(cpf, nome, idade, limite);
                    lista.add(cliente);
                }
            }
           
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
       
        this.novoArquivo(lista, nomeArquivo);
    }
}
