package conversas;

import perfis.Perfil;

public class NaoSaoContatosException extends Exception {
	Perfil emissor;
	Perfil receptor;
	public NaoSaoContatosException (Perfil emissor, Perfil receptor) {
		super ("A conversa nao pode ser prosseguida porque os perfis " + emissor.getName() + " e " + receptor.getName() + " nao estao na lista de contatos um do outro.");
		this.emissor = emissor;
		this.receptor = receptor;
	}
}
