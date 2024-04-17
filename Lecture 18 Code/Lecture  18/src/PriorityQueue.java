import java.util.Optional;
public interface PriorityQueue<T> extends Queue<T>{

    /** Register an element that can jump the queue in front of non-vips (but not other VIPs) */
    public void registerVIP(T vip);

}
