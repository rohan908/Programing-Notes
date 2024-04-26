public class Counter {
    private int count;
    public Counter() { this.count = 0; }
    public Counter(Counter other) { this.count = other.count; }
    public int check() { return this.count; }
    public void inc() { this.count++; }
  }
