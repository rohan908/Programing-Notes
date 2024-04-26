
public class B {
    private Counter counter;
    public B(Counter counter) {
      this.counter = new Counter(counter);
    }
    public int click() { 
       this.counter.inc();
       return this.counter.check(); 
    }
}