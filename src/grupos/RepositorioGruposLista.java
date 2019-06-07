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

	public Grupo procurarGrupo(String nome) throws GrupoNaoEncontradoException{
		Grupo retorno;
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				retorno = this.grupo;
			} else
				try {
				retorno = this.proximo.procurarGrupo(nome);
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

	public void inserirGrupo(Grupo grupo) {
		
			if (this.grupo == null) {
				this.grupo = grupo;
				this.proximo = new RepositorioGruposLista();
			} else {
				this.proximo.inserirGrupo(grupo);
			}
	}

	public void removerGrupo(Grupo grupo) throws GrupoNaoEncontradoException{
		if (this.grupo != null) {
			if (this.grupo.getNome().equals(grupo.getNome())) {
				this.grupo = this.proximo.grupo;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.removerGrupo(grupo);
		} else
			throw new GrupoNaoEncontradoException();
	}
	
	public void atualizarGrupo(Grupo grupo) throws GrupoNaoEncontradoException{
        if (this.checarGrupo(grupo.getNome())) {
            if (this.grupo.equals(grupo)) {
                this.grupo = grupo;
            } else {
                this.atualizarGrupo(grupo);
            }
        } else {
            throw new GrupoNaoEncontradoException();
        }
    }

	

}
