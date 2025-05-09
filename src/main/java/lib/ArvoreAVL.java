package lib;

import java.util.Comparator;

public class ArvoreAVL <T extends Comparable> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comp) {
        super(comp);

    }

    @Override
    protected NoArvore<T> adicionarRecursivo(NoArvore<T> atual, NoArvore<T> novoFilho) {
        raiz = super.adicionarRecursivo(atual, novoFilho);

        if (raiz.fatorBalanceamento() > 1) {
            if(raiz.getFilhoDireita().fatorBalanceamento()>0){
                raiz = this.rotacaoEsquerda(raiz);

            }
            else {
                raiz = this.rotacaoDireitaEsquerda(raiz);

            }
        } else if (raiz.fatorBalanceamento() < -1) {
            if (raiz.getFilhoDireita().fatorBalanceamento() < 0){
                raiz = this.rotacaoDireita(raiz);

            } else {
                raiz = this.rotacaoEsquerdaDireita(raiz);

            }
        }
        return raiz;
    }

    private NoArvore<T> rotacaoEsquerda(NoArvore<T> r) {
        NoArvore<T> f = r.getFilhoDireita();
        r.setFilhoDireita(f.getFilhoEsquerda());
        f.setFilhoEsquerda(r);

        return f;
    }

    private NoArvore<T> rotacaoDireita(NoArvore<T> r) {
        NoArvore<T> f = r.getFilhoEsquerda();
        r.setFilhoEsquerda(f.getFilhoDireita());
        f.setFilhoDireita(r);

        return f;
    }

    private NoArvore<T> rotacaoEsquerdaDireita(NoArvore<T> r) {
        r.setFilhoEsquerda(rotacaoEsquerda(r.getFilhoEsquerda()));

        return rotacaoDireita(r);
    }

    private NoArvore<T> rotacaoDireitaEsquerda(NoArvore<T> r) {
        r.setFilhoDireita(rotacaoDireita(r.getFilhoDireita()));

        return rotacaoEsquerda(r);
    }
}
