package mensageiro;

import perfis.*;
import mensagens.*;
import grupos.*;
import conversas.*;

public class Mensageiro {
    private CadastroPerfis perfis;
    private CadastroMensagens mensagens;
    private CadastroConversas conversas;
    //TODO private CadastroGrupos grupos;
    
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
