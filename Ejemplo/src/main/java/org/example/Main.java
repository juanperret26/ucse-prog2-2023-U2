package org.example;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;
public class Main {
    public static void main(String[] args) {
        //Implemento una prueba de la clase benchmark para determinar si se tiene que usar stream o parallelStream.
        System.out.print("Inicio la prueba");
        Options options = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .forks(1)
                .build();

        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            throw new RuntimeException(e);
        }
        //Ejercicio 3
        CompletableFuture<Integer> futuro1 = CompletableFuture.supplyAsync(() -> {
            try {
                int randomNum = ThreadLocalRandom.current().nextInt(100, 501);
                System.out.println("El numero del futuro 1 es " + randomNum);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                return randomNum;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> futuro2 = CompletableFuture.supplyAsync(() -> {
            try{
                int randomNum = ThreadLocalRandom.current().nextInt(100, 501);
                System.out.println("El numero del futuro 2 es " + randomNum);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                return randomNum;
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> futuro3 = CompletableFuture.supplyAsync(() -> {
            try{
                int randomNum = ThreadLocalRandom.current().nextInt(100, 501);
                System.out.println("El numero del futuro 3 es " + randomNum);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                return randomNum;
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> futuro4 = CompletableFuture.supplyAsync(() -> {
            try{
                int randomNum = ThreadLocalRandom.current().nextInt(100, 501);
                System.out.println("El numero del futuro 4 es " + randomNum);
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                return randomNum;
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> futuros = CompletableFuture.allOf(futuro1, futuro2, futuro3, futuro4)
                .thenApply(v -> {
                    int sum = 0;
                    sum += futuro1.join();
                    sum += futuro2.join();
                    sum += futuro3.join();
                    sum += futuro4.join();
                    return sum;
                });

        int suma = futuros.join();
        System.out.println("La suma es : " + suma);

        //Ejercicio 4
        //Uso los mismos completable future que antes pero modifico "futuros"
        CompletableFuture<Object> fastest = CompletableFuture.anyOf(futuro1, futuro2, futuro3, futuro4);
        try {
            System.out.println("El resultado más rápido es: " + fastest.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}