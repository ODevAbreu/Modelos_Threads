

import java.util.concurrent.*;

public class ModeloHibrido {
    public static void main(String[] args) {

        int quantidadeDeThreads = 1000;


        int tamanhoPool = 10;

        ExecutorService pool = Executors.newFixedThreadPool(tamanhoPool);
        CountDownLatch latch = new CountDownLatch(quantidadeDeThreads);
        long[] resultados = new long[quantidadeDeThreads];

        long inicio = System.currentTimeMillis();

        // Envia as tarefas para o pool
        for (int i = 0; i < quantidadeDeThreads; i++) {
            final int id = i;
            pool.execute(() -> {
                long soma = 0;
                for (int j = 1; j <= 1_000_000; j++) {
                    soma += j;
                }
                resultados[id] = soma;
                latch.countDown();
            });
        }

        // Espera todas terminarem
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();

        System.out.println("Modelo N:M");
        System.out.println("Threads de usuário: " + quantidadeDeThreads);
        System.out.println("Threads do sistema (pool): " + tamanhoPool);
        System.out.println("Tempo total: " + (fim - inicio) + " ms");

        pool.shutdown();
    }
}
