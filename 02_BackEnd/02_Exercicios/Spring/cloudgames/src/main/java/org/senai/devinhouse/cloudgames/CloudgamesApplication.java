package org.senai.devinhouse.cloudgames;

import org.senai.devinhouse.cloudgames.service.JogoService;
import org.senai.devinhouse.cloudgames.service.MidiaService;
import org.senai.devinhouse.cloudgames.service.PlataformaService;
import org.senai.devinhouse.cloudgames.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CloudgamesApplication implements CommandLineRunner {

    private final UsuarioService usuarioService;
    private final JogoService jogoService;
    private final PlataformaService plataformaService;
    private final MidiaService midiaService;
    private boolean system = true;

    public CloudgamesApplication(UsuarioService usuarioService, JogoService jogoService, PlataformaService plataformaService, MidiaService midiaService) {
        this.usuarioService = usuarioService;
        this.jogoService = jogoService;
        this.plataformaService = plataformaService;
        this.midiaService = midiaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudgamesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while(system) {
            System.out.println("Qual a função que você deseja acessar");
            System.out.println("0 - Sair");
            System.out.println("1 - Usuário");
            System.out.println("2 - Jogo");
            System.out.println("3 - Plataforma");
            System.out.println("4 - Midia");

            Integer function = scanner.nextInt();

            switch (function) {
                case 1:
                    usuarioService.inicial(scanner);
                    break;
                case 2:
                    jogoService.inicial(scanner);
                    break;
                case 3:
                    plataformaService.inicial(scanner);
                    break;
                case 4:
                    midiaService.inicial(scanner);
                    break;
                default:
                    System.out.println("Finalizando");
                    system = false;
                    break;
            }
        }
    }
}
