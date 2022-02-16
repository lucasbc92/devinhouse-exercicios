package org.senai.devinhouse.cloudgames.service;

import org.senai.devinhouse.cloudgames.model.Usuario;
import org.senai.devinhouse.cloudgames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UsuarioService {
    private boolean system = true;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em usuario deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Buscar por nome");
            System.out.println("6 - Buscar por email");

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
                    buscarPorNome(scanner);
                    break;
                case 6:
                    buscarPorEmail(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscarPorNome(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite o nome a ser pesquisado:");
        String str = scanner.nextLine();
        System.out.println(str);
        List<Usuario> usuarios = usuarioRepository.findByNomeContaining(str);

        usuarios.forEach(System.out::println);
    }

    private void buscarPorEmail(Scanner scanner) {
        System.out.println("Digite o email a ser pesquisado:");
        List<Usuario> usuarios = usuarioRepository.findByEmail(scanner.next());

        usuarios.forEach(System.out::println);
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o id do usuario que quer atualizar");

        Long id = scanner.nextLong();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        // early return
        if(usuarioOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        scanner.nextLine();

        Usuario usuario = usuarioOptional.get();
        salvarOuAtualizar(scanner, usuario);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id do usuario para deletar");
        Long id = scanner.nextLong();

        usuarioRepository.deleteById(id);
    }

    private void visualizar(Scanner scanner) {
        System.out.println("Qual página deseja visualizar?");
        int pagina = scanner.nextInt();

        PageRequest pageRequest = PageRequest.of(pagina-1, 5, Sort.by("nome"));
        Page<Usuario> resultado = usuarioRepository.findAll(pageRequest);
        System.out.println("Total de elementos: " + resultado.getTotalElements());
        System.out.println("Total de páginas: " + resultado.getTotalPages());
        resultado.get().forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        Usuario usuario = new Usuario();
        scanner.nextLine();
        salvarOuAtualizar(scanner, usuario);
    }

    private void salvarOuAtualizar(Scanner scanner, Usuario usuario) {
        System.out.println("Informe o nome:");
        usuario.setNome(scanner.nextLine());

        System.out.println("Informe a senha:");
        usuario.setSenha(scanner.nextLine());

        System.out.println("Informe o email:");
        usuario.setEmail(scanner.nextLine());

        try {
            System.out.println("Informe a data de nascimento no formato dd/mm/yyyy:");
            String dateString = scanner.nextLine();
            String[] dateStringSplit = dateString.split("/");
            usuario.setDataNascimento(LocalDate.of(
                    Integer.parseInt(dateStringSplit[2]),
                    Integer.parseInt(dateStringSplit[1]),
                    Integer.parseInt(dateStringSplit[0])
            ));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Data no formato incorreto.");
            return;
        }

        System.out.println("Informe o CPF (somente números):");
        String cpf = scanner.nextLine();
        if(cpf.length() != 11){
            System.out.println("CPF inválido.");
            return;
        }
        usuario.setCpf(cpf);

        System.out.println("Informe o RG (somente números)11:");
        usuario.setRg(scanner.nextLine());

        usuarioRepository.save(usuario);
    }


}
