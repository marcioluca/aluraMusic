package com.musicas.aluraMusic.principal;

import com.musicas.aluraMusic.model.Artista;
import com.musicas.aluraMusic.model.Genero;
import com.musicas.aluraMusic.model.Musica;
import com.musicas.aluraMusic.repository.ArtistaRepository;
import com.musicas.aluraMusic.service.ConsultaGermini;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final Scanner leitor = new Scanner(System.in);
    private final ArtistaRepository repository;

    public Main(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void Menu() {
        int opcao = -1;
        while(opcao != 0) {
            exibirMenu();
            System.out.print("Digite aqui sua opção: ");
            opcao = leitor.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Aplicação Encerrada...");
                    break;
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 5:
                    consultarDadosDoArtista();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }

    private void consultarDadosDoArtista() {
        leitor.nextLine();
        System.out.println("Qual artista deseja consultar os dados?");
        var nome = leitor.nextLine();
        var resposta = ConsultaGermini.obterInformacao(nome);
        System.out.println(resposta.trim());
    }

    private void buscarMusicasPorArtistas() {
        leitor.nextLine();
        System.out.println("Qual artista deseja exibir as músicas?");
        var nome = leitor.nextLine();
        List<Musica> musicas = repository.buscaMusicasPorArtista(nome);
        musicas.forEach(System.out::println);

    }
    private void listarMusicas() {
        List<Artista> artistas = repository.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }
    private void cadastrarMusica() {
        System.out.println("Qual artista deseja cadastrar as músicas? ");
        leitor.nextLine();
        var artistaNome = leitor.nextLine();
        Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(artistaNome);
        if (artista.isPresent()) {
            System.out.println("Qual musica deseja cadastrar?");
            var nomeMusica = leitor.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repository.save(artista.get());

        } else {
            System.out.println("Artista não encontrado!");
        }
    }

    private void cadastrarArtista() {
        boolean novoCadastro = true;
        while (novoCadastro) {
            leitor.nextLine();
            System.out.println("Qual artista deseja cadastrar?");
            var nomeArtista = leitor.nextLine();
            System.out.println("A qual genêro " + nomeArtista + " faz parte?");
            var generoMusical = leitor.nextLine();
            Genero genero = Genero.valueOf(generoMusical.toUpperCase());
            Artista artista = new Artista(nomeArtista, genero);
            repository.save(artista);
            System.out.println("Cadastro feito com sucesso! Deseja cadastrar outro Artista? S/N");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                novoCadastro = false;
            }
        }

    }
    public void exibirMenu() {
        System.out.println("""
                *** ALURA MUSIC ***
                
                1 - cadastrar artista
                2 - cadastrar música
                3 - listar músicas
                4 - pesquisar música por artista
                5 - consultar dados do artista
                
                0 - sair do sistema
                """);
    }
}
