/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author victoriocarvalho
 */
public class NoArvore<T> {

    private T valor;
    private NoArvore<T> filhoDireita;
    private NoArvore<T> filhoEsquerda;


    public NoArvore(T valor){
        this.valor = valor;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
    }

    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the filhoDireita
     */
    public NoArvore<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(NoArvore<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    /**
     * @return the filhoEsquerda
     */
    public NoArvore<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(NoArvore<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public int calcularAltura(NoArvore<T> no){
        if (no == null) {
            return -1; // Altura de uma árvore vazia é -1
        } else {
            int alturaEsquerda = calcularAltura(no.getFilhoEsquerda());
            int alturaDireita = calcularAltura(no.getFilhoDireita());
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getFilhoEsquerda()) + contarNos(no.getFilhoDireita());
    }

    public int fatorBalanceamento() {
        return calcularAltura(this.filhoDireita) - calcularAltura(this.filhoEsquerda);
    }

}
