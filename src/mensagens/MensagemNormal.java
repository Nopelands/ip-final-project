package mensagens;

public class MensagemNormal extends Mensagem {
    public MensagemNormal(String remetente, String mensagem){
        super(remetente, mensagem);
    }
    public void novamensagem (String mensagem){
        this.mensagem = mensagem;
    }
}
