package perfil;

public class PerfilRepositoryArray implements PerfilRepository{
    private Perfil[] perfils;

    public PerfilRepositoryArray() {
        perfils = new Perfil[0];
    }
    public void insert(Perfil perfil) {
        Perfil[] temp = new Perfil[perfils.length + 1];
        for (int i = 0; i < perfils.length; i++) {
            temp[i] = perfils[i];
            temp[temp.length - 1] = perfil;
            perfils = temp;
        }
    }

    public int length() {
        return perfils.length;
    }

    public Perfil findByNumber(String number) throws NumberNotFoundException{
        for (Perfil perfil : perfils) {
            if (perfil.getNumber().equals(number)) {
                return perfil;
            }
        }
        throw new NumberNotFoundException();
    }

    public void remove(String number) throws NumberNotFoundException {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < perfils.length && !found; i++) {
            if (perfils[i].getNumber().equals(number)) {
                found = true;
                index = i;
            }
        }
        if (!found) {
            throw new NumberNotFoundException();
        } else {
            Perfil[] temp = new Perfil[perfils.length - 1];
            for (int i = 0; i < perfils.length; i++) {
                if (i < index) {
                    temp[i] = perfils[i];
                } else {
                    temp[i] = perfils[i + 1];
                }
            }
            perfils = temp;
        }
    }
}
