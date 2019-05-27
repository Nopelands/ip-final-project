package grupos;

public interface RepositorioGrupos {

	public void inserir (Grupos grupo) throws GrupoJaCadastradoException;
	
	public void remover (String nome) throws GrupoNaoEncontradoException;
	
	public Grupos procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException;
	
	public void atualizarDescricao(String descricao_antigo, String descricao_novo) throws GrupoNaoEncontradoException;
	
	public boolean checarGrupo (String nome);
}
