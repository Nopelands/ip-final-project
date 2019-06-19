package grupos;
import perfis.*;
import mensagens.*;


public class CadastroGrupos{
	private RepositorioGrupos repositorio;
	

	public CadastroGrupos(RepositorioGrupos repositorio) {
		this.repositorio = repositorio;
	}

	public Grupo procurar(String nome) throws GrupoNaoEncontradoException{
		return repositorio.procurar(nome);
	}

	public boolean existe(String nome) {
		return repositorio.existe(nome);
	}

	public void cadastrar(Grupo grupo) throws GrupoJaCadastradoException {
		if (!repositorio.existe(grupo.getNome())) {
            repositorio.cadastrar(grupo);
		}else {
			throw new GrupoJaCadastradoException();
		}
	}

	public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
		repositorio.remover(grupo);
	}
	
	public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException{
		repositorio.atualizar(grupo);
	}


}
