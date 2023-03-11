public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public int size() {
        return this.tamanhoLista;
    }

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0 ? true : false;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(this.cauda);
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void add(int index, T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(this.cauda);
        } else {
            No<T> noAuxiliar = getNo(index);
            novoNo.setNoProximo(noAuxiliar);
            if (index != 0){
                noAuxiliar = getNo(index -1);
                noAuxiliar.setNoProximo(novoNo);
            } else {
                this.cauda = novoNo;
                this.cabeca.setNoProximo(novoNo);
            }
        }
        tamanhoLista++;
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("O indice e maior que o tamanho da lista.");
        }
        No<T> noAuxiliar = this.cauda;
        if (index == 0) {
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        } else if (index == 1) {
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        } else {
            for (int i = 0; i < index-1; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("A lista esta vazia!");
        }

        if (index == 0) {
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < index; i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}] ---> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao Inicio)" : "[]";

        return strRetorno;
    }
}
