package mensageiro;
import perfis.*;
import mensagens.*;
import grupos.*;
import conversas.*;

public class Mensageiro {
    private CadastroPerfis cadastroPerfis;
    private CadastroMensagens cadastroMensagens;
    //TODO private CadastroGrupos cadastroGrupos;
    //TODO private CadastroConversas cadastroConversas;
    private CadastroGrupos grupos;
    
    public Mensageiro(RepositorioGrupos repositorioGrupos) {
    	this.grupos = new CadastroGrupos(repositorioGrupos);
    }
    
    //NegocioGrupos
    
    public void inserir (Grupos grupo) throws GrupoJaCadastradoException {
		grupos.inserir(grupo);
    }
    
    public void remover (String nome) throws GrupoNaoEncontradoException{
    	grupos.remover(nome);
    }
    
    public Grupos procurar(String nome) throws GrupoNaoEncontradoException{
    	return grupos.procurar(nome);
    }
    
    public void atualizarGrupo(String nome, Grupos grupo) throws GrupoNaoEncontradoException, GrupoJaCadastradoException{
    	grupos.atualizarGrupo(nome, grupo);
    }
    
    public void atualizarDescricao(String descricao_Antigo, String descricao_Novo) throws GrupoNaoEncontradoException{
    	grupos.atualizarDescricao(descricao_Antigo, descricao_Novo);
    }
    
    public boolean checarGrupo (String nome) {
    	return grupos.checarGrupo(nome);
    }

    //TODO cadastrar()
    //TODO criarGrupo()
    //TODO more TODOs
}
