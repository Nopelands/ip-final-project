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
    		Conversa ordemInversa = conversas.procurarConversa(possivelNovaConversa);
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
    	Grupo resultadoBusca = grupos.procurar(nomeGrupo);
    	if (!resultadoBusca.getListaNomes().existe(novaMensagem.getRemetente().getName()) {
    		throw new RemetenteIntrusoException(resultadoBusca, novaMensagem.getRementente());
    	} else {
    		resultadoBusca.inserirMensagem(novaMensagem);
    		grupos.atualizar(resultadoBusca);
    	}
    }
    
    public void inserir (Grupo grupo) throws GrupoJaCadastradoException {
		grupos.inserir(grupo);
    }
    
    public void remover (Grupo grupo) throws GrupoNaoEncontradoException{
    	grupos.remover(grupo);
    }
    
    public Grupo procurar(String nome) throws GrupoNaoEncontradoException{
    	return grupos.procurar(nome);
    }
    
    public void atualizar(Grupo grupo) throws GrupoNaoEncontradoException{
		grupos.atualizar(grupo);
	}
    
    public boolean checarGrupo (String nome) {
    	return grupos.checarGrupo(nome);
    }

    //perfil metodos
    public void criarUser(boolean contatosTipo, String nome, String number) throws PerfilJaCadastradoException{
        if (contatosTipo) {
            perfis.cadastrar(new Perfil(nome, number, new RepositorioPerfisArray()));
        } else {
            perfis.cadastrar(new Perfil(nome, number, new RepositorioPerfisLista()));
        }
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
}
