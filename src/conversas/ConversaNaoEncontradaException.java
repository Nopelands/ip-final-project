package conversas;

public class ConversaNaoEncontradaException extends Exception {
	public ConversaNaoEncontradaException () {
		super ("A conversa solicitada nao foi encontrada pelo sistema");
	}
}
