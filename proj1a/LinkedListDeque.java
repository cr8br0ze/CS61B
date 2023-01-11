public class LinkedListDeque<T>{
    //nodes
    public class SomethingNode{
        public T item;
        public SomethingNode next;
        public SomethingNode(T i, SomethingNode n){
            item = i;
            next = n;
        }
    }

    //start of int list
    public SomethingNode first;
    public LinkedListDeque(T i){
        first = new SomethingNode(i, null);
    }

    //Add first method
    public void addFirst(T item){
        first = new SomethingNode(item, first);
    }

    //double ended circulation
    public void addLast(T item){

    }
    public boolean isEmpty(){
        return true;
    }
    public int size(){
        return 0;
    }
    public void printDeque(){

    }
    public T removeFirst(){
        return first.item;
    }
    public T removeLast(){
        return first.item;
    }
    public T get(int index){
        return first.item;
    }
}