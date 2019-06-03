package conversas;

public class RepositorioConversasArray implements RepositorioConversas {
	private Conversa[] conversas;
	private int indice;
	public RepositorioConversasArray (int tam) {
		conversas = new Conversa[tam];
		indice = 0;
	}
	private int posicao (Conversa conversaBuscada) throws ConversaNaoEncontradaException {
		int resposta = -1;
		for (int i = 0; i < indice && resposta == -1; i++) {
			if (conversas[i].equals(conversaBuscada)) {
				resposta = i;
			}
		}
		if (resposta == -1) {
			throw new ConversaNaoEncontradaException();
		} else {
			return resposta;
		}
	}
	public boolean existe (Conversa conversaBuscada) {
		try {
			this.posicao(conversaBuscada);
			return true;
		} catch (ConversaNaoEncontradaException e) {
			return false;
		}
	}
	public void inserir (Conversa novaConversa) throws RepositorioException {
		if (indice >= conversas.length) {
			throw new RepositorioException();
		} else {
			conversas[indice] = novaConversa;
			indice = indice + 1;
		}
	}
	public Conversa procurar (Conversa conversaProcurada) throws ConversaNaoEncontradaException {
		int p = this.posicao(conversaProcurada);
		return conversas[p];
	}
	public void remover (Conversa conversaRemovida) throws ConversaNaoEncontradaException {
		int p = this.posicao(conversaRemovida);
		indice--;
		conversas[p] = conversas[indice];
	}
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
		int p = this.posicao(conversaAlterada);
		conversas[p] = conversaAlterada;
	}
}
