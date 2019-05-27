package perfis;

public class Perfil {
    private final String name;
    private String phrase;
    private final String number;
    private RepositorioPerfis contacts;

    public Perfil(String name, String number, RepositorioPerfis repositorioPerfis) {
        this.name = name;
        this.phrase = null;
        this.number = number;
        this.contacts = repositorioPerfis;
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

    public RepositorioPerfis getContacts() {
        return contacts;
    }

    public boolean equals(Perfil perfil) {
        return this.number.equals(perfil.getNumber()) && this.phrase.equals(perfil.getPhrase());
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
