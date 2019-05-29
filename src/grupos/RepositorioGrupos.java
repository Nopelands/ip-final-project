package grupos;

public interface RepositorioGrupos {

	public void inserir (Grupos grupo) throws GrupoJaCadastradoException;
	
	public void remover (Grupos grupo) throws GrupoNaoEncontradoException;
	
	public Grupos procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizarNome(Grupos grupo, String nome_Novo) throws GrupoNaoEncontradoException;
	
	public void atualizarDescricao(Grupos grupo, String descricao_Novo) throws GrupoNaoEncontradoException;
	
	public boolean checarGrupo (String nome);
}
