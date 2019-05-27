package mensagens;

public abstract class Mensagem {
    protected String mensagem;
    protected String remetente;

    public Mensagem(String remetente, String mensagem) {
        this.remetente = remetente;
        this.mensagem = mensagem;
    }
    public abstract  void novamensagem(String mensagem);

    public String getMensagem() {
        return this.mensagem;
    }
    public String getRemetente() {
        return remetente;
    }
    public void setMensagem(String mensagemsetar) {
        this.mensagem = mensagemsetar;
    }
}
