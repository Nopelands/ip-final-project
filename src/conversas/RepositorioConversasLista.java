package conversas;

import perfis.*;

public class RepositorioConversasLista implements RepositorioConversas {
	private Conversa corpo;
	private RepositorioConversasLista cauda;
	public RepositorioConversasLista () {
		this.corpo = null;
		this.cauda = null;
	}
	private boolean estaVazia () {
		return (this.corpo == null);
	}
	public void inserir (Conversa novoMembro) {
		if (this.estaVazia()) {
			this.corpo = novoMembro;
			this.cauda = new RepositorioConversasLista();
		} else {
			this.cauda.inserir(novoMembro);
		}
	}
	public void remover (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		if (this.estaVazia()) {
			throw new ConversaNaoEncontradaException();
		} else if (this.corpo.getEmissor().equals(emissor) && this.corpo.getReceptor().equals(receptor)) {
			this.corpo = this.cauda.corpo;
			this.cauda = this.cauda.cauda;
		} else {
			this.cauda.remover(emissor, receptor);	
		}
	}
	public Conversa procurar (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
		if (this.estaVazia()) {
			throw new ConversaNaoEncontradaException();
		} else if (this.corpo.getEmissor().equals(emissor) && this.corpo.getReceptor().equals(receptor)) {
			return this.corpo;
		} else {
			return this.cauda.procurar(emissor, receptor);
		}
	}
	public boolean existe (Perfil emissor, Perfil receptor) {
		if (this.estaVazia()) {
			return false;
		} else if (this.corpo.getEmissor().equals(emissor) && this.corpo.getReceptor().equals(receptor)) {
			return true;
		} else {
			return this.cauda.existe(emissor, receptor);
		}
	}
	public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
		if (this.estaVazia()) {
			throw new ConversaNaoEncontradaException();
		} else if (this.corpo.equals(conversaAlterada)) {
			this.corpo = conversaAlterada;
		} else {
			this.cauda.atualizar(conversaAlterada);
		}
	}
}
