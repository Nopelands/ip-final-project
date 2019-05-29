package mensagens;
import perfis.*;
public class MensagemCodificada extends Mensagem {
    public MensagemCodificada( Perfil remetente, String mensagem, int identificacao){
        super (remetente, mensagem, identificacao);
    }
    private String mensagemcodificada;
    public void novamensagem(String mensagem){
         mensagemcodificada = "";
        for (int i = 0; i<mensagem.length();i++){
            char c = mensagem.charAt(i);
            char d = ' ';
            switch (c) {
                case 'a':
                    d = '@';
                    break;
                case 'b':
                    d = 'ß';
                    break;
                case 'c':
                    d = '¢';
                    break;
                case 'd':
                    d = 'Ɖ';
                    break;
                case 'e':
                    d = '£';
                    break;
                case 'f':
                    d = 'ƒ';
                    break;
                case 'g':
                    d = 'ɠ';
                    break;
                case 'h':
                    d = 'ƕ';
                    break;
                case 'i':
                    d = 'ɨ';
                    break;
                case 'j':
                    d = 'ȷ';
                    break;
                case 'k':
                    d = 'Ⓚ';
                    break;
                case 'l':
                    d = '[';
                    break;
                case 'm':
                    d = 'ϻ';
                    break;
                case 'n':
                    d = '⋂';
                    break;
                case 'o':
                    d = '⟲';
                    break;
                case 'p':
                    d = 'ϸ';
                    break;
                case 'r':
                    d = 'ʁ';
                    break;
                case 's':
                    d = '∫';
                    break;
                case 't':
                    d = '✝';
                    break;
                case 'u':
                    d = '⨆';
                    break;
                case 'v':
                    d = '⌵';
                    break;
                case 'w':
                    d = 'ɯ';
                    break;
                case 'x':
                    d = '⨉';
                    break;
                case 'y':
                    d = 'Ұ';
                    break;
                case 'z':
                    d = 'Ž';
                    break;
                default:
                    d = c;
            }
            mensagemcodificada = mensagemcodificada + d;
            this.mensagem = mensagemcodificada;

        }
    }
}
