package grupos;

public interface RepositorioGrupos {

	public void inserir (Grupo grupo) throws GrupoJaCadastradoException;
	
	public void remover (Grupo grupo) throws GrupoNaoEncontradoException;
	
	public Grupo procurar(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException;
			
	public boolean checarGrupo (String nome);
}
