package ru.mad.cssstarter.db;

import org.springframework.data.repository.CrudRepository;
import ru.mad.cssstarter.db.entities.Htmlmark;

public interface HtmlmarkRepository  extends CrudRepository<Htmlmark, Integer>{
    Htmlmark findById(int id);
}
