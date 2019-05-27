package mensagens;

public class CadastroMensagem {
    private RepositorioMensagens repositorioMensagens;
    public CadastroMensagem(RepositorioMensagens repositorioMensagens){
        this.repositorioMensagens = repositorioMensagens;
    }
    public void cadastrar(Mensagem mensagem){
        repositorioMensagens.inserir(mensagem);
    }
    public void remover(Mensagem mensagem) throws MensagemNaoEncontradaException {
        repositorioMensagens.remover(mensagem.getMensagem());
    }
    public String[] procurar(String remetente) throws RemetenteNaoEncontradoException {
        return repositorioMensagens.procurar(remetente);
    }

    public boolean existe(Mensagem mensagem) {
        return repositorioMensagens.existe(mensagem.getMensagem());
    }
    public void atualizar(Mensagem mensagem, String atualizado) throws MensagemNaoEncontradaException {
        repositorioMensagens.atualizar(mensagem.getMensagem(), atualizado);
    }
}
