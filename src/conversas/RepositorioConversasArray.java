package conversas;

import perfis.*;

public class RepositorioConversasArray implements RepositorioConversas {
	private Conversa[] conversas;
	private int indice;
	public RepositorioConversasArray (int tam) {
		conversas = new Conversa[tam];
		indice = 0;
	}
	private int posicao (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		int resposta = -1;
		for (int i = 0; i < indice && resposta == -1; i++) {
			if (conversas[i].getEmissor().equals(emissor) && conversas[i].getReceptor().equals(receptor)) {
				resposta = i;
			}
		}
		if (resposta == -1) {
			throw new ConversaNaoEncontradaException();
		} else {
			return resposta;
		}
	}
	public boolean existe (Perfil emissor, Perfil receptor) {
		try {
			this.posicao(emissor, receptor);
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
	public Conversa procurar (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		int p = this.posicao(emissor, receptor);
		return conversas[p];
	}
	public void remover (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		int p = this.posicao(emissor, receptor);
		// O que antes era a última posição ocupada do array, agora será a próxima posição livre
		indice--;
		/* Entretanto, para liberar a posição no fim do array, precisamos salvar o seu valor em algum outro lugar.
		 * Fazemos isso sobrescrevendo-o na posição 'p'. Desse modo, apagamos também a Conversa a ser removida.
		 */
		conversas[p] = conversas[indice];
	}
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
		int p = this.posicao(conversaAlterada.getEmissor(), conversaAlterada.getReceptor());
		conversas[p] = conversaAlterada;
	}
}
