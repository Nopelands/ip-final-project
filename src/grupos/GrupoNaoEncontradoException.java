package grupos;

public class GrupoNaoEncontradoException extends Exception{
    GrupoNaoEncontradoException() {
        super("Grupo nao encontrado");
    }
}
