package mensagens;

public class MensagemCodificada extends Mensagem {
    public MensagemCodificada(String remetente,String mensagem){
        super(remetente, mensagem);
    }

    public void novamensagem (String mensagem) {
        String mensagemcodificada1 = mensagem.replace('a', '@');
        String mensagemcodificada2 = mensagemcodificada1.replace('c', '¢');
        String mensagemcodificada3 = mensagemcodificada2.replace('8', '∞');
        String mensagemcodificada4 = mensagemcodificada3.replace('l', '[');
        String mensagemcodificada = mensagemcodificada4;
        this.mensagem = mensagemcodificada;
    }

}
