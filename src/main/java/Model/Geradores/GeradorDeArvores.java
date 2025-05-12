/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Geradores;

import Model.Jogo;

import java.util.Random;
//Ajuste este import para que sua classe de Arvore Binária seja importada
import lib.ArvoreBinaria;
//Aqui estou importando a interface IArvoreBinaria, a mesma que sua classe de Árvore Binaria deve implementar
import lib.IArvoreBinaria;

/**
 *
 * @author victoriocarvalho
 *
 * Esta classe é utilizada nos programas de teste para gerar árvores balanceadas ou degeneradas
 */
public class GeradorDeArvores {

    final char vogais[] = {'a', 'e', 'i', 'o','u','A','E','I','O','U'};
    final Random rand = new Random();
    final int idJogoBase = 2000000000;

    /**
     * Método que verifica se um caracter é vogal
     * @param c - caracter a ser verificado
     * @return true se for vogal e false caso contrário
     */
    private boolean ehVogal (char c){
        for (char l: vogais){
            if (l==c) return true;
        }
        return false;
    }


    /**
     * Método que gera uma vogal aleatoriamente
     * @param min - true se for para gerar vogal minúscula e false se for para gerar maiúscula
     * @return uma vogal
     */
    private char geraVogal(boolean min){
        if (min)
            return vogais[rand.nextInt(5)];
        else
            return vogais[5+rand.nextInt(5)];
    }

    /**
     * Método que gera uma letra aleatoriamente
     * @param min - true se for para gerar letra minúscula e false se for para gerar maiúscula
     * @return uma letra
     */
    private char geraLetra(boolean min){
        if (min)
            return (char) ('a'+rand.nextInt(26));
        else
            return (char) ('A'+rand.nextInt(26));
    }

    /**
     * Método que gera uma palavra aleatoriamente
     * @param tam - quantidade de caracteres da palavra a ser gerada
     * @return uma palavra com tam caracteres, iniciada por uma letra maiúscula
     */

    private String geraPalavra(int tam){
        int cont;
        String palavra = "";

        palavra+= geraLetra(false);
        for(cont=1;cont<tam;cont++){
            //Com esse if garanto que a palavra não terá duas consoantes seguidas
            if (ehVogal(palavra.charAt(cont-1)))
                palavra+=geraLetra(true);
            else
                palavra+=geraVogal(true);
        }
        return palavra;
    }

    /**
     * Método que gera um "titulo completo" de jogo (com titulo e sobretitulo) aleatoriamente
     *
     * @return uma string contendo duas palavras aleatorias de pelo menos 3 caracteres cada.
     * A ideia é simular o titulo e o sobretitulo do jogo.
     */

    private String geraTituloCompleto(){
        String titulo="";
        titulo+= geraPalavra(3+rand.nextInt(6));
        titulo+=" ";
        titulo+= geraPalavra(3+rand.nextInt(6));
        return titulo;
    }

    /**
     * Método que gera uma árvore degenerada com n elementos
     * @param n - quantidade de elementos a inserir na árvore
     * @param arv - árvore na qual os elementos serão inseridos
     */

//---Este é o método citado na questão 4 do primeiro relatório
    public void geraArvoreDegenerada(int n, IArvoreBinaria<Jogo> arv){
        //inicio idJogo com o valor da constante idJogo
        int i, idJogo = idJogoBase;
        String titulo;
        for(i=1;i<=n;i++){
            //Cada vez que entra a idJogo é incrementada em 1.
            idJogo++;
            titulo = geraTituloCompleto();
            //Aqui crio um jogo com os dados gerados e o adiciono na árvore.
            arv.adicionar(new Jogo(idJogo, titulo));
        }
    }

    /**
     * Método que gera uma árvore perfeitamente balanceada com n elementos
     * @param min - valor a ser adicionado na idJogo base para gerar a menor idJogo
     * @param max - valor a ser adicionado na idJogo base para gerar a maior idJogo
     * @param arv - árvore na qual os elementos serão inseridos
     */

//---Este é o método citado na questão 8 do primeiro relatório
    public void geraArvorePerfeitamenteBalanceada(int min, int max, IArvoreBinaria<Jogo> arv){
        //Se o valor da menor idJogo for menor ou igual ou maior valor é sinal que ainda preciso inserir elementos na árvore
        //Senão essa recursão acabou...
        if (min <= max){
            //Calculo a idJogo média desta geração e insiro um jogo com essa idJogo na árvore
            int media = (min+max)/2;
            int idJogo = idJogoBase+media;
            String titulo = geraTituloCompleto();
            arv.adicionar(new Jogo(idJogo, titulo));
            //Chamo recursivamente para continuar inserindo os elementos com idJogos menores que a média
            geraArvorePerfeitamenteBalanceada(min,media-1,arv);
            //Chamo recursivamente para continuar inserindo os elementos com idJogos maiores que a média
            geraArvorePerfeitamenteBalanceada(media+1,max,arv);
        }
    }

}