package grupos;

public class RepositorioGruposArray implements RepositorioGrupos {
	
 	Grupos[] arrayGrupos;
 	
	public RepositorioGruposArray() {
		this.arrayGrupos = new Grupos[200];
	}

	public void inserir(Grupos grupo) throws GrupoJaCadastradoException{
		boolean parar = false;
		if (!checarGrupo(grupo.getNome())) {
			for (int i = 0; i < arrayGrupos.length && !parar; i++) {
				if (this.arrayGrupos[i] == null) {
					this.arrayGrupos[i] = grupo;
					parar = true;
				}
			}
		} else
			throw new GrupoJaCadastradoException();
	}

	public void remover(Grupos grupo) throws GrupoNaoEncontradoException{
		if (checarGrupo(grupo.getNome())) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(grupo.getNome())) {
					for (int j = i; j < (this.arrayGrupos.length - 1); j++) {
						this.arrayGrupos[j] = null;
					}
					
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
	}

	public boolean checarGrupo(String nome) {
		for (int i = 0; i < this.arrayGrupos.length; i++) {
			if (this.arrayGrupos[i] != null && this.arrayGrupos[i].getNome().equals(nome)){
				return true;
			}
		}
		return false;
	}

	public Grupos procurar(String nome) throws GrupoNaoEncontradoException{
		Grupos retorno;
		if (checarGrupo(nome)) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(nome)) {
					retorno = this.arrayGrupos[i];
					return retorno;
				}

			}
		} else
			throw new GrupoNaoEncontradoException();
		return null;
	}


	public void atualizarDescricao(Grupos grupo, String descricao_Novo) throws GrupoNaoEncontradoException{
		if (checarGrupo(grupo.getNome())) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getDescricao().equals(grupo.getDescricao())) {
					this.arrayGrupos[i].setDescricao(descricao_Novo);
					return;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
	}
	
	public void atualizarNome(Grupos grupo, String nome_Novo) throws GrupoNaoEncontradoException{
		if (checarGrupo(grupo.getNome())) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(grupo.getNome())) {
					this.arrayGrupos[i].setNome(nome_Novo);
					return;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
	}

	

}
