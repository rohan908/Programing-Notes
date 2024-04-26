public class A {
    private Counter counter;
    public A(Counter counter) {
      this.counter = counter;
    }
    public int click() { 
       this.counter.inc();
       return this.counter.check(); 
    }
  }
