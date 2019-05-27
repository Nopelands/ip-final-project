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

	public void remover(String nome) throws GrupoNaoEncontradoException{
		if (checarGrupo(nome)) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(nome)) {
					for (int j = i; j < (this.arrayGrupos.length - 1); j++) {
						this.arrayGrupos[j] = this.arrayGrupos[j + 1];
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

	public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
		if (!checarGrupo(nome_Novo)) {
		if (checarGrupo(nome_Antigo)) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(nome_Antigo)) {
					this.arrayGrupos[i].setNome(nome_Novo);
					return;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
		} else
			throw new GrupoJaCadastradoException();
	}

	public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
		if (checarGrupo(descricao_Antigo)) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getDescricao().equals(descricao_Antigo)) {
					this.arrayGrupos[i].setDescricao(descricao_Novo);
					return;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
	}

	public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
		if (!checarGrupo(grupo.getNome())) {
		if (checarGrupo(nome)) {
			for (int i = 0; i < this.arrayGrupos.length; i++) {
				if (this.arrayGrupos[i].getNome().equals(nome)) {
					this.arrayGrupos[i].setNome(grupo.getNome());
					this.arrayGrupos[i].setDescricao(grupo.getDescricao());
					return;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
		} else
			throw new GrupoJaCadastradoException();
	}

}
