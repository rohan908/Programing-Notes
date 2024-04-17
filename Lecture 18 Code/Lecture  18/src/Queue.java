import java.util.Optional;
/** FIFO Data structure */
public interface Queue<T> {

    public void enqueue(T element);
    public Optional<T> dequeue();

    public Optional<T> peek();

}
