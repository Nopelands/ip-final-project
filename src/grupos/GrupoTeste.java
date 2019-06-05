package grupos;
import perfis.*;
import mensagens.*;
import mensageiro.*;
import grupos.*;
import conversas.*;

public class GrupoTeste {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException, PerfilNotFoundException, PerfilJaCadastradoException {
        //Testando a classe Grupos
    	Mensageiro mensageiroArray = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
    	Mensageiro mensageiroLista = new Mensageiro(new CadastroPerfis(new RepositorioPerfisLista()), new CadastroConversas(new RepositorioConversasLista()), new CadastroGrupos(new RepositorioGruposLista()), new CadastroMensagens(new RepositorioMensagensLista()));
		
		//GRUPOS ARRAY
		
    	Grupo grupoArray1 = new Grupo("Familia", "Galera da farofa", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray2 = new Grupo("Amigos", "Galera do pagode", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray3 = new Grupo("Faculdade", "UFPE", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Perfil perfilArray1 = new Perfil("Mainha", "9876-5324", new RepositorioPerfisArray());
		Perfil perfilArray2 = new Perfil("Painho", "6578-0783", new RepositorioPerfisArray());
		Mensagem mensagemArray1 = new MensagemCodificada(perfilArray1, "Traz o feijao", 001);
		Mensagem mensagemArray2 = new MensagemCodificada(perfilArray1, "Traz a farinha", 002);
    	
    	System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM ARRAY -------------------------------------");
		    
		    System.out.println("Inserindo grupos no repositorio: ");		
            mensageiroArray.inserir(grupoArray1);
            mensageiroArray.inserir(grupoArray2);
            mensageiroArray.inserir(grupoArray3);
            
            if (mensageiroArray.checarGrupo(grupoArray1.getNome())
    				&& mensageiroArray.checarGrupo(grupoArray2.getNome())
    				&& mensageiroArray.checarGrupo(grupoArray3.getNome())) {
    			System.out.println(
    					"O grupo " + grupoArray1.getNome() + " foi inserido.");
    			System.out.println("O grupo " +grupoArray2.getNome()
    					+ " foi inserido.");
    			System.out.println("O grupo " + grupoArray3.getNome()
    					+ " foi inserido.\n");
    		}
            
            
            mensageiroArray.remover(grupoArray2);
            
            
            if (!mensageiroArray.checarGrupo(grupoArray2.getNome())) {
    			System.out.println("O grupo "+ grupoArray2.getNome()  + " foi removido!\n");
    		} else {
    			System.out.println("O grupo nao foi removido!\n");
    		}
            
            System.out.println("Inserindo perfis no repositorio: ");
            grupoArray1.inserirPerfil(perfilArray1);
            grupoArray1.inserirPerfil(perfilArray2);
                  
    			System.out.println(		"O perfil " + perfilArray1.getName() + " foi inserido.");
    			System.out.println("O perfil " + perfilArray2.getName()+ " foi inserido.\n");
    			         
            grupoArray1.removerPerfil(perfilArray2.getNumber());
            
            if (!mensageiroArray.equals(perfilArray2.getName())) {
    			System.out.println("O perfil "+ perfilArray2.getName()  + " foi removido!\n");
    		} else {
    			System.out.println("O perfil nao foi removido!\n");
    		}
            
            grupoArray1.inserirMensagem(mensagemArray1);
            
            System.out.println("Grupo array1 - " + grupoArray1.getNome());
            System.out.println(perfilArray1.getName() + ": " + mensagemArray1.getMensagem());
            System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM ARRAY----------------------------------------------------");
            System.out.println("");
            
          //GRUPOS LISTA
            
            System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM LISTA -------------------------------------");
            
        	Grupo grupoLista1 = new Grupo("Igreja", "Galera do ritual", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista2 = new Grupo("Massacration", "the best metal band of all time", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista3 = new Grupo("Universidade de Chicago", "Doomsday Clock", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Perfil perfilLista1 = new Perfil("Padre Marcelo Rossi", "7976-2312", new RepositorioPerfisArray());
    		Mensagem mensageiroLista1 = new MensagemCodificada(perfilLista1, "Amém!", 002);
    		
            
            
            
    		System.out.println("Teste da classe Grupos\nRepositorio em Lista:");
    		    
    		    System.out.println("Inserindo grupos no repositorio: ");		
                mensageiroLista.inserir(grupoLista1);
                mensageiroLista.inserir(grupoLista2);
                mensageiroLista.inserir(grupoLista3);
                
                if (mensageiroLista.checarGrupo(grupoLista1.getNome())
        				&& mensageiroLista.checarGrupo(grupoLista2.getNome())
        				&& mensageiroLista.checarGrupo(grupoLista3.getNome())) {
        			System.out.println(
        					"O grupo " + grupoLista1.getNome() + " foi inserido.");
        			System.out.println("O grupo " +grupoLista2.getNome()
        					+ " foi inserido.");
        			System.out.println("O grupo " + grupoLista3.getNome()
        					+ " foi inserido.\n");
        		}
                
                
                mensageiroLista.remover(grupoLista2);
                
                if (!mensageiroLista.checarGrupo(grupoLista2.getNome())) {
        			System.out.println("O grupo "+ grupoLista2.getNome()  + " foi removido!\n");
        		} else {
        			System.out.println("O grupo nao foi removido!\n");
        		}
                
                grupoLista1.inserirPerfil(perfilLista1);            
                grupoLista1.inserirMensagem(mensageiroLista1);
                System.out.println("Grupo lista1 - " + grupoLista1.getNome());
                System.out.println(perfilLista1.getName() + ": " + mensageiroLista1.getMensagem());
                System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM LISTA----------------------------------------------------");
                System.out.println("");
             		
	
    }
}
