package grupos;

public class NegociosGrupos implements RepositorioGrupos{
	private RepositorioGrupos repositorio;

	public NegociosGrupos(RepositorioGrupos repositorio) {
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

	public void remover(String nome) throws GrupoNaoEncontradoException {
		repositorio.remover(nome);
	}

	public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException {
		repositorio.atualizarNome(nome_Antigo, nome_Novo);
	}

	public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
		repositorio.atualizarDescricao(descricao_Antigo, descricao_Novo);
	}

	public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
		repositorio.atualizarGrupo(nome, grupo);
	}

}
