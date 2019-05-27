package group;

public class RepositorioGruposLista implements RepositorioGrupos {
	private Grupos grupo;
	private RepositorioGruposLista proximo;

	public RepositorioGruposLista() {
		grupo = null;
		proximo = null;
	}

	public Grupos procurar(String nome) throws GrupoNaoEncontradoException{
		Grupos retorno;
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				retorno = this.grupo;
			} else
				try {
				retorno = this.proximo.procurar(nome);
				}catch(GrupoNaoEncontradoException e) {
					throw e;
				}
		} else
			throw new GrupoNaoEncontradoException();

		return retorno;
	}

	public boolean checarGrupo(String nome) {
		boolean retorno = false;

		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				retorno = true;
			} else
				retorno = this.proximo.checarGrupo(nome);
		} else
			retorno = false;

		return retorno;
	}

	public void inserir(Grupos grupo) throws GrupoJaCadastradoException {
		if (!checarGrupo(grupo.getNome())) {
			if (this.grupo == null) {
				this.grupo = grupo;
				this.proximo = new RepositorioGruposLista();
			} else {
				this.proximo.inserir(grupo);
			}
		} else
			throw new GrupoJaCadastradoException();
	}

	public void remover(String nome) throws GrupoNaoEncontradoException{
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				this.grupo = this.proximo.grupo;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.remover(nome);
		} else
			throw new GrupoNaoEncontradoException();
	}

	public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
		if (!checarGrupo(nome_Novo)) {
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome_Antigo)) {
				this.grupo.setNome(nome_Novo);
			} else {
				try {
				this.proximo.atualizarNome(nome_Antigo, nome_Novo);
				}catch(GrupoNaoEncontradoException e) {
					throw e;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
		} else
			throw new GrupoJaCadastradoException();
	}

	public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
		if (this.grupo != null) {
			if (this.grupo.getDescricao().equals(descricao_Antigo)) {
				this.grupo.setDescricao(descricao_Novo);
			} else {
				try {
				this.proximo.atualizarDescricao(descricao_Antigo, descricao_Novo);
				}catch(GrupoNaoEncontradoException e) {
					throw e;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
	}

	public void atualizar(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
		if (!checarGrupo(grupo.getNome())) {
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				this.grupo.setNome(grupo.getNome());
				this.grupo.setDescricao(grupo.getDescricao());
			} else {
				try {
				 this.proximo.atualizar(nome, grupo);
				} catch(GrupoNaoEncontradoException e) {
					throw e;
				}
			}
		} else
			throw new GrupoNaoEncontradoException();
		} else
			throw new GrupoJaCadastradoException();
	}

}
