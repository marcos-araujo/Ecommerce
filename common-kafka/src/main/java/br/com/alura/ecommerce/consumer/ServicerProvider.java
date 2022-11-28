package br.com.alura.ecommerce.consumer;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class ServicerProvider<T> implements Callable<Void> {

    private final ServiceFactory<T> factory;

    public ServicerProvider(ServiceFactory<T> factory) {
        this.factory = factory;
    }

    public Void call() throws ExecutionException, InterruptedException {
        var myService = new EmailService();
        try (var service = new KafkaService(myService.getConsumerGroup(), myService.getTopic(), myService::parse, Map.of())) {
            service.run();
        }
        return null;
    }

}
