package mensagens;
public interface MensagensRepositorio {

    void inserir (String mensagem);

    void remover (String mensagem) throws MensagemNaoEncontradaException;

    boolean existe(String mensagem);
    // falta atualizar e procurar
}
