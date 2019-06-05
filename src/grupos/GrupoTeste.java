package programa;
import perfis.*;
import mensagens.*;
import mensageiro.*;
import grupos.*;
import conversas.*;

public class Programa {
    public static void main(String[] args) throws GrupoJaCadastradoException, GrupoNaoEncontradoException {
        //Testando a classe Grupos
    	Mensageiro mensageiro = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
    	CadastroGrupos teste = new CadastroGrupos(new RepositorioGruposArray()); 
		Grupos test1 = new Grupos("Familia", "Galera da farofa", new RepositorioPerfisLista(), new RepositorioMensagensArray());
		Grupos test2 = new Grupos("Amigos", "Galera do pagode", new RepositorioPerfisLista(), new RepositorioMensagensArray());
		Grupos test3 = new Grupos("Faculdade", "UFPE", new RepositorioPerfisLista(), new RepositorioMensagensArray());
		Perfil perfil1 = new Perfil("Mainha", "9876-5324", new RepositorioPerfisLista());
		Mensagem mensagem1 = new MensagemCodificada(perfil1, "Traz o feijao", 001);
		
		//GRUPOS ARRAY
		System.out.println("Teste da classe Grupos\nRepositorio em Array:");
		try {
            teste.inserir(test1);
            teste.inserir(test2);
            teste.inserir(test3);

            test1.inserirPerfil(perfil1);            
            test1.inserirMensagem(mensagem1);
            System.out.println("Grupo 1 - " + test1.getNome());
            System.out.println(perfil1.getName() + ": " + mensagem1.getMensagem());
            
		} catch (Exception e) {
            e.printStackTrace();
        }  		
	
    }
}
