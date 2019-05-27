package mensagens;

public class MensagemNormal extends Mensagem {
    public MensagemNormal(String mensagem, MensagensRepositorio mensagens){
        super(mensagem, mensagens);
    }
    public void enviar(String mensagem){
        mensagens.inserir(mensagem);
    }
}
