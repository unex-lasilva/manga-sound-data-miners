package br.com.mangarosa;

import br.com.mangarosa.collections.*;

import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada listasDeReproducao = new ListaEncadeada();
        ReprodutorLista reprodutor = new ReprodutorLista();

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar Lista de Reprodução");
            System.out.println("2. Listar Todas as Playlists");
            System.out.println("3. Adicionar Música à Lista");
            System.out.println("4. Listar Músicas de uma Playlist");
            System.out.println("5. Reproduzir Lista de Reprodução");
            System.out.println("6. Pausar Música");
            System.out.println("7. Continuar Música");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da lista: ");
                    String nomeLista = scanner.nextLine();
                    listasDeReproducao.appendValue(new ListaReproducao(nomeLista));
                    System.out.println("Lista '" + nomeLista + "' criada com sucesso!");
                    break;

                case 2:
                    if (listasDeReproducao.isEmpty()) {
                        System.out.println("Nenhuma lista de reprodução criada ainda.");
                    } else {
                        System.out.println("\nListas de Reprodução Disponíveis:");
                        for (int i = 0; i < listasDeReproducao.size(); i++) {
                            ListaReproducao lr = (ListaReproducao) listasDeReproducao.get(i);
                            System.out.println((i + 1) + ". " + lr.getTitulo() + " (" + lr.size() + " músicas)");
                        }
                    }
                    break;

                case 3:
                    if (listasDeReproducao.isEmpty()) {
                        System.out.println("Crie uma lista de reprodução primeiro.");
                        break;
                    }

                    System.out.println("\nSelecione a lista para adicionar a música:");
                    for (int i = 0; i < listasDeReproducao.size(); i++) {
                        ListaReproducao lr = (ListaReproducao) listasDeReproducao.get(i);
                        System.out.println((i + 1) + ". " + lr.getTitulo());
                    }
                    System.out.print("Escolha o número da lista: ");
                    int listaEscolhida = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (listaEscolhida < 0 || listaEscolhida >= listasDeReproducao.size()) {
                        System.out.println("Número de lista inválido.");
                        break;
                    }

                    System.out.print("Digite o nome da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Digite o caminho do arquivo: ");
                    String caminho = scanner.nextLine();

                    Musica musica = new Musica(titulo, artista, caminho);
                    ListaReproducao listaSelecionada = (ListaReproducao) listasDeReproducao.get(listaEscolhida);
                    listaSelecionada.adicionarMusica(musica);
                    System.out.println("Música adicionada com sucesso à lista '" + listaSelecionada.getTitulo() + "'!");
                    break;

                case 4:
                    if (listasDeReproducao.isEmpty()) {
                        System.out.println("Nenhuma lista de reprodução criada ainda.");
                        break;
                    }

                    System.out.println("\nSelecione a lista para ver as músicas:");
                    for (int i = 0; i < listasDeReproducao.size(); i++) {
                        ListaReproducao lr = (ListaReproducao) listasDeReproducao.get(i);
                        System.out.println((i + 1) + ". " + lr.getTitulo());
                    }
                    System.out.print("Escolha o número da lista: ");
                    int listaParaListar = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (listaParaListar < 0 || listaParaListar >= listasDeReproducao.size()) {
                        System.out.println("Número de lista inválido.");
                        break;
                    }

                    ListaReproducao listaExibir = (ListaReproducao) listasDeReproducao.get(listaParaListar);
                    listaExibir.listarMusicas();
                    break;

                case 5:
                    if (listasDeReproducao.isEmpty()) {
                        System.out.println("Nenhuma lista de reprodução criada ainda.");
                        break;
                    }

                    System.out.println("\nSelecione a lista para reproduzir:");
                    for (int i = 0; i < listasDeReproducao.size(); i++) {
                        ListaReproducao lr = (ListaReproducao) listasDeReproducao.get(i);
                        System.out.println((i + 1) + ". " + lr.getTitulo());
                    }
                    System.out.print("Escolha o número da lista: ");
                    int listaParaReproduzir = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (listaParaReproduzir < 0 || listaParaReproduzir >= listasDeReproducao.size()) {
                        System.out.println("Número de lista inválido.");
                        break;
                    }

                    ListaReproducao listaReproducao = (ListaReproducao) listasDeReproducao.get(listaParaReproduzir);
                    reprodutor.setListaReproducao(listaReproducao);
                    reprodutor.reproduzirLista();
                    break;

                case 6:git
                    reprodutor.pausar();
                    break;

                case 7:
                    reprodutor.continuarMusica();
                    break;

                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

