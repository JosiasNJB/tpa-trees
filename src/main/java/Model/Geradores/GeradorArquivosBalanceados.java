package Model.Geradores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.ArrayList;

public class GeradorArquivosBalanceados {
    private static final int NUM_REGISTROS = 10; // Quantidade de registros a serem gerados
    private static final String NOME_ARQUIVO = "jogosBalanceados.txt";

    private static final String[] primeiraParte = {
    "Sombras", "Coração", "Segredo", "Luz", "Guerreiro",
    "Anjo", "Filho", "Destino", "Caçador", "Mistério",
    "Reino", "Olhos", "Chamas", "Tempestade", "Alma",
    "Ouro", "Espelho", "Vingança", "Vento", "Sangue",
    "Eco", "Promessa", "Julgamento", "Viagem", "Grito",
    "Memória", "Muralha", "Caminho", "Fera", "Espada",
    "Fronteira", "Portal", "Segredos", "Voz", "Flor",
    "Círculo", "Guardião", "Último", "Cavaleiro", "Prelúdio",
    "Códigos", "Caverna", "Conspiração", "Refúgio", "Vigília",
    "Mestre", "Som", "Vozes", "Ordem", "Profecia"
};


    private static final String[] segundaParte = {
    "da Noite", "de Fogo", "do Silêncio", "do Medo", "Perdido",
    "de Sombras", "do Amanhã", "do Tempo", "do Abismo", "da Guerra",
    "Sem Nome", "de Sangue", "do Infinito", "de Gelo", "do Destino",
    "do Mar", "Eterno", "do Vazio", "Imortal", "do Pecado",
    "da Verdade", "Final", "da Memória", "da Escuridão", "de Prata",
    "da Tempestade", "da Luz", "de Ferro", "do Esquecimento", "da Traição",
    "de Cinzas", "da Promessa", "do Trovão", "da Eternidade", "do Caos",
    "da Salvação", "de Ouro", "do Julgamento", "do Submundo", "de Areia",
    "do Coração", "do Labirinto", "da Resistência", "da Ira", "da Morte",
    "do Labirinto", "do Outro Lado", "de Sombras Antigas", "da Origem", "das Lendas"
};

    public static void main(String[] args) {
        gerarArquivo();
    }

    private static void gerarArquivo() {
        Random random = new Random();
        ArrayList<Integer> ids = new ArrayList<>();
        gerarIdentificadoresBalanceados(ids, 1, NUM_REGISTROS);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, StandardCharsets.UTF_8))) {
            writer.write(NUM_REGISTROS + "\n");

            for (int i = 0; i < NUM_REGISTROS; i++) {
                int id = ids.get(i);
                String nome = gerarNomeAleatorio(random);
                float nota = random.nextFloat() * 10; // Gera uma nota entre 0 e 10
                writer.write(id + ";" + nome + ";" + String.format("%.2f", nota).replace(',', '.') + "\n");

                if ((i + 1) % 1_000_000 == 0) {
                    System.out.println((i + 1) + " registros gerados...");
                }
            }

            System.out.println("Arquivo gerado com sucesso: " + NOME_ARQUIVO);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private static void gerarIdentificadoresBalanceados(ArrayList<Integer> ids, int inicio, int fim) {
        if (inicio > fim) return;
        int meio = (inicio + fim) / 2;
        ids.add(meio);
        gerarIdentificadoresBalanceados(ids, inicio, meio - 1);
        gerarIdentificadoresBalanceados(ids, meio + 1, fim);
    }

    private static String gerarNomeAleatorio(Random random) {
        String primeiroNome = primeiraParte[random.nextInt(primeiraParte.length)];
        String sobrenome = segundaParte[random.nextInt(segundaParte.length)];
        return primeiroNome + " " + sobrenome;
    }
}