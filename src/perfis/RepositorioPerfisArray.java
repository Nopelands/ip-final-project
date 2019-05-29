package perfis;

public class RepositorioPerfisArray implements RepositorioPerfis {
    private Perfil[] perfis;

    public RepositorioPerfisArray() {
        perfis = new Perfil[0];
    }
    public void inserir(Perfil perfil) {
        Perfil[] temp = new Perfil[perfis.length + 1];
        if (perfis.length > 0) {
            for (int i = 0; i < perfis.length; i++) {
                temp[i] = perfis[i];
            }
        }
        temp[temp.length - 1] = perfil;
        perfis = temp;
    }

    public boolean existe(String number) {
        for (Perfil perfi : perfis) {
            if (perfi.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public Perfil procurar(String number) throws PerfilNotFoundException {
        for (Perfil perfi : perfis) {
            if (perfi.getNumber().equals(number)) {
                return perfi;
            }
        }
        throw new PerfilNotFoundException();
    }

    //TODO redo remover using existe()
    public void remover(String number) throws PerfilNotFoundException {
        if (this.existe(number)) {
            Perfil[] temp = new Perfil[this.perfis.length - 1];
            boolean found = false;
            for (int i = 0; i < this.perfis.length; i++) {
                if (!this.perfis[i].getNumber().equals(number) && !found) {
                    temp[i] = perfis[i];
                } else if (!this.perfis[i].getNumber().equals(number) && found) {
                    temp[i - 1] = perfis[i];
                } else {
                    found = true;
                }
            }
            perfis = temp;
        } else {
            throw new PerfilNotFoundException();
        }
    }

    public void atualizar(Perfil perfil) throws PerfilNotFoundException {
        for (int i = 0; i < perfis.length; i++) {
            if (this.existe(perfil.getNumber())) {
                if (perfis[i].getNumber().equals(perfil.getNumber())) {
                    perfis[i] = perfil;
                }
            } else {
                throw new PerfilNotFoundException();
            }
        }

    }
}
