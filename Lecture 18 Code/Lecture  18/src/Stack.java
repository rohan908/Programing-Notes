import java.util.Optional;
/** LIFO Data Structure */
public interface Stack<T> {

    public void push(T element);
    public Optional<T> pop();

    public Optional<T> peek();
}
