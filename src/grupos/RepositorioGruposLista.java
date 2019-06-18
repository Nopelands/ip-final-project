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

	public boolean existe(String nome) {
		boolean retorno = false;

		if (this.grupo != null) {
			if (this.grupo.getNome().equals(nome)) {
				retorno = true;
			} else
				retorno = this.proximo.existe(nome);
		} else
			retorno = false;

		return retorno;
	}

	public void cadastrar(Grupo grupo) {
		
			if (this.grupo == null) {
				this.grupo = grupo;
				this.proximo = new RepositorioGruposLista();
			} else {
				this.proximo.cadastrar(grupo);
			}
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
        if (this.existe(grupo.getNome())) {
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
