package fr.diginamic.jdbc.entities;

import java.util.List;

import fr.diginamic.props.Producer;

public interface ProducerDao {
    List<Producer> extract();

    void insert(Producer producer);

    int update(String prevName, String newName);

    Boolean delete(Producer producer);

}
