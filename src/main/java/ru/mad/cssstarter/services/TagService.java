package ru.mad.cssstarter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mad.cssstarter.db.PropRepository;
import ru.mad.cssstarter.db.TagRepository;
import ru.mad.cssstarter.db.TagsPropsRepository;
import ru.mad.cssstarter.db.entities.Propertie;
import ru.mad.cssstarter.db.entities.Tag;
import ru.mad.cssstarter.db.entities.TagsProps;
import ru.mad.cssstarter.json.TagWithProps;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TagService {
    TagRepository tagRepository;
    PropRepository propRepository;
    TagsPropsRepository tagsPropsRepository;

    @Autowired
    public TagService(TagRepository tagRepository, PropRepository propRepository, TagsPropsRepository tagsPropsRepository) {
        this.tagRepository = tagRepository;
        this.propRepository = propRepository;
        this.tagsPropsRepository = tagsPropsRepository;
    }

    public ArrayList<TagWithProps> getAllTags() {
        ArrayList<Tag> tags = (ArrayList<Tag>) tagRepository.findAllBy();
        ArrayList<TagWithProps> tagsWithProps = new ArrayList<>();
        for (Tag tag : tags) {
            ArrayList<TagsProps> propIds = (ArrayList<TagsProps>) tagsPropsRepository.findByTagId(tag.getId());
            ArrayList<Propertie> props = new ArrayList<>();
            for (TagsProps propId: propIds){
                props.add(propRepository.findById(propId.getPropId()));
            }
            TagWithProps tagWithProps = new TagWithProps(tag.getId(),tag.getName(),tag.getDesc(), props);
            tagsWithProps.add(tagWithProps);
        }
        tagsWithProps.sort((a,b)-> b.getId()-a.getId());
        return tagsWithProps;
    }
}
