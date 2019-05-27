package perfil;

public class Perfis {
    private final String name;
    private String phrase;
    private final String number;
    private RepositorioPerfis contacts;

    public Perfis(String name, String number, RepositorioPerfis repositorioPerfis) {
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

    public boolean equals(Perfis perfis) {
        return this.number.equals(perfis.getNumber()) && this.phrase.equals(perfis.getPhrase());
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
