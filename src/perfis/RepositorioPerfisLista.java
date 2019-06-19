package perfis;

public class RepositorioPerfisLista implements RepositorioPerfis{
    private Perfil perfil;
    private RepositorioPerfisLista next;

    public Perfil getPerfil() {
        return perfil;
    }

    public void inserir(Perfil perfil) {
        if (this.perfil == null) {
            this.perfil = perfil;
            this.next = new RepositorioPerfisLista();
        } else {
            this.next.inserir(perfil);
        }
    }
    public void remover(String number) throws PerfilNotFoundException {
        if (this.existe(number)) {
            if (this.perfil.getNumber().equals(number)) {
                if (this.next.getPerfil() != null) {
                    this.perfil = this.next.getPerfil();
                    this.next = this.next.next;
                } else {
                    this.perfil = null;
                    this.next = null;
                }
            } else {
                this.next.remover(number);
            }
        } else {
            throw new PerfilNotFoundException();
        }
    }
    public Perfil procurar(String number) throws PerfilNotFoundException {
        if (this.perfil == null) {
            throw new PerfilNotFoundException();
        } else if (this.perfil.getNumber().equals(number)) {
            return this.perfil;
        } else {
            return this.next.procurar(number);
        }
    }

    public boolean existe(String number) {
        if (this.perfil == null) {
            return false;
        } else if (this.perfil.getNumber().equals(number)) {
            return true;
        } else {
            return this.next.existe(number);
        }
    }

    public void atualizar(Perfil perfil) throws PerfilNotFoundException{
        if (this.existe(perfil.getNumber())) {
            if (this.perfil.equals(perfil)) {
                this.perfil = perfil;
            } else {
                this.next.atualizar(perfil);
            }
        } else {
            throw new PerfilNotFoundException();
        }
    }

}
