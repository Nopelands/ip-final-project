package perfis;

public interface RepositorioPerfis {
    void inserir(Perfil perfil);

    void remover(String number) throws PerfilNotFoundException;

    Perfil procurar(String number) throws PerfilNotFoundException;

    boolean existe(String number);

    void atualizar(Perfil perfil) throws PerfilNotFoundException;

}
