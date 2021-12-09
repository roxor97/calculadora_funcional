import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculadora {

        public static void main(String[] args) {


            BiFunction<Integer,Integer,Integer> sumar=(a, b)->a+b;
            BiFunction<Integer,Integer,Integer> restar=(a, b)->a-b;

            BiFunction<Integer, Integer, Integer> multi = (a,b) ->
                    IntStream.range(0,b+1)
                            .reduce((acomulador,numero)-> sumar.apply(acomulador,a))
                            .getAsInt();

            BiFunction<Integer,Integer,Integer> divisionEntera = (num,den) ->{
                return IntStream.range(0, num+1)
                        .reduce((acumulador, numero) -> {
                            if (multi.apply(numero,den)<=num) {
                                return acumulador = acumulador+1;
                            }
                            return acumulador;
                        }).getAsInt();
            };
            System.out.println(sumar.apply(2,5));
            System.out.println(restar.apply(5,2));
            System.out.println(multi.apply(4,5));//20
            System.out.println(divisionEntera.apply(95,3));//2

        }

}
