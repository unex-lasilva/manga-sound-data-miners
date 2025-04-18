package br.com.mangarosa.collections;

public class ListaReproducao{
    private String titulo;
    private ListaEncadeada lista;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada();
    }

    public void adicionarMusica(Musica musica) {
        lista.appendValue(musica);
    }

    public void removerMusica(int posicao) {
        lista.remove(posicao);
    }

    public boolean ehVazia() {
        return lista.isEmpty();
    }

    public String getTitulo() {
        return titulo;
    }

    public int size() {
        return lista.size();
    }

    public Musica get(int index) {
        return (Musica) lista.get(index);
    }

    public void listarMusicas() {
        System.out.println("\nMúsicas na lista '" + titulo + "':");
        for (int i = 0; i < size(); i++) {
            System.out.println((i + 1) + ". " + get(i));
        }
    }
}
