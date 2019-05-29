package mensagens;

public class IdentificacaoNaoEncontradaException extends Exception {
    IdentificacaoNaoEncontradaException() {
        super("Identificação não encontrada");
    }
}
