package perfil;

public interface PerfilRepository {
    void insert(Perfil perfil);

    void remove(String number) throws NumberNotFoundException;

    Perfil findByNumber(String number) throws NumberNotFoundException;

    int length();

}
