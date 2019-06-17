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
     public void cadastrarConversa (Conversa novaConversa) throws RepositorioException, ConversaReiniciadaException, NaoSaoContatosException, PerfilNotFoundException {
    	if (perfis.existe(novaConversa.getEmissor()) && perfis.existe(novaConversa.getReceptor())) {
    		conversas.cadastrar(novaConversa);
    	} else {
    		throw new PerfilNotFoundException();
    	}
    }
    
    public void atualizarConversa (Conversa conversaAlterada) throws ConversaNaoEncontradaException {
    	conversas.atualizar(conversaAlterada);
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

    public void enviarMensagem (Mensagem mensagem) {
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

