package conversas;

public class ConversaNaoEncontradaException extends Exception {
	public ConversaNaoEncontradaException () {
		super ("A conversa solicitada não foi encontrada no sistema");
	}
}
