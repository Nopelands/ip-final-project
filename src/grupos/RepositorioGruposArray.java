package grupos;

import mensagens.Mensagem;

public class RepositorioGruposArray implements RepositorioGrupos {
	
 	Grupos[] arrayGrupos;
 	
	public RepositorioGruposArray() {
		this.arrayGrupos = new Grupos[0];
	}

	public void inserir(Grupos grupo) throws GrupoJaCadastradoException{
		Grupos[] temp = new Grupos[arrayGrupos.length + 1];
		if (!checarGrupo(grupo.getNome())) {
			for (int i = 0; i < arrayGrupos.length; i++) {
				temp[i] = arrayGrupos[i];
			}
		} else
			throw new GrupoJaCadastradoException();
		temp[temp.length - 1] = grupo;
        arrayGrupos = temp;
	}

	public void remover(Grupos grupo) throws GrupoNaoEncontradoException{
		if (checarGrupo(grupo.getNome())) {
			Grupos[] aux = new Grupos[arrayGrupos.length - 1];
			for (int i = 0, j = 0; i < aux.length; i++) {
				if (!this.arrayGrupos[j].getNome().equals(grupo.getNome())) {
					aux[i] = this.arrayGrupos[j];
					
				}
				
			}
		arrayGrupos = aux;
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
