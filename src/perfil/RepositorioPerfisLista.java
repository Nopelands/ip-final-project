package perfil;

public class RepositorioPerfisLista implements RepositorioPerfis{
    private Perfis perfil;
    private RepositorioPerfisLista next;
    private RepositorioPerfisLista previous;

    public Perfis getPerfil() {
        return perfil;
    }

    public void inserir(Perfis perfil) {
        if (this.perfil == null) {
            this.perfil = perfil;
            this.next = new RepositorioPerfisLista();
        } else {
            this.next.inserir(perfil, this);
        }
    }

    public void inserir(Perfis perfil, RepositorioPerfisLista previous) {
        if (this.perfil == null) {
            this.perfil = perfil;
            this.next = new RepositorioPerfisLista();
        } else {
            this.next.inserir(perfil, this);
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
}