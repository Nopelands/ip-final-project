package perfis;

public class PerfisTestes {
    public static void main(String[] args) {
        //TODO test stuff
        CadastroPerfis head = new CadastroPerfis(new RepositorioPerfisLista());
        Perfil test1 = new Perfil("lol", "3", new RepositorioPerfisArray());
        Perfil test2 = new Perfil("a", "2", new RepositorioPerfisArray());
        Perfil test3 = new Perfil("b", "5", new RepositorioPerfisArray());
        Perfil test4 = new Perfil("c", "10", new RepositorioPerfisArray());
        try {
            head.cadastrar(test1);
            head.cadastrar(test2);
            head.cadastrar(test3);
            head.cadastrar(test4);
            head.cadastrar(test4);
            head.remover(test1);
            head.remover(test2);
            head.procurar(test1.getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
