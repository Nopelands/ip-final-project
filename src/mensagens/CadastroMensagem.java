package mensagens;

public class CadastroMensagem {
    private MensagensRepositorio mensagensRepositorio;
    public CadastroMensagem(MensagensRepositorio mensagensRepositorio){
        this.mensagensRepositorio = mensagensRepositorio;
    }
    public void cadastrar(Mensagem mensagem){
        mensagensRepositorio.inserir(mensagem);
    }
    public void remover(Mensagem mensagem) throws MensagemNaoEncontradaException {
        mensagensRepositorio.remover(mensagem.getMensagem());
    }
    public String[] procurar(String remetente) throws RemetenteNaoEncontradoException {
        return mensagensRepositorio.procurar(remetente);
    }

    public boolean existe(Mensagem mensagem) {
        return mensagensRepositorio.existe(mensagem.getMensagem());
    }
    public void atualizar(Mensagem mensagem, String atualizado) throws MensagemNaoEncontradaException {
        mensagensRepositorio.atualizar(mensagem.getMensagem(), atualizado);
    }
}
