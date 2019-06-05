package conversas;

import perfis.Perfil;

public class ConversaReiniciadaException extends Exception {
	Perfil emissor;
	Perfil receptor;
	public ConversaReiniciadaException (Perfil emissor, Perfil receptor) {
		super ("Tentativa de cadastrar pela segunda vez uma conversa entre " + emissor.getName() + " e " + receptor.getName());
		this.emissor = emissor;
		this.receptor = receptor;
	}
}
