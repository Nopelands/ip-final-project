package programa;
import perfis.*;
import mensagens.*;
import mensageiro.*;
import grupos.*;
import conversas.*;

public class GrupoTeste {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException {
        //Testando a classe Grupos
    	Mensageiro mensageiroArray = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
		Grupos test1 = new Grupos("Familia", "Galera da farofa", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupos test2 = new Grupos("Amigos", "Galera do pagode", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupos test3 = new Grupos("Faculdade", "UFPE", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Perfil perfil1 = new Perfil("Mainha", "9876-5324", new RepositorioPerfisArray());
		Mensagem mensagem1 = new MensagemCodificada(perfil1, "Traz o feijao", 001);
		
		//GRUPOS ARRAY
		System.out.println("Teste da classe Grupos\nRepositorio em Array:");
		    
		    System.out.println("Inserindo grupos no repositório: ");		
            mensageiroArray.inserir(test1);
            mensageiroArray.inserir(test2);
            mensageiroArray.inserir(test3);
            
            if (mensageiroArray.checarGrupo(test1.getNome())
    				&& mensageiroArray.checarGrupo(test2.getNome())
    				&& mensageiroArray.checarGrupo(test3.getNome())) {
    			System.out.println(
    					"O grupo " + test1.getNome() + " foi inserido.");
    			System.out.println("O grupo " +test2.getNome()
    					+ " foi inserido.");
    			System.out.println("O grupo " + test3.getNome()
    					+ " foi inserido.\n");
    		}
            
            
            mensageiroArray.remover(test2);
            
            if (!mensageiroArray.checarGrupo("Amigos")) {
    			System.out.println("O grupo "+ test2.getNome()  + " foi removido!\n");
    		} else {
    			System.out.println("O grupo nao foi removido!\n");
    		}
            
            test1.inserirPerfil(perfil1);            
            test1.inserirMensagem(mensagem1);
            System.out.println("Grupo 1 - " + test1.getNome());
            System.out.println(perfil1.getName() + ": " + mensagem1.getMensagem());
             		
	
    }
}
