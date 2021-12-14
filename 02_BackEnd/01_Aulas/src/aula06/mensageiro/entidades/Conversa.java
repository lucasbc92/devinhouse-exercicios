package aula06.mensageiro.entidades;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private List<Mensagem> timeline = new ArrayList<Mensagem>();
    private List<Pessoa> participantes;

    public Conversa(List<Pessoa> participantes) throws Exception{
        if(participantes.size() == 0) {
            throw new Exception("Uma conversa precisa ter ao menos um participante.");
        }
        this.participantes = participantes;
    }

    private boolean isConversaPrivada(){
        return participantes.size() == 1;
    }

    public List<Mensagem> getTimeline(){
        return this.timeline;
    }

    public void addPessoa(Pessoa participante){
        if(!this.isConversaPrivada()) {
            System.out.println("Você não pode adicionar participantes a uma conversa privada.");
        } else {
            this.participantes.add(participante);
        }
    }

    public void enviarMensagem(Mensagem mensagem) {
        this.timeline.add(mensagem);
        System.out.println(mensagem);
    }

    public void enviarMensagem(Pessoa remetente, String corpo) {        
        Mensagem mensagem = new Mensagem(remetente, corpo);
        this.timeline.add(mensagem);
    }
}
