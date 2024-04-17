import java.util.LinkedList;

public class LLPrioQueue<T> implements PriorityQueue<T> {

    private LinkedList<T> elements = new LinkedList<>();

    private int vipIndex = 0;
    private HashSet<T> vips = new HashSet<>();


    @Override
    public void registerVIP(T vip){
        vips.add(vip);
    }

    @Override
    public void enqueue(T element){
        if(vips.constains(element)){
            elements.add(vipIndex, element);
            vipIndex++;
        }
        else{
            elements.addLast(element);
        }
    }

    @Override
    public Optional<T> dequeue(){
        if(elements.isEmpty()){
            return Optional.empty();
        }
        else{
            if 
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
