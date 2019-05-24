package mensagens;

public class MensagemNaoEncontradaException extends Exception{
    MensagemNaoEncontradaException() {
        super("Mensagem nao encontrada");
    }
}
