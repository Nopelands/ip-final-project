package conversas;

public class RepositorioConversasLista {
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
	public void remover (Conversa exMembro) throws ConversaNaoEncontradaException {
		if (this.estaVazia()) {
			throw new ConversaNaoEncontradaException();
		} else if (this.corpo.equals(exMembro)) {
			this.corpo = this.cauda.corpo;
			this.cauda = this.cauda.cauda;
		} else {
			this.cauda.remover(exMembro);	
		}
	}
	public Conversa procurar (Conversa membroProcurado) throws ConversaNaoEncontradaException {
		if (this.estaVazia()) {
			throw new ConversaNaoEncontradaException();
		} else if (this.corpo.equals(membroProcurado)) {
			return this.corpo;
		} else {
			return this.cauda.procurar(membroProcurado);
		}
	}
	public boolean existe (Conversa possivelMembro) {
		if (this.estaVazia()) {
			return false;
		} else if (this.corpo.equals(possivelMembro)) {
			return true;
		} else {
			return this.cauda.existe(possivelMembro);
		}
	}
}
