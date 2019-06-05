package mensagens;
import perfis.*;
public class MensagemCodificada extends Mensagem {
    public MensagemCodificada( Perfil remetente, String mensagem, int identificacao){
        super (remetente, mensagem, identificacao);
    }
    private String mensagemcodificada;
    public void codificar(){
         mensagemcodificada ="";
        for (int i = 0; i<mensagem.length();i++){
            char c = mensagem.charAt(i);
            char d ;
            switch (c) {
                case 'a' :
                    d = '@';
                    break;
                case 'b' :
                    d = 'ß';
                    break;
                case 'c' :
                    d = '¢';
                    break;
                case 'd':
                    d = 'Ɖ';
                    break;
                case 'e' :
                    d = '£';
                    break;
                case 'f' :
                    d = 'ƒ';
                    break;
                case 'g' :
                    d = 'ɠ';
                    break;
                case 'h' :
                    d = 'ƕ';
                    break;
                case 'i' :
                    d = 'ɨ';
                    break;
                case 'j' :
                    d = 'ȷ';
                    break;
                case 'k' :
                    d = 'Ⓚ';
                    break;
                case 'l' :
                    d = '[';
                    break;
                case 'm' :
                    d = 'ϻ';
                    break;
                case 'n' :
                    d = '⋂';
                    break;
                case 'o' :
                    d = '⟲';
                    break;
                case 'p' :
                    d = 'ϸ';
                    break;
                case 'r' :
                    d = 'ʁ';
                    break;
                case 's' :
                    d = '∫';
                    break;
                case 't' :
                    d = '✝';
                    break;
                case 'u' :
                    d = '⨆';
                    break;
                case 'v' :
                    d = '⌵';
                    break;
                case 'w' :
                    d = 'ɯ';
                    break;
                case 'x' :
                    d = '⨉';
                    break;
                case 'y' :
                    d = 'Ұ';
                    break;
                case 'z' :
                    d = 'Ž';
                    break;
                case 'A' :
                    d = '@';
                    break;
                case 'Β' :
                    d = 'β';
                    break;
                case 'C' :
                    d = '¢';
                    break;
                case 'D':
                    d = 'Ɖ';
                    break;
                case 'E' :
                    d = '£';
                    break;
                case 'F' :
                    d = 'Ƒ';
                    break;
                case 'G' :
                    d = 'Ɠ';
                    break;
                case 'H' :
                    d = 'Ƕ';
                    break;
                case 'I' :
                    d = 'Ɨ';
                    break;
                case 'J' :
                    d = 'ȷ';
                    break;
                case 'K' :
                    d = 'Ⓚ';
                    break;
                case 'L' :
                    d = '[';
                    break;
                case 'M' :
                    d = 'Ϻ';
                    break;
                case 'N' :
                    d = '⋂';
                    break;
                case 'O' :
                    d = '⟲';
                    break;
                case 'P' :
                    d = 'Ϸ';
                    break;
                case 'R' :
                    d = 'ʁ';
                    break;
                case 'S' :
                    d = '∫';
                    break;
                case 'T' :
                    d = '✝';
                    break;
                case 'U' :
                    d = '⨆';
                    break;
                case 'V' :
                    d = '⌵';
                    break;
                case 'W' :
                    d = 'Ɯ';
                    break;
                case 'X' :
                    d = '⨉';
                    break;
                case 'Y' :
                    d = 'Ұ';
                    break;
                case 'Z' :
                    d = 'Ž';
                    break;
                default:
                    d = c;
            }
            mensagemcodificada = mensagemcodificada + d;

        }
        this.mensagem = mensagemcodificada;
    }
}