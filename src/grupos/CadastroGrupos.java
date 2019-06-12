package grupos;
import perfis.*;
import mensagens.*;


public class CadastroGrupos{
	private RepositorioGrupos repositorio;
	

	public CadastroGrupos(RepositorioGrupos repositorio) {
		this.repositorio = repositorio;
	}

	public Grupo procurarGrupo(String nome) throws GrupoNaoEncontradoException{
		return repositorio.procurarGrupo(nome);
	}

	public boolean checarGrupo(String nome) {
		return repositorio.checarGrupo(nome);
	}

	public void inserirGrupo(Grupo grupo) throws GrupoJaCadastradoException {
		if (!repositorio.checarGrupo(grupo.getNome())) {
            repositorio.inserirGrupo(grupo);
		}else {
			throw new GrupoJaCadastradoException();
		}
	}

	public void removerGrupo(Grupo grupo) throws GrupoNaoEncontradoException {
		repositorio.removerGrupo(grupo);
	}
	
	public void atualizarGrupo(Grupo grupo) throws GrupoNaoEncontradoException{
		repositorio.atualizarGrupo(grupo);
	}


}
