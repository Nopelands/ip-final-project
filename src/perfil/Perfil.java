package perfil;

public class Perfil {
    private String name;
    private String phrase;
    private String number;
    private PerfilRepositoryArray contacts;


    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPhrase() {
        return phrase;
    }

    public PerfilRepositoryArray getContacts() {
        return contacts;
    }
}