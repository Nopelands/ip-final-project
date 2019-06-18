package grupos;

import mensagens.Mensagem;
import perfis.Perfil;
import perfis.PerfilNotFoundException;

public class RepositorioGruposArray implements RepositorioGrupos {
	
 	Grupo[] arrayGrupos;
 	
	public RepositorioGruposArray() {
		this.arrayGrupos = new Grupo[0];
	}

	public void cadastrar(Grupo grupo){
		Grupo[] temp = new Grupo[arrayGrupos.length + 1];
			for (int i = 0; i < arrayGrupos.length; i++) {
				temp[i] = arrayGrupos[i];
			}
		temp[temp.length - 1] = grupo;
        arrayGrupos = temp;
	}

	public void remover(Grupo grupo) throws GrupoNaoEncontradoException{
		if (existe(grupo.getNome())) {
			Grupo[] aux = new Grupo[arrayGrupos.length - 1];
			for (int i = 0, j = 0; i < aux.length; i++) {
				if (!this.arrayGrupos[j].getNome().equals(grupo.getNome())) {
					aux[i] = this.arrayGrupos[j];
					
				}
				
			}
		arrayGrupos = aux;
		} else
			throw new GrupoNaoEncontradoException();
	}

	public boolean existe(String nome) {
		for (int i = 0; i < this.arrayGrupos.length; i++) {
			if (this.arrayGrupos[i] != null && this.arrayGrupos[i].getNome().equals(nome)){
				return true;
			}
		}
		return false;
	}

	public Grupo procurar(String nome) throws GrupoNaoEncontradoException{
		Grupo retorno;
		if (existe(nome)) {
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

 
	public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException {
        for (int i = 0; i < this.arrayGrupos.length; i++) {
            if (this.existe(grupo.getNome())) {
                if (arrayGrupos[i].getNome().equals(grupo.getNome())) {
                	arrayGrupos[i] = grupo;
                }
            } else {
                throw new GrupoNaoEncontradoException();
            }
        }

    }
	

}
