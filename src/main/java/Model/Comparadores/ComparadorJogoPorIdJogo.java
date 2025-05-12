package Model.Comparadores;

import java.util.Comparator;

import Model.Jogo;

/**
 *
 * @author victoriocarvalho
 *
 * Essa é comparadora de alunos por matrícula que será utilizada para criar as árvores
 * nos programas de teste para redigir os relatórios.
 */

public class ComparadorJogoPorIdJogo implements Comparator<Jogo> {
    /*O nosso comparador utiliza o método compare da classe integer para comparar as matrículas de 2 alunos
     *Eu poderia ter feito um if para vrificar qual matrícula é maior e retornar 1, -1 ou 0...
     */
    @Override
    public int compare(Jogo j1, Jogo j2) {
        return Integer.compare(j1.getId(), j2.getId());
    }

}