package br.com.mangarosa.collections;

public class ListaEncadeada {
    private No cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void appendValue(Object value) {
        No novoNo = new No(value);
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    public void remove(int position) {
        if (position < 0 || position >= tamanho) return;
        if (position == 0) {
            cabeca = cabeca.getProx();
        } else {
            No atual = cabeca;
            for (int i = 0; i < position - 1; i++) {
                atual = atual.getProx();
            }
            atual.setProx(atual.getProx().getProx());
        }
        tamanho--;
    }

    public Object get(int position) {
        if (position < 0 || position >= tamanho) return null;
        No atual = cabeca;
        for (int i = 0; i < position; i++) {
            atual = atual.getProx();
        }
        return atual.getValor();
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }
}
