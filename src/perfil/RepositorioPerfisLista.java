//TODO everything
//package perfil;
//
//public class RepositorioPerfisLista implements RepositorioPerfis {
//    private Item listHead;
//
//    public RepositorioPerfisLista() {
//        listHead = new Item();
//    }
//    public class Item {
//        private Perfis perfil;
//        private Item next;
//        private int index;
//
//        public Item(int index) {
//            this.perfil = null;
//            this.next = null;
//            this.index = index;
//        }
//        public int getIndex() {
//            return index;
//        }
//
//        public Item getNext() {
//            return next;
//        }
//
//        public Perfis getPerfil() {
//            return perfil;
//        }
//
//        public void setNext(Item next) {
//            this.next = next;
//        }
//
//        public void setPerfil(Perfis perfil) {
//            this.perfil = perfil;
//        }
//
//        public void inserir(Perfis perfil, int index) {
//            if (this.getPerfil() == null) {
//                this.setPerfil(perfil);
//                this.setNext(new Item());
//                this.index = 0;
//            } else {
//                this.getNext().insert(perfil, this.index+1);
//            }
//        }
//        public Perfis findByNumber(String number) throws NumberNotFoundException {
//            if (this.getPerfil() != null) {
//                if (this.getPerfil().getNumber().equals(number)) {
//                    return this.getPerfil();
//                } else {
//                    return this.getNext().findByNumber(number);
//                }
//            } else {
//                throw new NumberNotFoundException();
//            }
//        }
//
//        public void remover(String number) throws NumberNotFoundException {
//            if (this.getNext().getPerfil() == null) {
//                if ()
//            }
//        }
//    }
//    public void inserir(Perfis perfil) {
//        listHead.inserir(perfil);
//    }
//
//    public Perfis findByNumber(String number) throws NumberNotFoundException {
//        return listHead.findByNumber(number);
//    }
//
//    public void remover(String number) {
//        listHead.remover(number);
//    }
//    //TODO remove
//    //Todo lenght
//}
