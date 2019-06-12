package programa;

import perfis.*;
import conversas.*;
import grupos.*;
import mensagens.*;
import mensageiro.*;

public class Programa {
    public static void main(String[] args) {
        Mensageiro mensageiro = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
        Perfil aaa = new Perfil("aaa", "177013", new RepositorioPerfisArray());
        Perfil bbb = new Perfil("bbb", "11037", new RepositorioPerfisArray());
        Perfil ccc = new Perfil("ccc", "isso nem precisa ser um numero kk", new RepositorioPerfisArray());
        Perfil ddd = new Perfil("ninguem vai entender as referencias mesmo", "1.048596", new RepositorioPerfisArray());
        Perfil emma = new Perfil("emma", "63194", new RepositorioPerfisArray());
        Perfil god = new Perfil("god", "217448", new RepositorioPerfisArray());

        try {
            mensageiro.criarUser(aaa);
            mensageiro.criarUser(bbb);
            mensageiro.criarUser(ccc);
            mensageiro.criarUser(ddd);
            mensageiro.criarUser(emma);
            mensageiro.criarUser(god);
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            mensageiro.adicionarContato("11037", "63194");
            mensageiro.adicionarContato("63194", "11037");
            mensageiro.adicionarContato("11037", "217448");
            mensageiro.adicionarContato("217448", "11037");
        } catch (Exception e) {
            e.printStackTrace();
        }
        mensageiro.enviarMensagemPrivado(mensageiro.);
        
        //TODO main

    }
}
