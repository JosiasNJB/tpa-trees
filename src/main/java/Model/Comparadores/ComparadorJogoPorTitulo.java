package Model.Comparadores;

import java.util.Comparator;

import Model.Jogo;

/**
 *
 * @author victoriocarvalho
 *
 * Essa é comparadora de alunos por nome que será utilizada para criar as árvores
 * nos programas de teste para redigir os relatórios.
 */

public class ComparadorJogoPorTitulo implements Comparator<Jogo> {

    @Override
    public int compare(Jogo j1, Jogo j2) {
        return j1.getTitulo().compareToIgnoreCase(j2.getTitulo());
    }

}