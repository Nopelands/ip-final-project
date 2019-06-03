package conversas;

import perfis.*;

public interface RepositorioConversas {
	public void inserir (Conversa novaConversa) throws RepositorioException;
	public void remover (Conversa conversaRemovida) throws ConversaNaoEncontradaException;
	public Conversa procurar (Conversa conversaProcurada) throws ConversaNaoEncontradaException;
	public boolean existe (Conversa conversaBuscada);
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException;
}