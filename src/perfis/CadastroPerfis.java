package perfis;

public class CadastroPerfis {

    private RepositorioPerfis repositorioPerfis;

    public CadastroPerfis(RepositorioPerfis repositorioPerfis) {
        this.repositorioPerfis = repositorioPerfis;
    }

    public void cadastrar(Perfil perfil) throws PerfilJaCadastradoException{
        if (!repositorioPerfis.existe(perfil.getNumber())) {
            repositorioPerfis.inserir(perfil);
        } else {
            throw new PerfilJaCadastradoException();
        }
    }

    public void remover(Perfil perfil) throws PerfilNotFoundException {
        repositorioPerfis.remover(perfil.getNumber());
    }
    public Perfil procurar(String number) throws PerfilNotFoundException {
        return repositorioPerfis.procurar(number);
    }

    public boolean existe(Perfil perfil) {
        return repositorioPerfis.existe(perfil.getNumber());
    }
    public void atualizar(Perfil perfil) throws PerfilNotFoundException {
        repositorioPerfis.atualizar(perfil);
    }
}
