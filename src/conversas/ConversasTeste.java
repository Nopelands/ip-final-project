package conversas;

import perfis.*;
import mensagens.*;

public class ConversasTeste {
	public static void main (String[] args) {
		CadastroConversas conversasArray = new CadastroConversas(new RepositorioConversasArray(2));
		
		CadastroPerfis perfis = new CadastroPerfis (new RepositorioPerfisArray());
		Perfil usuario1 = new Perfil ("Sergio", "99140-2381", new RepositorioPerfisArray());
		Perfil usuario2 = new Perfil ("Ricardo", "98865-0896", new RepositorioPerfisLista());
		try {
			perfis.cadastrar(usuario1);
			System.out.println ("O usuario " + usuario1.getName() + " / " + usuario1.getNumber() + " foi cadastrado com sucesso.");
			perfis.cadastrar(usuario2);
			System.out.println ("O usuario " + usuario2.getName() + " / " + usuario2.getNumber() + " foi cadastrado com sucesso.");
		} catch (PerfilJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		try {
			perfis.adicionarContato(usuario1.getNumber(), usuario2.getNumber());
			System.out.println(usuario2.getName() + " foi adicionado a lista de contatos de " + usuario1.getName() + ".");
			perfis.adicionarContato(usuario2.getNumber(), usuario1.getNumber());
			System.out.println(usuario1.getName() + " foi adicionado a lista de contatos de " + usuario2.getName() + ".");
		} catch (PerfilJaCadastradoException e1) {
			System.out.println(e1.getMessage());
		} catch (PerfilNotFoundException e2) {
			System.out.println(e2.getMessage());
		}
		
		int contMensagens = 0;
		Mensagem m1 = new MensagemCodificada (usuario1, "Bom dia, Ricardo!", ++contMensagens);
		RepositorioMensagens rep = new RepositorioMensagensArray();
		rep.inserir(m1);
		
		Conversa conversa1 = new Conversa(usuario1, usuario2, rep);
		
		try {
			conversasArray.iniciarConversa(conversa1);
			System.out.println("A conversa entre " + conversa1.getEmissor().getName() + " e " + conversa1.getReceptor().getName() + " foi iniciada com sucesso.");
		} catch (RepositorioException e1) {
			System.out.println(e1.getMessage());
		} catch (ConversaReiniciadaException e2) {
			System.out.println(e2.getMessage());
		} catch (NaoSaoContatosException e3) {
			System.out.println(e3.getMessage());
		}
		
		Conversa conversa2 = new Conversa (conversa1.getReceptor(), conversa1.getEmissor(), rep);
		try {
			conversasArray.iniciarConversa(conversa2);
			System.out.println("A conversa entre " + conversa2.getEmissor().getName() + " e " + conversa2.getReceptor().getName() + " foi iniciada com sucesso.");
		} catch (RepositorioException e1) {
			System.out.println(e1.getMessage());
		} catch (ConversaReiniciadaException e2) {
			System.out.println(e2.getMessage());
		} catch (NaoSaoContatosException e3) {
			System.out.println(e3.getMessage());
		}
		
		Mensagem m2 = new MensagemCodificada (usuario2, "Fala, Sergio!", ++contMensagens);
		conversa1.inserir(m2);
		try {
			conversasArray.iniciarConversa(conversa1);
			System.out.println("A conversa entre " + conversa1.getEmissor().getName() + " e " + conversa1.getReceptor().getName() + " foi iniciada com sucesso.");
		} catch (RepositorioException e1) {
			System.out.println(e1.getMessage());
		} catch (ConversaReiniciadaException e2) {
			System.out.println(e2.getMessage());
		} catch (NaoSaoContatosException e3) {
			System.out.println(e3.getMessage());
		}
		
		
		// TODO CadastroConversas conversasLista = new CadastroConversas(new RepositorioConversasLista());
	}
}
