package conversas;

import perfis.*;

public interface RepositorioConversas {
	public void inserir (Conversa novaConversa) throws RepositorioException;
	public void remover (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException;
	public Conversa procurar (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException;
	public boolean existe (Perfil emissor, Perfil receptor);
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException;
}