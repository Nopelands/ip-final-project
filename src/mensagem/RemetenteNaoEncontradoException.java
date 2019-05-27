package mensagens;

public class RemetenteNaoEncontradoException extends Exception {
    RemetenteNaoEncontradoException() {
        super ("Remetente não encontrado");
    }
}
