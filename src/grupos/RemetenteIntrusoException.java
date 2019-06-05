package grupos;

import perfis.Perfil;

public class RemetenteIntrusoException extends Exception {
	private Grupo invadido;
	private Perfil intruso;
	public RemetenteIntrusoException (Grupo invadido, Perfil intruso) {
		super ("O usuario " + intruso.getName() + " nao esta no grupo " + invadido.getNome() + ", mas tentou enviar uma mensagem para ele");
		this.invadido = invadido;
		this.intruso = intruso;
	}
}
