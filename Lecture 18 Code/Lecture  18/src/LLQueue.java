import java.util.LinkedList;
import java.util.Optional;

public class LLQueue<T> implements Queue<T> {

    private LinkedList<T> elements = new LinkedList<>();

    @Override
    public void enqueue(T element){
        elements.addLast(element);
    }

    @Override
    public Optional<T> dequeue(){
        if(elements.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(elements.removeFirst());
        }
    }

    @Override
    public Optional<T> peek(){
        if(elements.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(elements.getFirst());
        }
    }

}
