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

    /* (Desculpem por ser tão prolixo :/)
     * Antes de explanar o funcionamento do método enviarMensagemPrivado, vamos dissecar o seu parâmetro
     * possivelNovaConversa. Sendo ele do tipo Conversa, possui três atributos: dois do tipo Perfil, e um
     * do tipo RepositorioMensagens. Estes já devem vir prontos do main, inicializados da seguinte forma:
     * -(Perfil) emissor = perfil remetente do parâmetro novaMensagem;
     * -(Perfil) receptor = perfil ao qual se destina novaMensagem;
     * -(RepositorioMensagens) mensagens = um repositorio contendo uma única mensagem: novaMensagem.
     * 
     * Mas isso não implicaria uma redundância de parâmetros? Não seria mais simples se enviarMensagemPrivado recebesse apenas o Perfil remetente,
     * o Perfil destinatário e a novaMensagem a ser enviada? Se fizéssemos isso, transferiríamos ao método enviarMensagemPrivado
     * (da classe fachada) a responsabilidade pela escolha de qual implementação de RepositorioMensagens cadastrar no sistema.
     * Isso porque, caso novaMensagem fosse a fundadora do canal de comunicação de um usuário para o outro, um novo objeto do tipo Conversa
     * precisaria ser criado durante a execução de enviarMensagemPrivado; pois o método iniciarConversa, que aceita como referência 
     * unicamente instâncias da classe Conversa, precisaria, nesse caso, ser acionado. Porém, antes de criar um objeto do tipo Conversa,
     * teríamos que gerar um outro, que fosse do RepositorioMensagens e contivesse a novaMensagem sozinha - este seria passado como argumento
     * para o construtor de Conversa.
     * 
     * Tudo isso poderia simplesmente ficar a cargo do método main, aquele que, de fato, deve decidir qual implementação das interfaces utilizar.
     * É por essa razão que enviarMensagemPrivado receberá dois parâmentros separados: um do tipo Conversa, para o caso em que novaMensagem é a iniciadora
     * do diálogo; e outro do tipo Mensagem, que será simplesmente adicionado à conversa entre os dois usuários, quando ela já tiver sido iniciada.
     */
    public void enviarMensagemPrivado (Conversa possivelNovaConversa, Mensagem novaMensagem) throws ConversaReiniciadaException, EspacoInsuficienteException {
    	try {
    		Conversa ordemDireta = conversas.procurarConversa(possivelNovaConversa);
    		ordemDireta.adicionarMensagem(novaMensagem);
    	} catch (ConversaNaoEncontradaException e) {
    		conversas.iniciarConversa(possivelNovaConversa);
    	}
    	try {
    		possivelNovaConversa.inverter();
    		Conversa ordemInversa = conversas.procurarConversa(possivelNovaConversa);
    		ordemInversa.adicionarMensagem(novaMensagem);
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
    
    public void atualizarNome(Grupos grupo, String nome_Novo) throws GrupoNaoEncontradoException{
    	grupos.atualizarNome(grupo, nome_Novo);
    }
    
    public void atualizarDescricao(Grupos grupo, String descricao_Novo) throws GrupoNaoEncontradoException{
    	grupos.atualizarDescricao(grupo, descricao_Novo);
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
