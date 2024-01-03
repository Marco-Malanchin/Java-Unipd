public class StackProva{
    public static void main(String[] args){

    }
}
interface Container{
    public boolean isEmpty();
    public void makeEmpty();
}
interface Stack extends Container{
    public void push(Object e);
    public Object top();
    public Object pop();
}