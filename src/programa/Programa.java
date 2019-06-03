package programa;

import conversas.CadastroConversas;
import conversas.RepositorioConversasArray;
import grupos.CadastroGrupos;
import grupos.RepositorioGruposArray;
import mensageiro.Mensageiro;
import mensagens.CadastroMensagens;
import mensagens.RepositorioMensagensArray;
import perfis.CadastroPerfis;
import perfis.PerfilJaCadastradoException;
import perfis.PerfilNotFoundException;
import perfis.RepositorioPerfisArray;

public class Programa {
    public static void main(String[] args) {
        Mensageiro mensageiro = new Mensageiro(new CadastroPerfis(new RepositorioPerfisArray()), new CadastroConversas(new RepositorioConversasArray(1000)), new CadastroGrupos(new RepositorioGruposArray()), new CadastroMensagens(new RepositorioMensagensArray()));
        try {
            mensageiro.criarUser(true, "aaa", "12345");
            mensageiro.criarUser(true, "bbb", "7272");
            mensageiro.criarUser(true, "ccc", "62137");
            mensageiro.criarUser(true, "ddd", "9999");
            mensageiro.criarUser(true, "eee", "0001");
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        }
        try {
            mensageiro.adicionarContato("0001", "7272");
            mensageiro.adicionarContato("0001", "9999");
        } catch (PerfilJaCadastradoException e) {
            e.printStackTrace();
        } catch (PerfilNotFoundException e) {
            e.printStackTrace();
        }
        //TODO main

    }
}
