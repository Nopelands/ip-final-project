package conversas;

import mensagens.*;
import perfis.*;

public class Conversa {
	private RepositorioMensagens mensagens;
	private Perfil emissor;
	private Perfil receptor;
	public Conversa (Perfil emissor, Perfil receptor, RepositorioMensagens mensagens) {
		this.receptor = receptor;
		this.emissor = emissor;
		this.mensagens = mensagens;
	}
	
	public boolean equals (Conversa outraConversa) {
		return this.emissor.equals(outraConversa.getEmissor()) && this.receptor.equals(outraConversa.getReceptor());
	}
	public Perfil getEmissor () {
		return this.emissor;
	}
	public Perfil getReceptor () {
		return this.receptor;
	}
	public RepositorioMensagens getMensagens () {
		return this.mensagens;
	}
	// Permuta os atributos emissor e receptor
	public void inverter () {
		Perfil aux = this.emissor;
		this.emissor = this.receptor;
		this.receptor = aux;
	}
	public void inserir (Mensagem novaMensagem) {
		this.mensagens.inserir(novaMensagem);
	}
}