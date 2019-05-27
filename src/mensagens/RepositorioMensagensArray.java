package mensagens;

public class RepositorioMensagensArray implements RepositorioMensagens {
    private Mensagem [] mensagens;
    public RepositorioMensagensArray(){
        mensagens = new Mensagem [0];
    }
    public void inserir(Mensagem mensagem) {
        Mensagem [] temp = new Mensagem [mensagens.length+1];
        for (int i = 0; i<mensagens.length; i++){
            temp[i] = mensagens[i];
            temp[temp.length - 1] = mensagem;
            mensagens = temp;
        }
    }
    public boolean existe(String mensagem) {
        boolean encontrou =  false;
        for (int i = 0; i < mensagens.length && !encontrou; i++) {
            encontrou = mensagens[i].getMensagem().equals(mensagem);
        } return encontrou;

    }
    public void remover(String mensagem) throws MensagemNaoEncontradaException {
        boolean encontrou = false;
        int indice = 0;
        for (int i = 0; i < mensagens.length && !encontrou; i++) {
            if (mensagens[i].getMensagem().equals(mensagem)) {
                encontrou = true;
                indice = i;
            }
        }
        if (!encontrou) {
            throw new MensagemNaoEncontradaException();
        } else {
            Mensagem [] temp = new Mensagem [mensagens.length - 1];
            for (int i = 0; i < mensagens.length; i++) {
                if (i < indice) {
                    temp[i] = mensagens[i];
                } else {
                    temp[i] = mensagens[i + 1];
                }
            }
            mensagens = temp;
        }
    }
    public String [] procurar(String remetente) throws RemetenteNaoEncontradoException{
        boolean encontrou = false;
        String [] mensagensremetente = new String[0];
        for (int i = 0; i<mensagens.length;i++){
            if (mensagens[i].getRemetente().equals(remetente)) {
                encontrou = true;
                String [] aux =  new String[mensagensremetente.length+1];
                for (int j = 0; j<mensagensremetente.length; j++){
                    aux[i] = mensagensremetente[i];
                    aux[aux.length-1] = mensagens[i].getMensagem();
                }
                mensagensremetente = aux;

            }
        }
        if (encontrou)  {
            return mensagensremetente;
        } else {
            throw new RemetenteNaoEncontradoException();
        }
    }
    public void atualizar(String mensagem, String atualizado) throws MensagemNaoEncontradaException {
        boolean naoencontrou = true;
        for (int i = 0; i<mensagens.length && naoencontrou; i++){
            if (mensagens[i].getMensagem().equals(mensagem)) {
                mensagens[i].setMensagem(atualizado);
                naoencontrou = false;
            }
        }
        if (naoencontrou) {
            throw new MensagemNaoEncontradaException();
        }
    }
}
