package br.com.mangarosa.collections;

import javax.sound.sampled.*;
import java.io.*;

public class ReprodutorLista {
        private ListaReproducao listaReproducao;
        private Clip clip;
        private int musicaAtual;

        public ReprodutorLista() {
            this.musicaAtual = 0;
        }

        public void setListaReproducao(ListaReproducao listaReproducao) {
            this.listaReproducao = listaReproducao;
            this.musicaAtual = 0;
        }

        public void reproduzirLista() {
            if (listaReproducao == null || listaReproducao.ehVazia()) {
                System.out.println("Nenhuma lista selecionada ou lista vazia.");
                return;
            }
            tocarMusica(musicaAtual);
        }

        private void tocarMusica(int index) {
            Musica musica = listaReproducao.get(index);
            try {
                File arquivo = new File(musica.getPath());
                if (!arquivo.exists()) {
                    System.out.println("Arquivo não encontrado: " + musica.getPath());
                    return;
                }
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(arquivo);
                if (clip != null && clip.isOpen()) {
                    clip.close();
                }
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                System.out.println("Reproduzindo: " + musica);
            } catch (Exception e) {
                System.out.println("Erro ao tentar reproduzir a música: " + e.getMessage());
            }
        }

        public void pausar() {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                System.out.println("Música pausada.");
            } else {
                System.out.println("Nenhuma música em reprodução para pausar.");
            }
        }

        public void continuarMusica() {
            if (clip != null && !clip.isRunning()) {
                clip.start();
                System.out.println("Música retomada.");
            } else {
                System.out.println("Nenhuma música pausada para continuar.");
            }
        }
    }
