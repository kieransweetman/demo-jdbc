package fr.diginamic.props;

import java.util.List;

import fr.diginamic.jdbc.entities.ProducerDaoJDBC;

public class TestProducerDao {

    static ProducerDaoJDBC jdbc = new ProducerDaoJDBC();

    public static void main(String[] args) {
        List<Producer> producers = jdbc.extract();
        // addOne("another test", "iphones");
        for (Producer p : producers) {
            System.out.println(p.toString());
        }

        Producer iphoneProducer = producers.stream().filter((Producer p) -> p.getItem().equals("iphones")).findFirst()
                .orElse(null);
        if (iphoneProducer != null) {
            jdbc.delete(iphoneProducer);
        }
    }

    public static void addOne(String name, String item) {
        List<Producer> producers = jdbc.extract();

        Producer producer = new Producer(producers.get(producers.size() - 1).getId() + 1, name, item);
        jdbc.insert(producer);
    }
}
