package grupos;
import perfis.*;
import mensagens.*;
import mensageiro.*;
import conversas.*;

public class GrupoTeste {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException, PerfilNotFoundException, PerfilJaCadastradoException, MensagemNaoEncontradaException {
        //Testando a classe Grupos
    	Mensageiro mensageiroArray = new Mensageiro(new RepositorioPerfisArray(), new RepositorioConversasArray(1000), new RepositorioGruposArray(), new RepositorioMensagensArray());
    	Mensageiro mensageiroLista = new Mensageiro(new RepositorioPerfisLista(), new RepositorioConversasLista(), new RepositorioGruposLista(), new RepositorioMensagensLista());
		
		//GRUPOS ARRAY
		
    	Grupo grupoArray1 = new Grupo("Familia", "Galera da farofa", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray2 = new Grupo("Amigos", "Galera do pagode", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray3 = new Grupo("Faculdade", "UFPE", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Perfil perfilArray1 = new Perfil("Mainha", "9876-5324", new RepositorioPerfisArray());
		Perfil perfilArray2 = new Perfil("Painho", "6578-0783", new RepositorioPerfisArray());
		Mensagem mensagemArray1 = new MensagemCodificada(perfilArray1, "Traz o feijao", 001);
		Mensagem mensagemArray2 = new MensagemCodificada(perfilArray1, "Traz a farinha", 002);
    	
    	System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM ARRAY -------------------------------------");
		   
    	   //Try Catch pra inserir grupos no repositorioGrupos
    	   try {
		    System.out.println("Inserindo grupos no repositorio: ");		
            mensageiroArray.cadastrar(grupoArray1);
            mensageiroArray.cadastrar(grupoArray2);
            mensageiroArray.cadastrar(grupoArray3);
            
            //Checando se os 3 grupos foram inseridos no repositorio de grupos,
            //caso sim, 3 mensagens serÃ¢o impressas.
            if (mensageiroArray.existe(grupoArray1.getNome())
    				&& mensageiroArray.existe(grupoArray2.getNome())
    				&& mensageiroArray.existe(grupoArray3.getNome())) {
    			System.out.println(
    					"O grupo " + grupoArray1.getNome() + " foi inserido.");
    			System.out.println("O grupo " +grupoArray2.getNome()
    					+ " foi inserido.");
    			System.out.println("O grupo " + grupoArray3.getNome()
    					+ " foi inserido.\n");
    		}
    	   }catch (GrupoJaCadastradoException e1) {
   			System.out.println(e1.getMessage());
   		   }
           
    	   //Atualizaçao da descricao do grupo 1 (Familia)
    	   Grupo grupoArrayAtualizado1 = new Grupo("Familia", "Mulambagem", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    	   mensageiroArray.atualizar(grupoArrayAtualizado1);
    	   
    	  //Try Catch pra remover grupos no repositorioGrupos
    	   try {
            mensageiroArray.remover(grupoArray2);
            
            //Checar se o grupo removido realmente foi retirado do repositorio de grupos
            //Caso sim, sera impresso " O grupo x foi removido".
            if (!mensageiroArray.existe(grupoArray2.getNome())) {
    			System.out.println("O grupo "+ grupoArray2.getNome()  + " foi removido!\n");
    		} else {
    			System.out.println("O grupo nao foi removido!\n");
    		}
    	   }catch (GrupoNaoEncontradoException e2) {
   			System.out.println(e2.getMessage());
   		   }
            
            
            System.out.println("Inserindo perfis no grupo 1: ");
          //Try Catch pra inserir perfis no Repositorio de Perfis do grupo.
            try {
            grupoArray1.inserirPerfil(perfilArray1);
            grupoArray1.inserirPerfil(perfilArray2);
            
            //Checar se os 2 perfis foram inseridos no grupo
            if(grupoArray1.getListaNomes().existe(perfilArray1.getNumber()) && grupoArray1.getListaNomes().existe(perfilArray2.getNumber())) {
    			System.out.println(		"O perfil " + perfilArray1.getName() + " foi inserido no grupo.");
    			System.out.println("O perfil " + perfilArray2.getName()+ " foi inserido no grupo.\n");
            }
            } catch (PerfilJaCadastradoException p) {
       			System.out.println(p.getMessage());
    		   }
            
          //Try Catch pra remover perfis no Repositorio de Perfis do grupo.
            try {
            grupoArray1.removerPerfil(perfilArray2.getNumber());            
            //Checar se o perfil foi removido do grupo
            if (!grupoArray1.getListaNomes().existe(perfilArray2.getNumber())) {
    			System.out.println("O perfil "+ perfilArray2.getName()  + " foi removido do grupo!\n");
    		} else {
    			System.out.println("O perfil nao foi removido do grupo!\n");
    		}
            } catch (PerfilNotFoundException p) {
            System.out.println(p.getMessage());
	         }
            
            //Nao precisa de try catch pra Inserir Mensagens. Nao ha exception
            grupoArray1.inserirMensagem(mensagemArray1);
            grupoArray1.inserirMensagem(mensagemArray2);
            
            //Checar se as 2 mensagens foram inseridas no grupo 1
            System.out.println("Inserindo mensagens no grupo 1: ");
            if(grupoArray1.getListaMensagens().existe(mensagemArray1.getMensagem()) && grupoArray1.getListaMensagens().existe(mensagemArray2.getMensagem())) {
    			System.out.println(		"A mensagem " + mensagemArray1.getMensagem() + " foi inserida no grupo.");
    			System.out.println("A mensagem " + mensagemArray2.getMensagem()+ " foi inserida no grupo.\n");
            }
            
            try{
            grupoArray1.removerMensagem(mensagemArray2);
            
            //Checar se a mensagem foi removida do grupo 1
            if (!grupoArray1.getListaMensagens().existe(mensagemArray2.getMensagem())) {
    			System.out.println("A mensagem "+ mensagemArray2.getMensagem()  + " foi removida do grupo!\n");
    		} else {
    			System.out.println("A mensagem nao foi removida do grupo!\n");
    		}
            } catch (MensagemNaoEncontradaException m){
                System.out.println(m.getMessage());
    	    }
            
            //Visualizacao do grupo
            System.out.println("Grupo array1 - " + grupoArray1.getNome());
            System.out.println(mensagemArray1.getRemetente().getName() + ": " + mensagemArray1.getMensagem());
            System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM ARRAY----------------------------------------------------");
            System.out.println("");
            
          //GRUPOS LISTA
            
            System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM LISTA -------------------------------------");
            
        	Grupo grupoLista1 = new Grupo("Igreja", "Galera do ritual", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista2 = new Grupo("Massacration", "metal band", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Grupo grupoLista3 = new Grupo("Universidade de Chicago", "Doomsday Clock", new RepositorioPerfisArray(), new RepositorioMensagensArray());
    		Perfil perfilLista1 = new Perfil("Padre Marcelo Rossi", "7976-2312", new RepositorioPerfisArray());
    		Perfil perfilLista2 = new Perfil("Coroinha", "8790-3421", new RepositorioPerfisArray());
    		Mensagem mensagemLista1 = new MensagemCodificada(perfilLista1, "Amem!", 003);
    		Mensagem mensagemLista2 = new MensagemCodificada(perfilLista1, "Em nome do pai.", 004);
            
            
            
		    System.out.println("Inserindo grupos no repositorio: ");		
            mensageiroLista.cadastrar(grupoLista1);
            mensageiroLista.cadastrar(grupoLista2);
            mensageiroLista.cadastrar(grupoLista3);
            
            //Checando se os 3 grupos foram inseridos no repositorio de grupos,
            //caso sim, 3 mensagens serÃ¢o impressas.
            if (mensageiroLista.existe(grupoLista1.getNome())
    				&& mensageiroLista.existe(grupoLista2.getNome())
    				&& mensageiroLista.existe(grupoLista3.getNome())) {
    			System.out.println(
    					"O grupo " + grupoLista1.getNome() + " foi inserido.");
    			System.out.println("O grupo " +grupoLista2.getNome()
    					+ " foi inserido.");
    			System.out.println("O grupo " + grupoLista3.getNome()
    					+ " foi inserido.\n");
    		}
            
          
            mensageiroLista.remover(grupoLista2);
            
            //Checar se o grupo removido realmente foi retirado do repositorio de grupos
            //Caso sim, sera impresso " O grupo x foi removido".
            if (!mensageiroLista.existe(grupoLista2.getNome())) {
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
