package conversas;

public class ConversaReiniciadaException extends Exception {
	public ConversaReiniciadaException () {
		super ("Tentativa de cadastrar pela segunda vez uma conversa já iniciada");
	}
}
