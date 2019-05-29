package mensagens;

public class MensagemNaoEncontradaException extends Exception {
    MensagemNaoEncontradaException() {
        super("Mensagem não encontrada");
    }
}
