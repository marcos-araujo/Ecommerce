package br.com.alura.ecommerce.consumer;

import java.util.concurrent.Executors;

public class ServicerRunner<T> {
    private final ServicerProvider<T> provider;

    public ServicerRunner(ServiceFactory<T> factory) {
        this.provider = new ServicerProvider<>(factory);
    }

    public void start(int threadCount) {
        var pool = Executors.newFixedThreadPool(threadCount);
        for (int i=0; i<=threadCount; i++) {
            pool.submit(provider);
        }
    }
}
