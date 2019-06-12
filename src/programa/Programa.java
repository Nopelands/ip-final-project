package programa;

import perfis.*;
import conversas.*;
import grupos.*;
import mensagens.*;
import mensageiro.*;

public class Programa {
    public static void main(String[] args) {
        Mensageiro mensageiro = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
        try {
            mensageiro.criarUser(new Perfil("aaa", "177013", new RepositorioPerfisArray()));
            mensageiro.criarUser(new Perfil("bbb", "11037", new RepositorioPerfisArray()));
            mensageiro.criarUser(new Perfil("ccc", "isso nem precisa ser um numero kk", new RepositorioPerfisArray()));
            mensageiro.criarUser(new Perfil("ninguem vai entender as referencias mesmo", "1.048596", new RepositorioPerfisArray()));
            mensageiro.criarUser(new Perfil("emma", "63194", new RepositorioPerfisArray()));
            mensageiro.criarUser(new Perfil("god", "217448", new RepositorioConversasArray()));
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            mensageiro.adicionarContato("11037", "63194");
            mensageiro.adicionarContato("11037", "217448");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //TODO main

    }
}
