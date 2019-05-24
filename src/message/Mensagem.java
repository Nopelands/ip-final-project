package mensagens;

public abstract class Mensagem {
    String mensagem;
    MensagensRepositorio mensagens;

    public Mensagem(String mensagem, MensagensRepositorio mensagensRepositorio ) {
        this.mensagem = mensagem;
        this.mensagens = mensagensRepositorio;
    }
    public abstract void enviar(String message);

    public String getMensagem() {
        return this.mensagem;
    }
    public void retirar(String mensagem, MensagensRepositorio mensagens){
        mensagens.remover(mensagem);
    }

}
