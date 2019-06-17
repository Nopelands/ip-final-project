package mensagens;

public class RepositorioMensagensLista implements RepositorioMensagens {
    private Mensagem mensagens;
    private RepositorioMensagensLista proximo;
    private int identificacao;

    public RepositorioMensagensLista() {
        this.mensagens = null;
        this.proximo = null;
    }

    public Mensagem getMensagens() {
        return mensagens;
    }

    public void inserir(Mensagem mensagem) {
        if (this.mensagens == null) {
            this.mensagens = mensagem;
            this.proximo = new RepositorioMensagensLista();
        } else {
            this.proximo.inserir(mensagem);
        }
    }

    public void remover(Mensagem mensagem) throws MensagemNaoEncontradaException {
        if (this.existe(mensagem.getMensagem())) {
            if (this.mensagens.getMensagem().equals(mensagem.getMensagem())) {
                if (this.proximo.getMensagens() != null) {
                    this.mensagens = this.proximo.getMensagens();
                    this.proximo = this.proximo.proximo;
                } else {
                    this.mensagens = null;
                    this.proximo = null;
                }
            } else {
                this.proximo.remover(mensagem);
            }
        } else {
            throw new MensagemNaoEncontradaException();
        }
    }

    public boolean existe(String mensagem) {
        if (this.mensagens == null) {
            return false;
        } else if (this.mensagens.getMensagem().equals(mensagem)) {
            return true;
        } else {
            return this.proximo.existe(mensagem);
        }
    }

    public void atualizar(Mensagem mensagem) throws IdentificacaoNaoEncontradaException {
        if (this.existe(mensagem.getMensagem())) {
            if (this.mensagens.getMensagem().equals(mensagem.getIdentificacao())) {
                this.mensagens = mensagem;
            } else {
                this.proximo.atualizar(mensagem);
            }
        } else {
            throw new IdentificacaoNaoEncontradaException();
        }
    }

    public Mensagem procurar(int identificacao) throws IdentificacaoNaoEncontradaException {
        if (this.mensagens == null) {
            throw new IdentificacaoNaoEncontradaException();
        } else if (this.mensagens.getIdentificacao() == identificacao) {
            return this.mensagens;
        } else {
            return this.proximo.procurar(identificacao);
        }

    }
}


