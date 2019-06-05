package grupos;
import perfis.*;
import mensagens.*;


public class CadastroGrupos implements RepositorioGrupos{
	private RepositorioGrupos repositorio;
	

	public CadastroGrupos(RepositorioGrupos repositorio) {
		this.repositorio = repositorio;
	}

	public Grupo procurar(String nome) throws GrupoNaoEncontradoException{
		return repositorio.procurar(nome);
	}

	public boolean checarGrupo(String nome) {
		return repositorio.checarGrupo(nome);
	}

	public void inserir(Grupo grupo) throws GrupoJaCadastradoException {
		repositorio.inserir(grupo);
	}

	public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
		repositorio.remover(grupo);
	}
	
	public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException{
		repositorio.atualizar(grupo);
	}


}
