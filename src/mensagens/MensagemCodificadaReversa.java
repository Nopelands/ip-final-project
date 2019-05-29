package mensagens;
import perfis.*;
public class MensagemCodificadaReversa extends Mensagem {
    public MensagemCodificadaReversa(Perfil remetente, String mensagem, int identificacao){
        super (remetente, mensagem, identificacao);
    }
    private String mensagemcodificada;

    public void codificar(){
        mensagemcodificada = "";
        for (int i = 0; i<mensagem.length(); i++){
            char c = mensagem.charAt(mensagem.length()-1-i);
                mensagemcodificada = mensagemcodificada + c;

        } this.mensagem = mensagemcodificada;

    }
}
