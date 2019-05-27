package group;

public interface RepositorioGrupos {

	public void inserir (Grupos grupo) throws GrupoJaCadastradoException;
	
	public void remover (String nome) throws GrupoNaoEncontradoException;
	
	public Grupos procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizar(String nome, String descricao) throws GrupoNaoEncontradoException;
	
	public boolean checarGrupo (String nome);
}
