package conversas;

import perfis.*;

public class CadastroConversas {
	RepositorioConversas conversas;
	public CadastroConversas (RepositorioConversas conversas) {
		this.conversas = conversas;
	}
	public Conversa procurarConversa (Conversa conversaProcurada) throws ConversaNaoEncontradaException {
		return conversas.procurar(conversaProcurada);
	}
	public void iniciarConversa (Conversa novaConversa) throws ConversaReiniciadaException, EspacoInsuficienteException {
		if (conversas.existe(novaConversa.getEmissor(), novaConversa.getReceptor())) {
			throw new ConversaReiniciadaException();
		} else {
			conversas.inserir(novaConversa);
		}
	}
	public void apagarConversa (Conversa conversaApagada) throws ConversaNaoEncontradaException {
		conversas.remover(conversaApagada);
	}
}
