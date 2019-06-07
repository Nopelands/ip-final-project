package grupos;

public interface RepositorioGrupos {

	public void inserirGrupo (Grupo grupo) throws GrupoJaCadastradoException;
	
	public void removerGrupo (Grupo grupo) throws GrupoNaoEncontradoException;
	
	public Grupo procurarGrupo(String nome) throws GrupoNaoEncontradoException;
	
	public void atualizarGrupo(Grupo grupo) throws GrupoNaoEncontradoException;
			
	public boolean checarGrupo (String nome);
}
