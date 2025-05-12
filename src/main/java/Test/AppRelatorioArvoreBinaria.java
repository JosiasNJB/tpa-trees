/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import Model.Jogo;
import Model.Comparadores.*;
import Model.Geradores.*;

//Ajuste esse importe para que importe sua classe de Árvore binária
import lib.ArvoreBinaria;
import lib.IArvoreBinaria;
/**
 *
 * @author victoriocarvalho
 *
 * Classe principal do aplicativo a ser utilizado para fazer o relatório do trabalho 
 * de árvore binária
 */
public class AppRelatorioArvoreBinaria {
    public static void main(String[] args) {
        //Instancio o meu gerador de árvores (que também foi fornecido)
        GeradorDeArvores gerador = new GeradorDeArvores();
        //Instancio um comparador de jogos por matricula (também fornecido)
        ComparadorJogoPorIdJogo compPorIdJogo = new ComparadorJogoPorIdJogo();
        ComparadorJogoPorTitulo compPorTitulo = new ComparadorJogoPorTitulo();
        IArvoreBinaria<Jogo> arv;


//------Início do trecho a ser considerado nas questões 1, 2 e 3 do relatório-------------------------------
        //Instancio uma árvore binária. Lembre de ajustar o import para sua classe de árvore binária
        arv = new ArvoreBinaria(compPorIdJogo);
        //Chamo o gerador para inserir 100 elementos nessa árvore de forma que fique degenerada
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore Degenerada Criada");
        //Imprimo a quantidade de nós e a altura da árvore resultante
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvoreDegenerada(200, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
//------Fim do trecho citado nas questões 1, 2 e 3 do relatório-------------------------------

//------Início do trecho citado nas questões 5, 6 e 7 do relatório-------------------------------
        arv = new ArvoreBinaria(compPorIdJogo);
        //Chamo o gerador para inserir 100 elementos nessa árvore de forma que ela fique perfeitamente balanceada
        gerador.geraArvorePerfeitamenteBalanceada(1,100,arv);
        System.out.println("Árvore Perfeitamente Balanceada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvorePerfeitamenteBalanceada(1,200,arv);
        System.out.println("Árvore Perfeitamente Balanceada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvorePerfeitamenteBalanceada(1,1000,arv);
        System.out.println("Árvore Perfeitamente Balanceada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
//------Fim do trecho citado nas questões 5, 6 e 7 do relatório-------------------------------

//------Início do trecho citado na questão 9 do relatório-------------------------------
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvorePerfeitamenteBalanceada(1,100,arv);
        System.out.println("Árvore Perfeitamente Balanceada Criada");
        //Vou fazer uma busca pela chave de busca da árvore, ou seja, matrícula
        Jogo busca = arv.pesquisar(new Jogo(2000000001,""));
        if (busca == null)
            System.out.println("Jogo não encontrado");
        else
            System.out.println("Jogo encontrado: "+busca);
        //Vou fazer uma busca por nome
        busca = arv.pesquisar(new Jogo(0,"Pedro"), compPorTitulo);
        if (busca == null)
            System.out.println("Jogo não encontrado");
        else
            System.out.println("Jogo encontrado: "+busca);
//------Fim do trecho citado na questão 9 do relatório-------------------------------


//------Início do trecho citado na questão 10 do relatório-------------------------------
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvorePerfeitamenteBalanceada(1,50000,arv);
        System.out.println("Árvore Perfeitamente Balanceada Criada");
        System.out.println("Altura: " + arv.altura());
        arv = new ArvoreBinaria(compPorIdJogo);
        gerador.geraArvoreDegenerada(50000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println(" Altura: " + arv.altura());
//------Fim do trecho citado na questão 10 do relatório-------------------------------
    }
}