import reactor.core.publisher.Flux;

public class FluxDemo {

    public static void main(String[] args) {


        Flux.just(1,2,3,4,5,6).subscribe(System.out::print);
    }
}
