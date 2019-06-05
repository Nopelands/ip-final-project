package conversas;

import perfis.*;

public class CadastroConversas {
	RepositorioConversas conversas;
	public CadastroConversas (RepositorioConversas conversas) {
		this.conversas = conversas;
	}
	public Conversa procurarConversa (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		return conversas.procurar(emissor, receptor);
	}
	public void atualizarConversa (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
		conversas.atualizar(conversaAlterada);
	}
	
	public void iniciarConversa (Conversa novaConversa) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException {
		if (conversas.existe(novaConversa.getEmissor(), novaConversa.getReceptor())) {
			throw new ConversaReiniciadaException(novaConversa.getEmissor(), novaConversa.getReceptor());
		} else if (novaConversa.getEmissor().getContacts().existe(novaConversa.getReceptor().getNumber()) && novaConversa.getReceptor().getContacts().existe(novaConversa.getEmissor().getNumber())) {
			conversas.inserir(novaConversa);
		} else {
			throw new NaoSaoContatosException(novaConversa.getEmissor(), novaConversa.getReceptor());
		}
	}
	public void apagarConversa (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		conversas.remover(emissor, receptor);
	}
}
