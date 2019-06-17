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

    public Mensageiro(CadastroPerfis cadastroPerfis, CadastroConversas cadastroConversas, CadastroGrupos cadastroGrupos, CadastroMensagens cadastroMensagens) {
        this.mensagens = cadastroMensagens;
        this.perfis = cadastroPerfis;
        this.conversas = cadastroConversas;
        this.grupos = cadastroGrupos;
    }
    
    // Conversa
    
    /* O método cadastrar(Conversa) da classe fachada define, como regra de negócio, que
     * a conversa recebida como parâmetro só poderá ser cadastrada se:
     * 1. Os perfis envolvidos já tiverem ambos sido cadastrados;
     * 2. Todas as mensagens inseridas já tiverem sido cadastradas.
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
		grupos.inserirGrupo(grupo);
    }
    
    public void remover(Grupo grupo) throws GrupoNaoEncontradoException {
    	grupos.removerGrupo(grupo);
    }
    
    public Grupo procurar(String nome) throws GrupoNaoEncontradoException {
    	return grupos.procurarGrupo(nome);
    }
    
    public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException {
		grupos.atualizarGrupo(grupo);
	}
    
    public boolean existe(String nome) {
    	return grupos.checarGrupo(nome);
    }
    
    //Perfil

    public void criarUser (Perfil novoUsuario) throws PerfilJaCadastradoException {
    	this.perfis.cadastrar(novoUsuario);
    }
    
    public void changeGreeting(String number, String newGreeting) throws PerfilNotFoundException{
        Perfil perfil = perfis.procurar(number);
        perfil.setPhrase(newGreeting);
        perfis.atualizar(perfil);
    }

    public String getGreeting(String number) throws PerfilNotFoundException{
        return perfis.procurar(number).getPhrase();
    }

    public String getNome(String number) throws PerfilNotFoundException {
        return perfis.procurar(number).getName();
    }

    public void adicionarContato(String numberAdd, String numberContato) throws PerfilJaCadastradoException, PerfilNotFoundException{
        perfis.adicionarContato(numberAdd, numberContato);
    }
    public void removerContato(String numberRemove, String numberContato) throws PerfilNotFoundException{
        perfis.removerContato(numberRemove, numberContato);
    }

    public Perfil procurarPerfil(String number) throws PerfilNotFoundException{
        return perfis.procurar(number);
    }

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


