
public class ModeloUmPraUm {
    public static void main(String[] args) {

        int quantidadeDeThreads = 1000;

        long inicio = System.currentTimeMillis();

        Thread[] threads = new Thread[quantidadeDeThreads];
        long[] resultados = new long[quantidadeDeThreads];

        // Cria e inicia as threads
        for (int i = 0; i < quantidadeDeThreads; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                long soma = 0;
                for (int j = 1; j <= 1_000_000; j++) {
                    soma += j;
                }
                resultados[id] = soma;
            });
            threads[i].start();
        }

        // Espera todas terminarem
        for (int i = 0; i < quantidadeDeThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("Modelo 1:1");
        System.out.println("Threads usadas: " + quantidadeDeThreads);
        System.out.println("Tempo total: " + (fim - inicio) + " ms");
    }
}
