package mensagens;

public interface RepositorioMensagens {
    void inserir(Mensagem mensagem);

    void remover(Mensagem mensagem) throws MensagemNaoEncontradaException;

    boolean existe(String mensagem);

    String procurar(int identificacao) throws IdentificacaoNaoEncontradaException;

    void atualizar(Mensagem mensagem, String atualizado) throws MensagemNaoEncontradaException;

    Mensagem [] getIterator();
}

