package mensagens;

import perfis.*;

public abstract class Mensagem {
    protected String mensagem;
    protected Perfil remetente;
    protected int identificacao;

    public Mensagem(Perfil remetente, String mensagem, int identificacao) {
        this.remetente = remetente;
        this.mensagem = mensagem;
        this.identificacao = identificacao;
    }
    public abstract  void codificar();

    public String getMensagem() {
        return this.mensagem;
    }
    public Perfil getRemetente() {
        return remetente;
    }
    public void setMensagem(String mensagemsetar) {
        this.mensagem = mensagemsetar;
    }
    public int getIdentificacao() {
        return identificacao;
    }
}