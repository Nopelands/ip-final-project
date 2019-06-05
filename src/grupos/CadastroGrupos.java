package grupos;
import perfis.*;
import mensagens.*;


public class CadastroGrupos{
	private RepositorioGrupos repositorio;
	

	public CadastroGrupos(RepositorioGrupos repositorio) {
		this.repositorio = repositorio;
	}

	public Grupos procurar(String nome) throws GrupoNaoEncontradoException{
		return repositorio.procurar(nome);
	}

	public boolean checarGrupo(String nome) {
		return repositorio.checarGrupo(nome);
	}

	public void inserir(Grupos grupo) throws GrupoJaCadastradoException {
		repositorio.inserir(grupo);
	}

	public void remover(Grupos grupo) throws GrupoNaoEncontradoException {
		repositorio.remover(grupo);
	}
	
	public void atualizar(Grupos grupo) throws GrupoNaoEncontradoException{
		repositorio.atualizar(grupo);
	}


}
