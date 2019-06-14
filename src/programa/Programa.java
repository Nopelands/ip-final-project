package programa;

import perfis.*;
import conversas.*;
import grupos.*;
import mensagens.*;
import mensageiro.*;

public class Programa {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException, PerfilJaCadastradoException, PerfilNotFoundException{
    	Mensageiro mensageiroArray = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
    	Mensageiro mensageiroLista = new Mensageiro(new CadastroPerfis(new RepositorioPerfisLista()), new CadastroConversas(new RepositorioConversasLista()), new CadastroGrupos(new RepositorioGruposLista()), new CadastroMensagens(new RepositorioMensagensLista()));
       
    	//Testes em Array
    	//Teste PERFIL em Array
    	
    	System.out.println("---------------------------------- TESTE DA CLASSE PERFIL - REPOSITORIO EM ARRAY -------------------------------------");
    	
        Perfil perfilArray1 = new Perfil("sergio", "63194", new RepositorioPerfisArray());
        Perfil perfilArray2 = new Perfil("ricardo", "11037", new RepositorioPerfisArray());
        Perfil perfilArray3 = new Perfil("daniel", "217448", new RepositorioPerfisArray());
        try {
            mensageiroArray.criarUser(perfilArray1);
            mensageiroArray.criarUser(perfilArray2);
            mensageiroArray.criarUser(perfilArray3);
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            mensageiroArray.adicionarContato("11037", "63194");
            mensageiroArray.adicionarContato("63194", "11037");
            mensageiroArray.adicionarContato("11037", "217448");
            mensageiroArray.adicionarContato("217448", "11037");
            mensageiroArray.adicionarContato("63194", "217448");
            mensageiroArray.adicionarContato("217448", "63194");
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        System.out.println("-----------------------------------FIM DO TESTE DE PERFIL EM ARRAY----------------------------------------------------");
        System.out.println("");
        
        //Teste MENSAGENS Array
        
        Mensagem mensagemArray1 = new MensagemCodificada ( perfilArray1, "bom dia", 123);
        Mensagem mensagemArray2 = new MensagemCodificada ( perfilArray2, "respira: bo dia", 43);
        Mensagem mensagemArray3 = new MensagemCodificada  (perfilArray1, " tem prova hoje?", 712);
        Mensagem mensagemArray4 = new MensagemCodificadaReversa (perfilArray3, "mano, tem 2 provas e tu nem estudou?", 76023);
        //Mensagem mensagemArray5 = new MensagemNormal (perfilArray3, "por que vocês estão usando mensagem codificada??", 213);
        Mensagem mensagemArray6 = new MensagemCodificada (perfilArray1, "vai que o professor encontra essa mensagem e me dá 0 por não ter estudado", 000);

        mensagemArray6.codificar();
        mensagemArray1.codificar();
        mensagemArray2.codificar();
        mensagemArray4.codificar();
        
        //Teste GRUPO Array
        Grupo grupoArray1 = new Grupo("Familia", "Galera da farofa", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray2 = new Grupo("Amigos", "Galera do pagode", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray3 = new Grupo("Faculdade", "UFPE", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		System.out.println("---------------------------------- TESTE DA CLASSE GRUPOS - REPOSITORIO EM ARRAY -------------------------------------");
		   
 	   //Try Catch pra inserir grupos no repositorioGrupos
 	   try {
		    System.out.println("Inserindo grupos no repositorio: ");		
         mensageiroArray.inserirGrupo(grupoArray1);
         mensageiroArray.inserirGrupo(grupoArray2);
         mensageiroArray.inserirGrupo(grupoArray3);
         
         //Checando se os 3 grupos foram inseridos no repositorio de grupos,
         //caso sim, 3 mensagens serÃ¢o impressas.
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
 	   }catch (GrupoJaCadastradoException e1) {
			System.out.println(e1.getMessage());
		   }
        
 	   //Atualizaçao da descricao do grupo 1 (Familia)
 	   Grupo grupoArrayAtualizado1 = new Grupo("Familia", "Mulambagem", new RepositorioPerfisArray(), new RepositorioMensagensArray());
 	   System.out.println("Descricao antiga do Grupo 1(Familia): " + mensageiroArray.procurarGrupo("Familia").getDescricao());
 	   
 	   mensageiroArray.atualizarGrupo(grupoArrayAtualizado1);
 	   System.out.println("Descricao nova do Grupo 1(Familia): " + mensageiroArray.procurarGrupo("Familia").getDescricao());
 	   System.out.println("");
 	  
 	  //Try Catch pra remover grupos no repositorioGrupos
 	   try {
         mensageiroArray.removerGrupo(grupoArray2);
         
         //Checar se o grupo removido realmente foi retirado do repositorio de grupos
         //Caso sim, sera impresso " O grupo x foi removido".
         if (!mensageiroArray.checarGrupo(grupoArray2.getNome())) {
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

        //TODO main

    }
}
