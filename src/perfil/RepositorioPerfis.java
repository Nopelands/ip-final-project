package perfil;

public interface RepositorioPerfis {
    void inserir(Perfis perfil);

    void remover(String number) throws PerfilNotFoundException;

    Perfis procurar(String number) throws PerfilNotFoundException;

    boolean existe(String number);

    void atualizar(Perfis perfil) throws PerfilNotFoundException;

}
