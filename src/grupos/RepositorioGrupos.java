package grupos;

public interface RepositorioGrupos {

	public void inserir (Grupos grupo) throws GrupoJaCadastradoException;
	
	public void remover (Grupos grupo) throws GrupoNaoEncontradoException;
	
	public Grupos procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizar(Grupos grupo) throws GrupoNaoEncontradoException;
			
	public boolean checarGrupo (String nome);
}
