package org.senai.devinhouse.cloudgames.service;

import org.senai.devinhouse.cloudgames.model.Genero;
import org.senai.devinhouse.cloudgames.model.Jogo;
import org.senai.devinhouse.cloudgames.model.Usuario;
import org.senai.devinhouse.cloudgames.repository.JogoRepository;
import org.senai.devinhouse.cloudgames.repository.UsuarioRepository;
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

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em jogo deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Buscar por genero");

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
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscarPorGenero(Scanner scanner) {
        System.out.println("Digite o genero que deseja pesquisar:");
        try {
            List<Jogo> jogos = jogoRepository.findByGenero(Genero.valueOf(scanner.next().toUpperCase(Locale.ROOT)).name());
            jogos.forEach(System.out::println);
        } catch(Exception e){
            System.out.println("Genero inválido");
        }
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
        Page<Jogo> resultado = jogoRepository.findAll(pageRequest);
        System.out.println("Total de elementos: " + resultado.getTotalElements());
        System.out.println("Total de páginas: " + resultado.getTotalPages());
        resultado.get().forEach(System.out::println);
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
}
