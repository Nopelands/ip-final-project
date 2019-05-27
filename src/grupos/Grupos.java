package grupos;

import perfis.*;
import mensagens.*;

public class Grupos {
	private String nome;
	private RepositorioPerfis listaNomes;
	private String descricao;
	private RepositorioMensagens listaMensagens;
	
	public Grupos(String name, String number, RepositorioPerfis repositorioPerfis, RepositorioMensagens repositorioMensagens) {
		this.nome = null;
		this.descricao = null;
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
	
	public void inserirPerfil(Perfil perfil) {
		this.listaNomes.inserir(perfil);
			
	}
	
	public void removerPerfil(String numero) throws PerfilNotFoundException {
		this.listaNomes.remover(numero);
			
	}
	
	public RepositorioMensagens getListaMensagens() {
        return listaMensagens;
    }

}
