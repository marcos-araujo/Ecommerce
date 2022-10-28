package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BatchSendMessageService {

    private final Connection connection;
    private final KafkaDispatcher<User> userDispatcher = new KafkaDispatcher<>();

    public BatchSendMessageService() throws SQLException {
        String url = "jdbc:sqlite:users_database.db";
        connection = DriverManager.getConnection(url);
        try {
            connection.createStatement().execute("create table Users (" +
                    "uuid varchar(200) primary key ," +
                    "email varchar(200))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        var batchService = new BatchSendMessageService();
        try (var service = new KafkaService<>(BatchSendMessageService.class.getSimpleName(), "USER_GENERATE_READING_REPORT",
                batchService::parse, String.class, new HashMap<>())) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) throws SQLException, ExecutionException, InterruptedException {
        System.out.println("-----");
        System.out.println("Processing new batch");
        System.out.println(record.value());
        var order = record.value();

        for (User user: getAllUsers()) {
            userDispatcher.send(record.value(), user.getUuid(), user);
        }
    }

    private List<User> getAllUsers() throws SQLException {
        var results = connection.prepareStatement("select uuid from User").executeQuery();
        List<User> users = new ArrayList<>();
        while (results.next()) {
            users.add(new User(results.getString(1)));
        }
        return users;
    }

}
