package mensageiro;

import perfis.*;
import mensagens.*;
import grupos.*;
import conversas.*;

public class Mensageiro {
    private CadastroPerfis perfis;
    private CadastroMensagens mensagens;
    private CadastroConversas conversas;
    private CadastroGrupos grupos;

    public Mensageiro(RepositorioPerfis repositorioPerfis, RepositorioConversas repositorioConversas, RepositorioGrupos repositorioGrupos, RepositorioMensagens repositorioMensagens) {
        this.mensagens = new CadastroMensagens(repositorioMensagens);
        this.perfis = new CadastroPerfis(repositorioPerfis);
        this.conversas = new CadastroConversas(repositorioConversas);
        this.grupos = new CadastroGrupos(repositorioGrupos);
    }
    
    // Conversa
    
    /* O metodo cadastrar(Conversa) da classe fachada define, como regra de negocio, que
     * a conversa recebida como parametro so podera ser cadastrada se:
     * 1. Os perfis envolvidos ja tiverem ambos sido cadastrados;
     * 2. Todas as mensagens inseridas ja tiverem sido cadastradas.
     * */
     public void cadastrar (Conversa novaConversa) throws RepositorioException, ConversaReiniciadaException, NaoSaoContatosException, PerfilNotFoundException, MensagemNaoEncontradaException {
    	if (this.perfis.existe(novaConversa.getEmissor()) && this.perfis.existe(novaConversa.getReceptor())) {
    		Mensagem[] mensagens = novaConversa.getMensagens();
    		boolean existeUmaMensagemNaoCadastrada = false;
    		for (int i = 0; i < mensagens.length && !existeUmaMensagemNaoCadastrada; i++) {
    			if (!this.mensagens.existe(mensagens[i])) {
    				existeUmaMensagemNaoCadastrada = true;
    			}
    		}
    		if (!existeUmaMensagemNaoCadastrada) {
    			this.conversas.cadastrar(novaConversa);
    		} else {
    			throw new MensagemNaoEncontradaException();
    		}
    	} else {
    		throw new PerfilNotFoundException();
    	}
    }
    
    public void atualizar (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
    	this.conversas.atualizar(conversaAlterada);
    }
    
    public Conversa procurar (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
    	return this.conversas.procurar(emissor, receptor);
    }
    
    public void remover (Perfil destruidor, Perfil conservador) throws ConversaNaoEncontradaException {
    	this.conversas.remover(destruidor, conservador);
    }
    
    // Grupo
    
    public void cadastrar(Grupo grupo) throws GrupoJaCadastradoException {
		grupos.cadastrar(grupo);
    }
    
    public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
    	grupos.remover(grupo);
    }
    
    public Grupo procurar(String nome) throws GrupoNaoEncontradoException {
    	return grupos.procurar(nome);
    }
    
    public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException {
		grupos.atualizar(grupo);
	}
    
    public boolean existe(String nome) {
    	return grupos.existe(nome);
    }
    
    //Perfil

    public void cadastrarPerfil(Perfil perfil) throws PerfilJaCadastradoException{
        perfis.cadastrar(perfil);
    }

    public void removerPerfil(Perfil perfil) throws PerfilNotFoundException {
        perfis.remover(perfil);
    }
    public Perfil procurarPerfil(String number) throws PerfilNotFoundException {
        return perfis.procurar(number);
    }

    public boolean existePerfil(Perfil perfil) {
        return perfis.existe(perfil);
    }
    public void atualizarPerfil(Perfil perfil) throws PerfilNotFoundException {
        perfis.atualizar(perfil);
    }
    //????

    //Mensagens

    public void cadastrar (Mensagem mensagem) {
        this.mensagens.cadastrar(mensagem);
    }
    public void remover (Mensagem mensagem) throws MensagemNaoEncontradaException{
        this.mensagens.remover(mensagem);
    }

    public void atualizar (Mensagem mensagem) throws IdentificacaoNaoEncontradaException{
        this.mensagens.atualizar(mensagem);
    }
    public boolean existe (Mensagem mensagem){
        return mensagens.existe(mensagem);
    }
    public Mensagem procurar (int identificacao) throws IdentificacaoNaoEncontradaException{
        return mensagens.procurar(identificacao);
    }
}


