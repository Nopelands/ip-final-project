package mensagens;
import perfis.*;

public class MensagensTeste {
    public static void main (String [] args) {
        CadastroMensagens teste = new CadastroMensagens(new RepositorioMensagensArray());
        CadastroPerfis testando = new CadastroPerfis(new RepositorioPerfisArray());
        int identificacao = 0; // toda vez for mandar uma mensagem, tem que colocar um identificacao++ em baixo;
        Perfil testando1 = new Perfil("s", "b", new RepositorioPerfisLista());
        Mensagem teste1 = new MensagemCodificada(testando1, "Matheus Epitacio Barros de Lucena", identificacao);
        Mensagem teste2 = new MensagemCodificada(testando1, "bom", identificacao);
        teste1.codificar();
        System.out.print(teste1.mensagem);
        try {
            teste.cadastrar(teste1);
            teste.cadastrar(teste2);
            teste.remover(teste1);
            teste.remover(teste2);
            teste.cadastrar(teste1);
            String b = teste.procurar(54);

        } catch (Exception fim) {
            fim.printStackTrace();
        }

    }
}
