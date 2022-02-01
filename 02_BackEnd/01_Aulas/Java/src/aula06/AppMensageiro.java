package aula06;

import java.util.ArrayList;
import java.util.List;

import aula06.mensageiro.entidades.Conversa;
import aula06.mensageiro.entidades.Mensagem;
import aula06.mensageiro.entidades.Pessoa;

public class AppMensageiro {
    public static void main(String[] args) throws Exception {
        Pessoa user1 = new Pessoa("user1");
        Pessoa user2 = new Pessoa("user2");
        Pessoa user3 = new Pessoa("user3");

        List<Pessoa> participantesDaConversa = new ArrayList<Pessoa>();

        participantesDaConversa.add(user1);
        participantesDaConversa.add(user2);

        Conversa conversa = new Conversa(participantesDaConversa);

        conversa.enviarMensagem(user1, "Hello!");
        conversa.enviarMensagem(user2, "Hola!");

        conversa.addPessoa(user3);
        conversa.enviarMensagem(user3, "Entrei!");

        for(Mensagem mensagem : conversa.getTimeline()) {
            System.out.println(mensagem);
        }
        
        List<Pessoa> participanteDaConversa = new ArrayList<Pessoa>();
        participanteDaConversa.add(user1);

        Conversa conversaPrivada = new Conversa(participanteDaConversa);
        conversaPrivada.enviarMensagem(user1, "Teste");

        conversa.addPessoa(user2);

        for(Mensagem mensagem : conversaPrivada.getTimeline()) {
            System.out.println(mensagem);
        } 




        



    }
}
