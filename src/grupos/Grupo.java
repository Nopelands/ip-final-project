package grupos;

import perfis.*;
import mensagens.*;

public class Grupo {
	private String nome;
	private RepositorioPerfis listaNomes;
	private String descricao;
	private RepositorioMensagens listaMensagens;
	
	
	public Grupo(String nome, String descricao, RepositorioPerfis repositorioPerfis, RepositorioMensagens repositorioMensagens) {
		this.nome = nome;
		this.descricao = descricao;
		this.listaNomes = repositorioPerfis;
		this.listaMensagens = repositorioMensagens;
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return this.nome;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public RepositorioPerfis getListaNomes() {
        return listaNomes;
    }
	
	public void inserirMensagem(Mensagem mensagem) {
		this.listaMensagens.inserir(mensagem);
			
	}
	
	public void removerMensagem(Mensagem mensagem) throws MensagemNaoEncontradaException {
		this.listaMensagens.remover(mensagem);
			
	}
	
	public void inserirPerfil(Perfil perfil) {
		this.listaNomes.inserir(perfil);
			
	}
	
	public void removerPerfil(String numero) throws PerfilNotFoundException {
		this.listaNomes.remover(numero);
			
	}
	
	public RepositorioMensagens getListaMensagens() {
        return listaMensagens;
    }
	
	public boolean equals(Grupo grupo) {
        return this.nome.equals(grupo.getNome());
    }

}
