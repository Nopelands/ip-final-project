package mensagens;

public class MensagemNaoEncontradaException extends Exception {
    public MensagemNaoEncontradaException() {
        super("Mensagem não encontrada");
    }
}
