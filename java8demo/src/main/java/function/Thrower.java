package function;

public interface Thrower<A,E extends Throwable> {

    public A extract() throws E;
}
