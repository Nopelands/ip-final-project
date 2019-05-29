package mensagens;
import perfis.*;

public class MensagensTeste {
    public static void main (String [] args) {
        CadastroMensagens teste = new CadastroMensagens(new RepositorioMensagensArray());
        CadastroPerfis testando = new CadastroPerfis(new RepositorioPerfisArray());
        Perfil testando1 = new Perfil("s", "b", new RepositorioPerfisLista());
        Mensagem teste1 = new MensagemCodificada(testando1, "Matheus Epitacio Barros de Lucena", 54);
        Mensagem teste2 = new MensagemCodificada(testando1, "bom", 67);
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
