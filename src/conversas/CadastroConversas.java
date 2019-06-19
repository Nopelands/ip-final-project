package conversas;

import perfis.*;
import mensagens.*;

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
	
	/* O método cadastrar da classe CadastroConversas é regido pelas seguintes regras de negócio:
	 * 1. Só pode haver, no máximo, uma conversa entre dois perfis cadastrados quaisquer. Assim, caso
	 * this.conversas.existe((novaConversa.getEmissor(), novaConversa.getReceptor())) retorne true, será gerado o erro
	 * ConversaReiniciadaException.
	 * 2. As conversas que têm como emissor e receptor, respectivamente, os perfis A -> B e B -> A são consideradas distintas.
	 * Aliás, é possível até que uma delas esteja cadastrada no sistema e a outra não. O fato de a conversa B -> A ter sido ou não inicada é
	 * irrelavante na decisão de iniciar a conversa A -> B.
	 * 3. Para que uma conversa entre os perfis A e B seja iniciada, uma condição necessária é que A esteja na lista de contatos de B,
	 * e B esteja na lista de contatos de A.
	 * */
	
	public void cadastrar (Conversa novaConversa) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException {
		if (this.conversas.existe(novaConversa.getEmissor(), novaConversa.getReceptor())) {
			throw new ConversaReiniciadaException(novaConversa.getEmissor(), novaConversa.getReceptor());
		} else if (!novaConversa.getEmissor().getContacts().existe(novaConversa.getReceptor().getNumber()) || !novaConversa.getReceptor().getContacts().existe(novaConversa.getEmissor().getNumber())) {
			throw new NaoSaoContatosException(novaConversa.getEmissor(), novaConversa.getReceptor());
		} else {
			this.conversas.inserir(novaConversa);
		}
	}
	
	public void remover (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		conversas.remover(emissor, receptor);
	}
}
