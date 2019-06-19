package programa;

import perfis.*;
import conversas.*;
import grupos.*;
import mensagens.*;
import mensageiro.*;

public class Programa {
    public static void main(String[] args){
    	Mensageiro mensageiroArray = new Mensageiro(new RepositorioPerfisArray(), new RepositorioConversasArray(1000), new RepositorioGruposArray(), new RepositorioMensagensArray());
    	Mensageiro mensageiroLista = new Mensageiro(new RepositorioPerfisLista(), new RepositorioConversasLista(), new RepositorioGruposLista(), new RepositorioMensagensLista());
       
    	//Testes em Array
    	//Teste PERFIL em Array
    	
    	System.out.println("---------------------------------- TESTE DA CLASSE PERFIL - REPOSITORIO EM ARRAY -------------------------------------");
    	//TODO redo the user thingy
        Perfil perfilArray1 = new Perfil("sergio", "63194", new RepositorioPerfisArray());
        Perfil perfilArray2 = new Perfil("ricardo", "11037", new RepositorioPerfisArray());
        Perfil perfilArray3 = new Perfil("daniel", "217448", new RepositorioPerfisArray());
        try {
            mensageiroArray.cadastrar(perfilArray1);
            mensageiroArray.cadastrar(perfilArray2);
            mensageiroArray.cadastrar(perfilArray3);
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            adicionarContato("11037", "63194", mensageiroArray);
            adicionarContato("63194", "11037", mensageiroArray);
            adicionarContato("11037", "217448", mensageiroArray);
            adicionarContato("217448", "11037", mensageiroArray);
            adicionarContato("63194", "217448", mensageiroArray);
            adicionarContato("217448", "63194", mensageiroArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------------FIM DO TESTE DE PERFIL EM ARRAY--------------------------------------------------\n");

        //Teste MENSAGENS Array

        Mensagem mensagemArray1 = new MensagemCodificada ( perfilArray1, "bom dia", 123);
        Mensagem mensagemArray2 = new MensagemCodificada ( perfilArray2, "respira: bo dia", 43);
        Mensagem mensagemArray3 = new MensagemCodificada  (perfilArray1, " tem prova hoje?", 712);
        Mensagem mensagemArray4 = new MensagemCodificadaReversa (perfilArray3, "mano, tem 2 provas e tu nem estudou?", 76023);
        Mensagem mensagemArray5 = new MensagemNormal (perfilArray3, "por que voces estão usando mensagem codificada??", 213);
        Mensagem mensagemArray6 = new MensagemCodificada (perfilArray1, "vai que o professor encontra essa mensagem e me da 0 por nao ter estudado", 000);

        System.out.println("---------------------------------- TESTE DA CLASSE MENSAGENS - REPOSITORIO EM ARRAY -----------------------------------");
        
        mensagemArray6.codificar();
        mensagemArray1.codificar();
        mensagemArray2.codificar();
        mensagemArray4.codificar();
		
        System.out.println("Inserindo mensagens no repositorio...");
        mensageiroArray.cadastrar(mensagemArray1);
        mensageiroArray.cadastrar(mensagemArray2);
        mensageiroArray.cadastrar(mensagemArray3);
        mensageiroArray.cadastrar(mensagemArray4);
        mensageiroArray.cadastrar(mensagemArray5);
        mensageiroArray.cadastrar(mensagemArray6);
        System.out.println("Mensagens cadastradas");

        //try catch para remover mensagens
        try {
            System.out.println("Removendo mensagens...");
            mensageiroArray.remover(mensagemArray1);
            mensageiroArray.remover(mensagemArray2);
        } catch (MensagemNaoEncontradaException exc1){
            System.out.println(exc1.getMessage());
        }
        System.out.println("Mensagens Removidas");

        //try catch para atualizar mensagens
        Mensagem mensagemArrayTeste = new MensagemCodificada(perfilArray1, "teste", 712);
        try {
            System.out.println("Atualizando mensagemArray3");
            mensageiroArray.atualizar(mensagemArrayTeste);
        } catch (IdentificacaoNaoEncontradaException exc2){
            System.out.println(exc2.getMessage());
        }
        System.out.println("Mensagem Atualizada");

        //try catch para procurar identificação
        try {
            System.out.println("Procurando mensagem com identificacao: 712");
            Mensagem mensagemEncontrada = mensageiroArray.procurar(712);
            System.out.println("A mensagem com identificacao igual a 712 é:");
            System.out.println(mensagemEncontrada.getMensagem());
        } catch (IdentificacaoNaoEncontradaException exc3){
            System.out.println(exc3.getMessage());
        }
        System.out.println("-----------------------------------FIM DO TESTE DE MENSAGENS EM ARRAY--------------------------------------------------");
        System.out.println("");

        //Teste GRUPO Array
        Grupo grupoArray1 = new Grupo("Familia", "Galera da farofa", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray2 = new Grupo("Amigos", "Galera do pagode", new RepositorioPerfisArray(), new RepositorioMensagensArray());
		Grupo grupoArray3 = new Grupo("Faculdade", "UFPE", new RepositorioPerfisArray(), new RepositorioMensagensArray());
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
 	   try {
 	   System.out.println("Descricao antiga do Grupo 1(Familia): " + mensageiroArray.procurar("Familia").getDescricao());
 	   }catch (GrupoNaoEncontradoException e1) {
			System.out.println(e1.getMessage());
	   }
 	   
 	  try {
 	   mensageiroArray.atualizar(grupoArrayAtualizado1);
 	   System.out.println("Descricao nova do Grupo 1(Familia): " + mensageiroArray.procurar("Familia").getDescricao());
 	   System.out.println("");
 	  }catch (GrupoNaoEncontradoException e1) {
			System.out.println(e1.getMessage());
	   }
 	  
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
         grupoArray1.inserirMensagem(mensagemArray5);
         
         //Checar se as 2 mensagens foram inseridas no grupo 1
         System.out.println("Inserindo mensagens no grupo 1: ");
         if(grupoArray1.getListaMensagens().existe(mensagemArray1.getMensagem()) && grupoArray1.getListaMensagens().existe(mensagemArray2.getMensagem()) && grupoArray1.getListaMensagens().existe(mensagemArray5.getMensagem())) {
 			System.out.println(		"A mensagem " + mensagemArray1.getMensagem() + " foi inserida no grupo.");
 			System.out.println("A mensagem " + mensagemArray2.getMensagem()+ " foi inserida no grupo.\n");
 			System.out.println("A mensagem " + mensagemArray5.getMensagem()+ " foi inserida no grupo.\n");
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
         System.out.println(mensagemArray5.getRemetente().getName() + ": " + mensagemArray5.getMensagem());
         System.out.println("-----------------------------------FIM DO TESTE DE GRUPOS EM ARRAY----------------------------------------------------");
         System.out.println("");
         
         System.out.println("---------------------------------- TESTE DA CLASSE CONVERSAS - REPOSITORIO EM ARRAY -------------------------------------");
         
         Conversa conversaArray1 = new Conversa (perfilArray1, perfilArray2, new RepositorioMensagensArray());
         Conversa conversaArray2 = new Conversa (perfilArray2, perfilArray3, new RepositorioMensagensArray());
         
         // Cadastrando as conversas no sistema
         try {
        	 mensageiroArray.cadastrar(conversaArray1);
        	 System.out.println("A conversa entre os perfis " + conversaArray1.getEmissor().getName() + " e " + conversaArray1.getReceptor().getName() + " foi cadastrada com sucesso.");
        	 mensageiroArray.cadastrar(conversaArray2);
        	 System.out.println("A conversa entre os perfis " + conversaArray2.getEmissor().getName() + " e " + conversaArray2.getReceptor().getName() + " foi cadastrada com sucesso.");
         } catch (RepositorioException e1) {
        	 System.out.println(e1.getMessage());
         } catch (ConversaReiniciadaException e2) {
        	 System.out.println(e2.getMessage());
         } catch (NaoSaoContatosException e3) {
        	 System.out.println(e3.getMessage());
         } catch (PerfilNotFoundException e4) {
        	 System.out.println(e4.getMessage());
         } catch (MensagemNaoEncontradaException e5) {
        	 System.out.println(e5.getMessage());
         }
         
         // Alimentando a conversa com mensagens
         Conversa resultadoBusca = conversaArray2;
         try {
        	 resultadoBusca = mensageiroArray.procurar(perfilArray2, perfilArray1);
        	 System.out.println("A conversa entre " + perfilArray2.getName() + " e " + perfilArray1.getName() + " foi encontrada com sucesso.");
         } catch (ConversaNaoEncontradaException e) {
        	 // A conversa nao sera encontrada pelo sistema porque a operacao de cadastro nao e comutativa.
        	 // A conversa que cadastramos tinha 'sergio' como emissor e 'ricardo' como receptor, e nao o contrario.
        	 System.out.println(e.getMessage());
         }
         
         try {
        	 resultadoBusca = mensageiroArray.procurar(perfilArray1, perfilArray2);
        	 System.out.println("A conversa entre " + perfilArray1.getName() + " e " + perfilArray2.getName() + " foi encontrada com sucesso.");
         } catch (ConversaNaoEncontradaException e) {
        	 System.out.println(e.getMessage());
         }
         
         resultadoBusca.inserir(mensagemArray1);
         resultadoBusca.inserir(mensagemArray2);
         resultadoBusca.inserir(mensagemArray3);
         
         try {
        	 mensageiroArray.atualizar(resultadoBusca);
        	 System.out.println("A conversa entre os perfis " + resultadoBusca.getEmissor().getName() + " e " + resultadoBusca.getReceptor().getName() + " foi atualizada com sucesso.");
         } catch (ConversaNaoEncontradaException e) {
        	 System.out.println(e.getMessage());
         }
         
         // Removendo uma conversa
         try {
        	 mensageiroArray.remover(perfilArray1, perfilArray3);
        	 System.out.println("A conversa entre os perfis " + perfilArray1.getName() + " e " + perfilArray3.getName() + " foi removida com sucesso.");
         } catch (ConversaNaoEncontradaException e) {
        	 // A conversa nao podera ser removida porque nao esta previamente cadastrada no sistema
        	 System.out.println(e.getMessage());
         }
         
         try {
        	 mensageiroArray.remover(perfilArray2, perfilArray3);
        	 System.out.println("A conversa entre os perfis " + perfilArray2.getName() + " e " + perfilArray3.getName() + " foi removida com sucesso.");
         } catch (ConversaNaoEncontradaException e) {
        	 System.out.println(e.getMessage());
         }
         
         System.out.println("-----------------------------------FIM DO TESTE DE CONVERSAS EM ARRAY----------------------------------------------------");
    }
    public static void adicionarContato(String numberAdd, String numberContato, Mensageiro mensageiro) throws PerfilNotFoundException, PerfilJaCadastradoException{
        Perfil perfil = mensageiro.procurarPerfil(numberAdd);
        if (perfil.getContacts().existe(numberContato)) {
            throw new PerfilJaCadastradoException();
        } else {
            perfil.getContacts().inserir(mensageiro.procurarPerfil(numberContato));
        }
        mensageiro.atualizarPerfil(perfil);
    }
}
