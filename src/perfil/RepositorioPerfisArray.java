package perfil;

public class RepositorioPerfisArray implements RepositorioPerfis {
    private Perfil[] perfis;

    public RepositorioPerfisArray() {
        perfis = new Perfil[0];
    }
    public void inserir(Perfil perfil) {
        Perfil[] temp = new Perfil[perfis.length + 1];
        for (int i = 0; i < perfis.length; i++) {
            temp[i] = perfis[i];
            temp[temp.length - 1] = perfil;
            perfis = temp;
        }
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

    public void remover(String number) throws PerfilNotFoundException {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < perfis.length && !found; i++) {
            if (perfis[i].getNumber().equals(number)) {
                found = true;
                index = i;
            }
        }
        if (!found) {
            throw new PerfilNotFoundException();
        } else {
            Perfil[] temp = new Perfil[perfis.length - 1];
            for (int i = 0; i < perfis.length; i++) {
                if (i < index) {
                    temp[i] = perfis[i];
                } else {
                    temp[i] = perfis[i + 1];
                }
            }
            perfis = temp;
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
