package org.senai.devinhouse.cloudgames.service;

import org.senai.devinhouse.cloudgames.model.*;
import org.senai.devinhouse.cloudgames.repository.JogoPlataformaRepository;
import org.senai.devinhouse.cloudgames.repository.JogoRepository;
import org.senai.devinhouse.cloudgames.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

@Service
public class JogoService {
    private boolean system = true;

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;

    @Autowired
    private JogoPlataformaRepository jogoPlataformaRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em jogo deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Buscar por genero");
            System.out.println("6 - Adicionar plataforma a jogo");

            int action = scanner.nextInt();

            switch (action) {
                case 1 :
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3 :
                    deletar(scanner);
                    break;
                case 4:
                    visualizar(scanner);
                    break;
                case 5:
                    buscarPorGenero(scanner);
                    break;
                case 6:
                    adicionarPlataforma(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void adicionarPlataforma(Scanner scanner) {
        System.out.println("Informe o id do jogo");

        Long idJogo = scanner.nextLong();

        Optional<Jogo> jogoOptional = jogoRepository.findById(idJogo);

        // early return
        if(jogoOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        System.out.println("Informe o id da plataforma");

        Long idPlataforma = scanner.nextLong();

        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(idPlataforma);

        // early return
        if(plataformaOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        Jogo jogo = jogoOptional.get();
        Plataforma plataforma = plataformaOptional.get();

        LocalDate dataLancamento;

        scanner.nextLine();
        try {
            System.out.println("Informe a data de lançamento no formato dd/mm/yyyy:");
            String dateString = scanner.nextLine();
            String[] dateStringSplit = dateString.split("/");
            dataLancamento = LocalDate.of(
                    Integer.parseInt(dateStringSplit[2]),
                    Integer.parseInt(dateStringSplit[1]),
                    Integer.parseInt(dateStringSplit[0])
            );
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Data no formato incorreto.");
            return;
        }

        JogoPlataforma jogoPlataforma = new JogoPlataforma(jogo, plataforma);
        jogoPlataforma.setDataLancamento(dataLancamento);

        jogoPlataformaRepository.save(jogoPlataforma);
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o id do jogo que quer atualizar");

        Long id = scanner.nextLong();
        Optional<Jogo> jogoOptional = jogoRepository.findById(id);

        // early return
        if(jogoOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        scanner.nextLine();

        Jogo jogo = jogoOptional.get();
        salvarOuAtualizar(scanner, jogo);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id do jogo para deletar");
        Long id = scanner.nextLong();

        jogoRepository.deleteById(id);
    }

    private void visualizar(Scanner scanner) {
        System.out.println("Qual página deseja visualizar?");
        int pagina = scanner.nextInt();

        PageRequest pageRequest = PageRequest.of(pagina-1, 5, Sort.by("nome"));
//        Page<Jogo> resultado = jogoRepository.search(pageRequest);
//        System.out.println("Total de elementos: " + resultado.getTotalElements());
//        System.out.println("Total de páginas: " + resultado.getTotalPages());
//        resultado.get().forEach(System.out::println);
        List<Jogo> jogos = jogoRepository.findAllWithCapaAndPlataformas();
        jogos.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        Jogo jogo = new Jogo();
        scanner.nextLine();
        salvarOuAtualizar(scanner, jogo);
    }

    private void salvarOuAtualizar(Scanner scanner, Jogo jogo) {
        System.out.println("Informe o nome:");
        jogo.setNome(scanner.nextLine());

        try {
            System.out.println("Informe o genero:");
            jogo.setGenero(Genero.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT)));
        } catch(IllegalArgumentException e){
            System.out.println("Genero inválido.");
            return;
        }

        jogoRepository.save(jogo);
    }

    private void buscarPorGenero(Scanner scanner) {
        System.out.println("Digite o genero que deseja pesquisar:");
        try {
            List<Jogo> jogos = jogoRepository.findByGenero(Genero.valueOf(scanner.next().toUpperCase(Locale.ROOT)));
            jogos.forEach(System.out::println);
        } catch(Exception e){
            System.out.println("Genero inválido");
        }
    }
}
