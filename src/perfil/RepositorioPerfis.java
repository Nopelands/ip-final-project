package perfil;

public interface RepositorioPerfis {
    void inserir(Perfis perfil);

    void remover(String number) throws NumberNotFoundException;

    Perfis procurar(String number) throws NumberNotFoundException;

    boolean existe(String number);

    void atualizar(String number);

}
