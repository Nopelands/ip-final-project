package perfil;

public class CadastroPerfis {

    private RepositorioPerfis repositorioPerfis;

    public CadastroPerfis(RepositorioPerfis repositorioPerfis) {
        this.repositorioPerfis = repositorioPerfis;
    }

    public void cadastrar(Perfis perfil) throws PerfilJaCadastradoException{
        if (!repositorioPerfis.existe(perfil.getNumber())) {
            repositorioPerfis.inserir(perfil);
        } else {
            throw new PerfilJaCadastradoException();
        }
    }

    public void remover(Perfis perfil) throws PerfilNotFoundException {
        repositorioPerfis.remover(perfil.getNumber());
    }
    public Perfis procurar(String number) throws PerfilNotFoundException {
        return repositorioPerfis.procurar(number);
    }

    public boolean existe(Perfis perfil) {
        return repositorioPerfis.existe(perfil.getNumber());
    }
    public void atualizar(Perfis perfil) throws PerfilNotFoundException {
        repositorioPerfis.atualizar(perfil);
    }
}
