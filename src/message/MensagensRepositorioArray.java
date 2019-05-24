package mensagens;
public class  MensagensRepositorioArray implements MensagensRepositorio {
    private String [] mensagens;
    public MensagensRepositorioArray(){
        mensagens = new String[0];
    }
    public void inserir(String mensagem) {
        String [] temp = new String[mensagens.length+1];
        for (int i = 0; i<mensagens.length; i++){
            temp[i] = mensagens[i];
            temp[temp.length - 1] = mensagem;
            mensagens = temp;
        }
    }
    public boolean existe(String mensagem) {
        boolean encontrou =  true;
        for (int i = 0; i < mensagens.length && !encontrou; i++) {
            if (mensagens[i].equals(mensagem)) {
                encontrou =  true;
            } else {
                encontrou =  false;
            }
        } return encontrou;

    }
    public void remover(String mensagem) throws MensagemNaoEncontradaException {
        boolean encontrou = false;
        int indice = 0;
        for (int i = 0; i < mensagens.length && !encontrou; i++) {
            if (mensagens[i].equals(mensagem)) {
                encontrou = true;
                indice = i;
            }
        }
        if (!encontrou) {
            throw new MensagemNaoEncontradaException();
        } else {
            String [] temp = new String[mensagens.length - 1];
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

}
