package conversas;

import perfis.*;
import mensagens.*;

public class ConversasTeste {
	public static void main (String[] args) {
		CadastroPerfis perfis = new CadastroPerfis (new RepositorioPerfisArray());
		Perfil usuario1 = new Perfil ("Sergio", "99140-2381", new RepositorioPerfisArray());
		Perfil usuario2 = new Perfil ("Ricardo", "98865-0896", new RepositorioPerfisLista());
		try {
			perfis.cadastrar(usuario1);
			perfis.cadastrar(usuario2);
		} catch (PerfilJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		try {
			perfis.adicionarContato(usuario1.getName(), usuario2.getName());
			perfis.adicionarContato(usuario2.getName(), usuario1.getName());
		} catch (PerfilJaCadastradoException e1) {
			System.out.println(e1.getMessage());
		} catch (PerfilNotFoundException e2) {
			System.out.println(e2.getMessage());
		}
		
		int contMensagens = 0;
		Mensagem m1 = new MensagemCodificada (usuario1, "Bom dia, Ricardo!", ++contMensagens);
		RepositorioMensagens rep = new RepositorioMensagensArray();
		rep.inserir(m1);
		
		CadastroConversas conversasArray = new CadastroConversas(new RepositorioConversasArray(4));
		
		try {
			conversasArray.iniciarConversa(new Conversa(usuario1, usuario2, rep));
		} catch (RepositorioException e1) {
			System.out.println(e1.getMessage());
		} catch (ConversaReiniciadaException e2) {
			System.out.println(e2.getMessage());
		} catch (NaoSaoContatosException e3) {
			System.out.println(e3.getMessage());
		}
		
		CadastroConversas conversasLista = new CadastroConversas(new RepositorioConversasLista());
		
	}
}
