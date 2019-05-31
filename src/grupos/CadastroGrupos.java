package grupos;
import perfis.*;
import mensagens.*;


public class CadastroGrupos implements RepositorioGrupos{
	private RepositorioGrupos repositorio;
	

	public CadastroGrupos(RepositorioGrupos repositorio) {
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

	public void remover(Grupos grupo) throws GrupoNaoEncontradoException {
		repositorio.remover(grupo);
	}
	
	public void inserirPerfil(Grupos grupo, Perfil perfil) throws PerfilJaCadastradoNoGrupoException{
		if (!grupo.getListaNomes().existe(perfil.getNumber())) {
			grupo.getListaNomes().inserir(perfil);
        } else {
            throw  new PerfilJaCadastradoNoGrupoException();
        }
	}
	
	public void removerPerfil(Grupos grupo, Perfil perfil) throws PerfilNotFoundException {
		grupo.getListaNomes().remover(perfil.getNumber());
    }

	public void atualizarDescricao(Grupos grupo, String descricao_Novo) throws GrupoNaoEncontradoException{
		repositorio.atualizarDescricao(grupo, descricao_Novo);
	}

	public void atualizarNome(Grupos grupo, String nome_Novo) throws GrupoNaoEncontradoException{
		repositorio.atualizarNome(grupo, nome_Novo);
	}

}
