package perfil;

public class PerfilRepositorioList {
    private Item listHead;

    public PerfilRepositorioList() {
        listHead = new Item();
    }
    public class Item {
        private Perfil perfil;
        private Item next;

        public Item getNext() {
            return next;
        }

        public Perfil getPerfil() {
            return perfil;
        }

        public void setNext(Item next) {
            this.next = next;
        }

        public void setPerfil(Perfil perfil) {
            this.perfil = perfil;
        }

        public void insert(Perfil perfil) {
            if (this.getPerfil() == null) {
                this.setPerfil(perfil);
                this.setNext(new Item());
            } else {
                this.getNext().insert(perfil);
            }
        }
        public Perfil findByNumber(String number) throws NumberNotFoundException {
            if (this.getPerfil() != null) {
                if (this.getPerfil().getNumber().equals(number)) {
                    return this.getPerfil();
                } else if (this.getNext() != null) {
                    return this.getNext().findByNumber(number);
                } else {
                    throw new NumberNotFoundException();
                }
            } else {
                throw new NumberNotFoundException();
            }
        }
    }
    public void insert(Perfil perfil) {
        listHead.insert(perfil);
    }

    public Perfil findByNumber(String number) throws NumberNotFoundException {
        return listHead.findByNumber(number);
    }
}
