package org.senai.devinhouse.cloudgames.service;

import org.senai.devinhouse.cloudgames.model.Plataforma;
import org.senai.devinhouse.cloudgames.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@Service
public class PlataformaService {
    private boolean system = true;

    @Autowired
    private PlataformaRepository plataformaRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em plataforma deseja executar");
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
        System.out.println("Informe o id da plataforma que quer atualizar");

        Long id = scanner.nextLong();
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);

        // early return
        if(plataformaOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        scanner.nextLine();

        Plataforma plataforma = plataformaOptional.get();
        salvarOuAtualizar(scanner, plataforma);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id da plataforma para deletar");
        Long id = scanner.nextLong();

        plataformaRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Plataforma> plataformas = plataformaRepository.findAll();
        plataformas.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        Plataforma plataforma = new Plataforma();
        scanner.nextLine();
        salvarOuAtualizar(scanner, plataforma);
    }

    private void salvarOuAtualizar(Scanner scanner, Plataforma plataforma) {
        System.out.println("Informe o nome:");
        plataforma.setNome(scanner.nextLine());

        plataformaRepository.save(plataforma);
    }
}
