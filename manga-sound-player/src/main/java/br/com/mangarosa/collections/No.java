package br.com.mangarosa.collections;

public class No {
    private Object valor;
    private No prox;

    // Construtor da classe
    public No(Object valor) {
        this.valor = valor;
        this.prox = null;
    }

    // Getter para o valor do nó
    public Object getValor() {
        return valor;
    }

    // Setter para o valor do nó
    public void setValor(Object valor) {
        this.valor = valor;
    }

    // Getter para o próximo nó
    public No getProx() {
        return prox;
    }

    // Setter para o próximo nó
    public void setProx(No prox) {
        this.prox = prox;
    }
}
