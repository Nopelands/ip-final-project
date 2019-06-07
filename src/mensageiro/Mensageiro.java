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
    
    public void enviarMensagemPrivado (Perfil remetente, Perfil destinatario, Mensagem novaMensagem, RepositorioMensagens mensagens) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException, PerfilNotFoundException {
    	if (!perfis.existe(remetente) || !perfis.existe(destinatario)) {
    		throw new PerfilNotFoundException();
    	}
    	this.mensagens.cadastrar(novaMensagem);
		mensagens.inserir(novaMensagem);
		Conversa possivelNovaConversa = new Conversa (remetente, destinatario, mensagens);
    	try {
    		Conversa ordemDireta = conversas.procurarConversa(remetente, destinatario);
    		ordemDireta.inserir(novaMensagem);
    		conversas.atualizarConversa(ordemDireta);
    		
    	} catch (ConversaNaoEncontradaException e) {
    		conversas.iniciarConversa(possivelNovaConversa);
    	}
    	try {
    		possivelNovaConversa.inverter();
    		Conversa ordemInversa = conversas.procurarConversa(destinatario, remetente);
    		ordemInversa.inserir(novaMensagem);
    		conversas.atualizarConversa(ordemInversa);
    	} catch (ConversaNaoEncontradaException e) {
    		conversas.iniciarConversa(possivelNovaConversa);
    	}
    }
    
    public void limparConversaUnilateral (Perfil destruidor, Perfil conservador) throws ConversaNaoEncontradaException {
    	conversas.apagarConversa(destruidor, conservador);
    }
    
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
    
    //Grupo
    
    public void inserirGrupo (Grupo grupo) throws GrupoJaCadastradoException {
		grupos.inserirGrupo(grupo);
    }
    
    public void removerGrupo (Grupo grupo) throws GrupoNaoEncontradoException{
    	grupos.removerGrupo(grupo);
    }
    
    public Grupo procurarGrupo(String nome) throws GrupoNaoEncontradoException{
    	return grupos.procurarGrupo(nome);
    }
    
    public void atualizarGrupo(Grupo grupo) throws GrupoNaoEncontradoException{
		grupos.atualizarGrupo(grupo);
	}
    
    public boolean checarGrupo (String nome) {
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

    //Mensagens

    public void enviarMensagem (Mensagem mensagem) {
        this.mensagens.cadastrar(mensagem);
    }

    public String getMensagem(Mensagem mensagem){
        return mensagem.getMensagem();
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

