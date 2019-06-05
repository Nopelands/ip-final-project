package mensagens;

public class CadastroMensagens {
    private RepositorioMensagens repositorioMensagens;
    public CadastroMensagens(RepositorioMensagens repositorioMensagens){
        this.repositorioMensagens = repositorioMensagens;
    }
    public void cadastrar(Mensagem mensagem){
        repositorioMensagens.inserir(mensagem);
    }
    public void remover(Mensagem mensagem) throws MensagemNaoEncontradaException {
        repositorioMensagens.remover(mensagem);
    }
    public String procurar(int identificacao) throws IdentificacaoNaoEncontradaException {
        return repositorioMensagens.procurar(identificacao);
    }

    public boolean existe(Mensagem mensagem) {
        return repositorioMensagens.existe(mensagem.getMensagem());
    }
    public void atualizar(Mensagem mensagem, String atualizado) throws MensagemNaoEncontradaException {
        repositorioMensagens.atualizar(mensagem, atualizado);
    }
}
