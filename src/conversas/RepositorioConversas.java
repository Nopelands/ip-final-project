package conversas;

import perfis.*;

public interface RepositorioConversas {
	public void inserir (Conversa novaConversa) throws EspacoInsuficienteException;
	public void remover (Conversa conversaRemovida) throws ConversaNaoEncontradaException;
	public Conversa procurar (Conversa conversaProcurada) throws ConversaNaoEncontradaException;
	public boolean existe (Perfil emissor, Perfil receptor);
}
