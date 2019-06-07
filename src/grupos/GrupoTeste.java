package grupos;
import perfis.*;
import mensagens.*;
import mensageiro.*;
import grupos.*;
import conversas.*;

public class GrupoTeste {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException, PerfilNotFoundException, PerfilJaCadastradoException, MensagemNaoEncontradaException {
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
            mensageiroArray.inserirGrupo(grupoArray1);
            mensageiroArray.inserirGrupo(grupoArray2);
            mensageiroArray.inserirGrupo(grupoArray3);
            
            //Checando se os 3 grupos foram inseridos no repositorio de grupos,
            //caso sim, 3 mensagens serâo impressas.
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
            
          
            mensageiroArray.removerGrupo(grupoArray2);
            
            //Checar se o grupo removido realmente foi retirado do repositorio de grupos
            //Caso sim, sera impresso " O grupo x foi removido".
            if (!mensageiroArray.checarGrupo(grupoArray2.getNome())) {
    			System.out.println("O grupo "+ grupoArray2.getNome()  + " foi removido!\n");
    		} else {
    			System.out.println("O grupo nao foi removido!\n");
    		}
            
            System.out.println("Inserindo perfis no grupo 1: ");
            grupoArray1.inserirPerfil(perfilArray1);
            grupoArray1.inserirPerfil(perfilArray2);
            
            //Checar se os 2 perfis foram inseridos no grupo
            if(grupoArray1.getListaNomes().existe(perfilArray1.getNumber()) && grupoArray1.getListaNomes().existe(perfilArray2.getNumber())) {
    			System.out.println(		"O perfil " + perfilArray1.getName() + " foi inserido no grupo.");
    			System.out.println("O perfil " + perfilArray2.getName()+ " foi inserido no grupo.\n");
            }
            
            grupoArray1.removerPerfil(perfilArray2.getNumber());
            
            //Checar se o perfil foi removido do grupo
            if (!grupoArray1.getListaNomes().existe(perfilArray2.getNumber())) {
    			System.out.println("O perfil "+ perfilArray2.getName()  + " foi removido do grupo!\n");
    		} else {
    			System.out.println("O perfil nao foi removido do grupo!\n");
    		}
            
            grupoArray1.inserirMensagem(mensagemArray1);
            grupoArray1.inserirMensagem(mensagemArray2);
            
            //Checar se as 2 mensagens foram inseridas no grupo 1
            System.out.println("Inserindo mensagens no grupo 1: ");
            if(grupoArray1.getListaMensagens().existe(mensagemArray1.getMensagem()) && grupoArray1.getListaMensagens().existe(mensagemArray2.getMensagem())) {
    			System.out.println(		"A mensagem " + mensagemArray1.getMensagem() + " foi inserida no grupo.");
    			System.out.println("A mensagem " + mensagemArray2.getMensagem()+ " foi inserida no grupo.\n");
            }
            
            
            grupoArray1.removerMensagem(mensagemArray2);
            
            //Checar se a mensagem foi removida do grupo 1
            if (!grupoArray1.getListaMensagens().existe(mensagemArray2.getMensagem())) {
    			System.out.println("A mensagem "+ mensagemArray2.getMensagem()  + " foi removida do grupo!\n");
    		} else {
    			System.out.println("A mensagem nao foi removida do grupo!\n");
    		}
            
            
            //Visualizacao do grupo
            System.out.println("Grupo array1 - " + grupoArray1.getNome());
            System.out.println(mensagemArray1.getRemetente().getName() + ": " + mensagemArray1.getMensagem());
            System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM ARRAY----------------------------------------------------");
            System.out.println("");
            
          //GRUPOS LISTA
            
            System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM LISTA -------------------------------------");
            
        	Grupo grupoLista1 = new Grupo("Igreja", "Galera do ritual", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista2 = new Grupo("Massacration", "the best metal band of all time", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista3 = new Grupo("Universidade de Chicago", "Doomsday Clock", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Perfil perfilLista1 = new Perfil("Padre Marcelo Rossi", "7976-2312", new RepositorioPerfisArray());
    		Perfil perfilLista2 = new Perfil("Coroinha", "8790-3421", new RepositorioPerfisArray());
    		Mensagem mensagemLista1 = new MensagemCodificada(perfilLista1, "Amem!", 003);
    		Mensagem mensagemLista2 = new MensagemCodificada(perfilLista1, "Em nome do pai.", 004);
            
            
            
		    System.out.println("Inserindo grupos no repositorio: ");		
            mensageiroLista.inserirGrupo(grupoLista1);
            mensageiroLista.inserirGrupo(grupoLista2);
            mensageiroLista.inserirGrupo(grupoLista3);
            
            //Checando se os 3 grupos foram inseridos no repositorio de grupos,
            //caso sim, 3 mensagens serâo impressas.
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
            
          
            mensageiroLista.removerGrupo(grupoLista2);
            
            //Checar se o grupo removido realmente foi retirado do repositorio de grupos
            //Caso sim, sera impresso " O grupo x foi removido".
            if (!mensageiroLista.checarGrupo(grupoLista2.getNome())) {
    			System.out.println("O grupo "+ grupoLista2.getNome()  + " foi removido!\n");
    		} else {
    			System.out.println("O grupo nao foi removido!\n");
    		}
            
            System.out.println("Inserindo perfis no grupo 1: ");
            grupoLista1.inserirPerfil(perfilLista1);
            grupoLista1.inserirPerfil(perfilLista2);
            
            //Checar se os 2 perfis foram inseridos no grupo
            if(grupoLista1.getListaNomes().existe(perfilLista1.getNumber()) && grupoLista1.getListaNomes().existe(perfilLista2.getNumber())) {
    			System.out.println(		"O perfil " + perfilLista1.getName() + " foi inserido no grupo.");
    			System.out.println("O perfil " + perfilLista2.getName()+ " foi inserido no grupo.\n");
            }
            
            grupoLista1.removerPerfil(perfilLista2.getNumber());
            
            //Checar se o perfil foi removido do grupo
            if (!grupoLista1.getListaNomes().existe(perfilLista2.getNumber())) {
    			System.out.println("O perfil "+ perfilLista2.getName()  + " foi removido do grupo!\n");
    		} else {
    			System.out.println("O perfil nao foi removido do grupo!\n");
    		}
            
            grupoLista1.inserirMensagem(mensagemLista1);
            grupoLista1.inserirMensagem(mensagemLista2);
            
            //Checar se as 2 mensagens foram inseridas no grupo 1
            System.out.println("Inserindo mensagens no grupo 1: ");
            if(grupoLista1.getListaMensagens().existe(mensagemLista1.getMensagem()) && grupoLista1.getListaMensagens().existe(mensagemLista2.getMensagem())) {
    			System.out.println(		"A mensagem " + mensagemLista1.getMensagem() + " foi inserida no grupo.");
    			System.out.println("A mensagem " + mensagemLista2.getMensagem()+ " foi inserida no grupo.\n");
            }
            
            
            grupoLista1.removerMensagem(mensagemLista2);
            
            //Checar se a mensagem foi removida do grupo 1
            if (!grupoLista1.getListaMensagens().existe(mensagemLista2.getMensagem())) {
    			System.out.println("A mensagem "+ mensagemLista2.getMensagem()  + " foi removida do grupo!\n");
    		} else {
    			System.out.println("A mensagem nao foi removida do grupo!\n");
    		}
            
            
            //Visualizacao do grupo
            System.out.println("Grupo array1 - " + grupoLista1.getNome());
            System.out.println(mensagemLista1.getRemetente().getName() + ": " + mensagemLista1.getMensagem());
            System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM ARRAY----------------------------------------------------");
            System.out.println("");
             		
	
    }
}
