package ru.mad.cssstarter.db;

import org.springframework.data.repository.CrudRepository;
import ru.mad.cssstarter.db.entities.Propertie;


public interface PropRepository extends CrudRepository<Propertie, Integer> {
    Propertie findById(int id);
}
