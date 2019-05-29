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
	                        }
57
                } else
58
                        throw new GrupoNaoEncontradoException();
59
                return null;
60
        }
61
​
62
        public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
63
                if (!checarGrupo(nome_Novo)) {
64
                if (checarGrupo(nome_Antigo)) {
65
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
66
                                if (this.arrayGrupos[i].getNome().equals(nome_Antigo)) {
67
                                        this.arrayGrupos[i].setNome(nome_Novo);
68
                                        return;
69
                                }
70
                        }
71
                } else
72
                        throw new GrupoNaoEncontradoException();
73
                } else
74
                        throw new GrupoJaCadastradoException();
75
        }
76
​
77
        public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
78
                if (checarGrupo(descricao_Antigo)) {
79
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
80
                                if (this.arrayGrupos[i].getDescricao().equals(descricao_Antigo)) {
81
                                        this.arrayGrupos[i].setDescricao(descricao_Novo);
82
                                        return;
83
                                }
84
                        }
85
                } else
86
                        throw new GrupoNaoEncontradoException();
87
        }
88
​
89
        public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
90
                if (!checarGrupo(grupo.getNome())) {
91
                        if (checarGrupo(nome)) {
92
                                for (int i = 0; i < this.arrayGrupos.length; i++) {
93
                                        if (this.arrayGrupos[i].getNome().equals(nome)) {
94
                                                this.arrayGrupos[i].setNome(grupo.getNome());
95
                                                this.arrayGrupos[i].setDescricao(grupo.getDescricao());
96
                                                return;
97
                                        }
98
                                }
99
                        } else
100
                                throw new GrupoNaoEncontradoException();
101
                } else
102
                        throw new GrupoJaCadastradoException();
103
                              }
57
                } else
58
                        throw new GrupoNaoEncontradoException();
59
                return null;
60
        }
61
​
62
        public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
63
                if (!checarGrupo(nome_Novo)) {
64
                if (checarGrupo(nome_Antigo)) {
65
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
66
                                if (this.arrayGrupos[i].getNome().equals(nome_Antigo)) {
67
                                        this.arrayGrupos[i].setNome(nome_Novo);
68
                                        return;
69
                                }
70
                        }
71
                } else
72
                        throw new GrupoNaoEncontradoException();
73
                } else
74
                        throw new GrupoJaCadastradoException();
75
        }
76
​
77
        public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
78
                if (checarGrupo(descricao_Antigo)) {
79
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
80
                                if (this.arrayGrupos[i].getDescricao().equals(descricao_Antigo)) {
81
                                        this.arrayGrupos[i].setDescricao(descricao_Novo);
82
                                        return;
83
                                }
84
                        }
85
                } else
86
                        throw new GrupoNaoEncontradoException();
87
        }
88
​
89
        public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
90
                                     }
57
                } else
58
                        throw new GrupoNaoEncontradoException();
59
                return null;
60
        }
61
​
62
        public void atualizarNome(String nome_Antigo, String nome_Novo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
63
                if (!checarGrupo(nome_Novo)) {
64
                if (checarGrupo(nome_Antigo)) {
65
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
66
                                if (this.arrayGrupos[i].getNome().equals(nome_Antigo)) {
67
                                        this.arrayGrupos[i].setNome(nome_Novo);
68
                                        return;
69
                                }
70
                        }
71
                } else
72
                        throw new GrupoNaoEncontradoException();
73
                } else
74
                        throw new GrupoJaCadastradoException();
75
        }
76
​
77
        public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
78
                if (checarGrupo(descricao_Antigo)) {
79
                        for (int i = 0; i < this.arrayGrupos.length; i++) {
80
                                if (this.arrayGrupos[i].getDescricao().equals(descricao_Antigo)) {
81
                                        this.arrayGrupos[i].setDescricao(descricao_Novo);
82
                                        return;
83
                                }
84
                        }
85
                } else
86
                        throw new GrupoNaoEncontradoException();
87
        }
88
​
89
        public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
90
                if (!checarGrupo(grupo.getNome())) {
91
                        if (checarGrupo(nome)) {
92
                                for (int i = 0; i < this.arrayGrupos.length; i++) {
93
                                        if (this.arrayGrupos[i].getNome().equals(nome)) {
94
                                                this.arrayGrupos[i].setNome(grupo.getNome());
95
                                                this.arrayGrupos[i].setDescricao(grupo.getDescricao());
96
                                                return;
97
                                        }
98
                                }
99
                        } else
100
                                throw new GrupoNaoEncontradoException();
101
                } else
102
                        throw new GrupoJaCadastradoException();
103
        }
104
​
105
}
106
   if (!checarGrupo(grupo.getNome())) {
91
                        if (checarGrupo(nome)) {
92
                                for (int i = 0; i < this.arrayGrupos.length; i++) {
93
                                        if (this.arrayGrupos[i].getNome().equals(nome)) {
94
                                                this.arrayGrupos[i].setNome(grupo.getNome());
95
                                                this.arrayGrupos[i].setDescricao(grupo.getDescricao());
96
                                                return;
97
                                        }
98
                                }
99
                        } else
100
                                throw new GrupoNaoEncontradoException();
101
                } else
102
                        throw new GrupoJaCadastradoException();
103
        }
104
​
105
}
106
  }
104
​
105
}
106
		} else
				throw new GrupoNaoEncontradoException();
		} else
			throw new GrupoJaCadastradoException();
	}

}
