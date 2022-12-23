package ru.mad.cssstarter.db;

import org.springframework.data.repository.CrudRepository;
import ru.mad.cssstarter.db.entities.Tag;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag,Integer> {
    List<Tag> findAllBy();
    Tag findById(int id);
    List<Tag> findByName(String name);
}
