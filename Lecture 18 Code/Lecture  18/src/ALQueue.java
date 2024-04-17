import java.util.ArrayList;
import java.util.Queue;

public class ALQueue<T> implements Queue<T> {
    private ArrayList<T> elements = new ArrayList<>();

    @Override
    public void enqueue(T element){
        elements.add(element);

    }

    @Override
    public Optional<T> dequeue(){
        if(elements.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(elements.remove(0));
        }
    }

    @Override
    public Optional<T> peek(){
        if(elements.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(elements.get(0));
        }
    }
}
