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
        if (this.previous == null) {
            if (this.perfil == null) {
                throw new PerfilNotFoundException();
            } else if (this.perfil.getNumber().equals(number)) {
                if (this.next == null) {
                    this.perfil = null;
                } else {
                    this.perfil = this.next.getPerfil();
                    this.next = this.next.next;
                }
            } else {
                this.next.remover(number);
            }
        } else {
            if (this.perfil == null) {
                throw new PerfilNotFoundException();
            } else if (this.perfil.getNumber().equals(number)) {
                this.perfil = this.next.getPerfil();
                this.next = this.next.next;
            } else {
                this.next.remover(number);
            }
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
                this.atualizar(perfil);
            }
        } else {
            throw new PerfilNotFoundException();
        }
    }

}