package perfil;

public class PerfilRepositoryArray {
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

    public Perfil findByNumber(String number) throws NumberNotFoundException{
        for (Perfil perfil : perfils) {
            if (perfil.getNumber().equals(number)) {
                return perfil;
            }
        }
        throw new NumberNotFoundException();
    }

    public class NumberNotFoundException extends Exception {
        NumberNotFoundException() {
            super("Number Not Found");
        }
    }
}
