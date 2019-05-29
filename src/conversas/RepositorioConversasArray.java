package conversas;

public class RepositorioConversasArray implements RepositorioConversas {
	private Conversa[] conversas;
	private int indice;
	public RepositorioConversasArray (int tam) {
		conversas = new Conversa[tam];
		indice = 0;
	}
	public void inserir (Conversa novaConversa) throws EspacoInsuficienteException {
		if (indice >= conversas.length) {
			// TODO
		}
	}
}
