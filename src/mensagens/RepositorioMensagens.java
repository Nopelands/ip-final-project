package mensagens;

public interface RepositorioMensagens {
    void inserir (Mensagem mensagem);

    void remover (String mensagem) throws MensagemNaoEncontradaException;

    boolean existe(String mensagem);

    String [] procurar(String remetente) throws RemetenteNaoEncontradoException;

    void atualizar (String mensagem, String atualizado) throws MensagemNaoEncontradaException;
}
