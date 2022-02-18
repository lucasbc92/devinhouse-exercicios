package org.senai.devinhouse.cloudgames.service;

import org.senai.devinhouse.cloudgames.model.Jogo;
import org.senai.devinhouse.cloudgames.model.Midia;
import org.senai.devinhouse.cloudgames.repository.JogoRepository;
import org.senai.devinhouse.cloudgames.repository.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class MidiaService {
    private boolean system = true;

    @Autowired
    private MidiaRepository midiaRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em midia deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");

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
                    visualizar();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o id da midia que quer atualizar");

        Long id = scanner.nextLong();
        Optional<Midia> midiaOptional = midiaRepository.findById(id);

        // early return
        if(midiaOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        scanner.nextLine();

        Midia midia = midiaOptional.get();
        salvarOuAtualizar(scanner, midia);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id da midia para deletar");
        Long id = scanner.nextLong();

        midiaRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Midia> midias = midiaRepository.findAll();
        midias.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        Midia midia = new Midia();
        scanner.nextLine();
        salvarOuAtualizar(scanner, midia);
    }

    private void salvarOuAtualizar(Scanner scanner, Midia midia) {
        System.out.println("Informe a URL:");
        midia.setUrl(scanner.nextLine());

        System.out.println("Informe o id do jogo:");
        Long idJogo = scanner.nextLong();

        Optional<Jogo> resultadoJogo = jogoRepository.findById(idJogo);

        if(resultadoJogo.isEmpty()){
            System.out.println("Jogo inválido");
            return;
        }

        Jogo jogo = resultadoJogo.get();
        midia.setJogo(jogo);

        midiaRepository.save(midia);
    }
}
