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
    
    public void enviarMensagemPrivado (Perfil remetente, Perfil destinatario, Mensagem novaMensagem, RepositorioMensagens mensagens) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException, PerfilNotFoundException {
    	if (!perfis.existe(remetente) || !perfis.existe(destinatario)) {
    		throw new PerfilNotFoundException();
    	}
    	this.mensagens.cadastrar(novaMensagem);
    	mensagens.inserir(novaMensagem);
    	try {
    		Conversa ordemDireta = conversas.procurar(remetente, destinatario);
    		ordemDireta.inserir(novaMensagem);
    		conversas.atualizar(ordemDireta);
    		
    	} catch (ConversaNaoEncontradaException e) {
    		Conversa novaConversaDireta = new Conversa (remetente, destinatario, mensagens);
    		conversas.cadastrar (novaConversaDireta);
    	}
    	try {
    		Conversa ordemInversa = conversas.procurar(destinatario, remetente);
    		ordemInversa.inserir(novaMensagem);
    		conversas.atualizar(ordemInversa);
    	} catch (ConversaNaoEncontradaException e) {
    		Conversa possivelNovaConversaInversa = new Conversa (destinatario, remetente, mensagens);
    		conversas.cadastrar (possivelNovaConversaInversa);
    	}
    }
    
    public Conversa procurarConversa (Perfil emissor, Perfil receptor) throws ConversaNaoEncontradaException {
    	return this.conversas.procurar(emissor, receptor);
    }
    
    public void removerConversa (Perfil destruidor, Perfil conservador) throws ConversaNaoEncontradaException {
    	conversas.remover(destruidor, conservador);
    }
    
    // Grupo
    
    public void enviarMensagemGrupo (String nomeGrupo, Mensagem novaMensagem) throws GrupoNaoEncontradoException, RemetenteIntrusoException {
    	Grupo resultadoBusca = grupos.procurarGrupo(nomeGrupo);
    	if (!resultadoBusca.getListaNomes().existe(novaMensagem.getRemetente().getName())) {
    		throw new RemetenteIntrusoException(resultadoBusca, novaMensagem.getRemetente());
    	} else {
    		mensagens.cadastrar(novaMensagem);
    		resultadoBusca.inserirMensagem(novaMensagem);
    		grupos.atualizarGrupo(resultadoBusca);
    	}
    }

    public void inserirGrupo (Grupo grupo) throws GrupoJaCadastradoException {
		grupos.inserirGrupo(grupo);
    }
    
    public void removerGrupo (Grupo grupo) throws GrupoNaoEncontradoException {
    	grupos.removerGrupo(grupo);
    }
    
    public Grupo procurarGrupo(String nome) throws GrupoNaoEncontradoException {
    	return grupos.procurarGrupo(nome);
    }
    
    public void atualizarGrupo(Grupo grupo) throws GrupoNaoEncontradoException {
		grupos.atualizarGrupo(grupo);
	}
    
    public boolean checarGrupo (String nome) {
    	return grupos.checarGrupo(nome);
    }
    
    //Perfil

    //????

    //Mensagens

    public void cadastrarMensagem (Mensagem mensagem) {
        this.mensagens.cadastrar(mensagem);
    }
    public void removerMensagem(Mensagem mensagem) throws MensagemNaoEncontradaException{
        this.mensagens.remover(mensagem);
    }

    public void atualizarMensagem(Mensagem mensagem, String atualizar) throws MensagemNaoEncontradaException{
        this.mensagens.atualizar(mensagem, atualizar);
    }
    public boolean existeMensagem(Mensagem mensagem){
        return mensagens.existe(mensagem);
    }
    public String procurarMensagem(int identificacao) throws IdentificacaoNaoEncontradaException{
        return mensagens.procurar(identificacao);
    }
}

