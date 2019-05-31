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
    public void adicionarContato(String numberAdd, String numberContato) throws PerfilNotFoundException, PerfilJaCadastradoException{
        Perfil perfil = repositorioPerfis.procurar(numberAdd);
        if (perfil.getContacts().existe(numberContato)) {
            throw new PerfilJaCadastradoException();
        } else {
            perfil.getContacts().inserir(repositorioPerfis.procurar(numberContato));
        }
        repositorioPerfis.atualizar(perfil);
    }
    public void removerContato(String numberRemove, String numberContato) throws PerfilNotFoundException {
        Perfil perfil = repositorioPerfis.procurar(numberRemove);
        Perfil remover = perfil.getContacts().procurar(numberContato);
        perfil.getContacts().remover(remover.getNumber());
        repositorioPerfis.atualizar(perfil);
    }
}
