package conversas;

import perfis.Perfil;

public class NaoSaoContatosException extends Exception {
	Perfil emissor;
	Perfil receptor;
	public NaoSaoContatosException (Perfil emissor, Perfil receptor) {
		super ("A conversa não pode ser prosseguida porque os perfis" + emissor.getName() + " e " + receptor.getName() + "não estão na lista de contatos um do outro.");
		this.emissor = emissor;
		this.receptor = receptor;
	}
}
