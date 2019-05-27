package grupos;

public interface RepositorioGrupos {

	public void inserir (Grupos grupo) throws GrupoJaCadastradoException;
	
	public void remover (String nome) throws GrupoNaoEncontradoException;
	
	public Grupos procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException;
	
	public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException;
	
	public boolean checarGrupo (String nome);
}
