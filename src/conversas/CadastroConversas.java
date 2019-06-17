package conversas;

import perfis.*;

public class CadastroConversas {
	RepositorioConversas conversas;
	public CadastroConversas (RepositorioConversas conversas) {
		this.conversas = conversas;
	}
	
	public Conversa procurar (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		return conversas.procurar(emissor, receptor);
	}
	
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
		conversas.atualizar(conversaAlterada);
	}
	
	/* O m�todo cadastrar da classe CadastroConversas � regido pelas seguintes regras de neg�cio:
	 * 1. S� pode haver, no m�ximo, uma conversa entre dois perfis cadastrados quaisquer. Assim, caso
	 * this.conversas.existe((novaConversa.getEmissor(), novaConversa.getReceptor())) retorne true, ser� gerado o erro
	 * ConversaReiniciadaException.
	 * 2. As conversas que t�m como emissor e receptor, respectivamente, os perfis A -> B e B -> A s�o consideradas distintas.
	 * Ali�s, � poss�vel at� que uma delas esteja cadastrada no sistema e a outra n�o. O fato de a conversa B -> A ter sido ou n�o inicada �
	 * irrelavante na decis�o de iniciar a conversa A -> B.
	 * 3. Para que uma conversa entre os perfis A e B seja iniciada, uma condi��o necess�ria � que A esteja na lista de contatos de B,
	 * e B esteja na lista de contatos de A.
	 * */
	
	public void cadastrar (Conversa novaConversa) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException {
		if (this.conversas.existe(novaConversa.getEmissor(), novaConversa.getReceptor())) {
			throw new ConversaReiniciadaException(novaConversa.getEmissor(), novaConversa.getReceptor());
		} else if (novaConversa.getEmissor().getContacts().existe(novaConversa.getReceptor().getNumber()) && novaConversa.getReceptor().getContacts().existe(novaConversa.getEmissor().getNumber())) {
			this.conversas.inserir(novaConversa);
		} else {
			throw new NaoSaoContatosException(novaConversa.getEmissor(), novaConversa.getReceptor());
		}
	}
	
	public void remover (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		conversas.remover(emissor, receptor);
	}
}
