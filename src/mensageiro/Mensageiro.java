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
    
    public void enviarMensagemPrivado (Perfil remetente, Perfil destinatario, Mensagem novaMensagem) throws ConversaReiniciadaException, RepositorioException, NaoSaoContatosException, PerfilNotFoundException {
    	if (!perfis.existe(remetente) || !perfis.existe(destinatario)) {
    		throw new PerfilNotFoundException();
    	}
    	RepositorioMensagensLista mensagens = new RepositorioMensagensLista();
		mensagens.inserir(novaMensagem);
		Conversa possivelNovaConversa = new Conversa (remetente, destinatario, mensagens);
    	try {
    		Conversa ordemDireta = conversas.procurarConversa(possivelNovaConversa);
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

    public Mensageiro(RepositorioGrupos repositorioGrupos) {
    	this.grupos = new CadastroGrupos(repositorioGrupos);
    }
    
    //NegocioGrupos
    
    public void inserir (Grupos grupo) throws GrupoJaCadastradoException {
		grupos.inserir(grupo);
    }
    
    public void remover (Grupos grupo) throws GrupoNaoEncontradoException{
    	grupos.remover(grupo);
    }
    
    public Grupos procurar(String nome) throws GrupoNaoEncontradoException{
    	return grupos.procurar(nome);
    }
    
    public void atualizar(Grupos grupo) throws GrupoNaoEncontradoException{
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

    //TODO more TODOs
    
}
