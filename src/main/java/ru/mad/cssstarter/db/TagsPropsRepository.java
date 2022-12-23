package ru.mad.cssstarter.db;

import org.springframework.data.repository.CrudRepository;
import ru.mad.cssstarter.db.entities.TagsProps;

import java.util.List;

public interface TagsPropsRepository extends CrudRepository<TagsProps,Integer> {
    List<TagsProps> findByTagId(int tagId);
}
