package conversas;

public class RepositorioConversasArray implements RepositorioConversas {
	private Conversa[] conversas;
	private int indice;
	public RepositorioConversasArray (int tam) {
		conversas = new Conversa[tam];
		indice = 0;
	}
	public boolean existe (Conversa conversaBuscada) {
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (conversas[i].equals(conversaBuscada)) {
				achou = true;
			}
		}
		return achou;
	}
	public void inserir (Conversa novaConversa) throws EspacoInsuficienteException {
		if (indice >= conversas.length) {
			throw new EspacoInsuficienteException();
		} else {
			conversas[indice] = novaConversa;
			indice = indice + 1;
		}
	}
	public Conversa procurar (Conversa conversaProcurada) throws ConversaNaoEncontradaException {
		boolean achou = false;
		Conversa resposta = null;
		for (int i = 0; i < indice && !achou; i++) {
			if (conversas[i].equals(conversaProcurada)) {
				achou = true;
				resposta = conversas[i];
			}
		} if (!achou) {
			throw new ConversaNaoEncontradaException();
		} else {
			return resposta;
		}
	}
	public void remover (Conversa conversaRemovida) throws ConversaNaoEncontradaException {
		Conversa resultadoBusca = this.procurar(conversaRemovida);
		indice--;
		resultadoBusca = conversas[indice];
	}
}
