package mensagens;

public interface RepositorioMensagens {
    void inserir(Mensagem mensagem);

    void remover(Mensagem mensagem) throws MensagemNaoEncontradaException;

    boolean existe(String mensagem);

    Mensagem procurar(int identificacao) throws IdentificacaoNaoEncontradaException;

    void atualizar(Mensagem atualizar) throws IdentificacaoNaoEncontradaException;
}
