package perfil;

public class Perfil {
    private String name;
    private String phrase;
    private String number;
    private PerfilRepository contacts;

    public Perfil(String name, String number, PerfilRepository perfilRepository) {
        this.name = name;
        this.phrase = null;
        this.number = number;
        this.contacts = perfilRepository;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPhrase() {
        return phrase;
    }

    public PerfilRepository getContacts() {
        return contacts;
    }
}