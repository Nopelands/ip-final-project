package mensagens;

public class RepositorioMensagensArray implements RepositorioMensagens {
    private Mensagem [] mensagens;
    public RepositorioMensagensArray(){
        mensagens = new Mensagem [0];
    }
    public void inserir(Mensagem mensagem) {
        Mensagem[] aux = new Mensagem[mensagens.length + 1];
        if (mensagens.length > 0) {
            for (int i = 0; i < mensagens.length; i++) {
                aux[i] = mensagens[i];
            }
        }
        aux[aux.length - 1] = mensagem;
        mensagens = aux;
    }
    public boolean existe(String mensagem) {
        boolean encontrou =  false;
        for (int i = 0; i < mensagens.length && !encontrou; i++) {
            encontrou = mensagens[i].getMensagem().equals(mensagem);
        } return encontrou;

    }
    public void remover(Mensagem mensagem) throws MensagemNaoEncontradaException{
        if (this.existe(mensagem.getMensagem())) {
            Mensagem[] aux = new Mensagem[mensagens.length - 1];
            int indice = 0;
            for (int i = 0; i < mensagens.length; i++) {
                if (!mensagens[i].getMensagem().equals(mensagem.getMensagem())) {
                    aux[indice] = mensagens[i];
                    indice++;
                }
            }
            mensagens = aux;
        } else {
            throw new MensagemNaoEncontradaException();
        }
    }
    public Mensagem procurar(int identificacao) throws IdentificacaoNaoEncontradaException {
        boolean encontrou = false;
        Mensagem retorno = null;
        for (int i = 0; i<mensagens.length && !encontrou;i++){
            if (mensagens[i].getIdentificacao()==identificacao) {
                encontrou = true;
                retorno = mensagens[i];
            }
        }
        if (encontrou)  {
            return retorno;
        } else {
            throw new IdentificacaoNaoEncontradaException();
        }
    }
    public void atualizar(Mensagem mensagem) throws IdentificacaoNaoEncontradaException {
        boolean naoencontrou = true;
        for (int i = 0; i<mensagens.length && naoencontrou; i++){
            if (mensagens[i].getIdentificacao() == mensagem.getIdentificacao()) {
                mensagens[i]=mensagem;
                naoencontrou = false;
            }
        }
        if (naoencontrou) {
            throw new IdentificacaoNaoEncontradaException();
        }
    }
    public Mensagem [] getIterator(){
        return mensagens;
    }

}
