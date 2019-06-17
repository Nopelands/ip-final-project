package conversas;

import mensagens.*;
import perfis.*;

public class Conversa {
	private RepositorioMensagensArray mensagens;
	private Perfil emissor;
	private Perfil receptor;
	public Conversa (Perfil emissor, Perfil receptor, RepositorioMensagensArray mensagens) {
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
	public Mensagens[] getMensagens () {
		return this.mensagens.getIterator();
	}
	public void inserir (Mensagem novaMensagem) {
		this.mensagens.inserir(novaMensagem);
	}
}