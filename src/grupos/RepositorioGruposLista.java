package grupos;

import perfis.Perfil;
import perfis.PerfilNotFoundException;

public class RepositorioGruposLista implements RepositorioGrupos {
	private Grupo grupo;
	private RepositorioGruposLista proximo;

	public RepositorioGruposLista() {
		grupo = null;
		proximo = null;
	}

	public Grupo procurar(String nome) throws GrupoNaoEncontradoException{
		Grupo retorno;
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

	public void inserir(Grupo grupo) throws GrupoJaCadastradoException {
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

	public void remover(Grupo grupo) throws GrupoNaoEncontradoException{
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(grupo.getNome())) {
				this.grupo = this.proximo.grupo;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.remover(grupo);
		} else
			throw new GrupoNaoEncontradoException();
	}
	
	public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException{
        if (this.checarGrupo(grupo.getNome())) {
            if (this.grupo.equals(grupo)) {
                this.grupo = grupo;
            } else {
                this.atualizar(grupo);
            }
        } else {
            throw new GrupoNaoEncontradoException();
        }
    }

	

}
