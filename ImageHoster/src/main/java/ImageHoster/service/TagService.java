package ImageHoster.service;

import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag getTagByName(String title) {
        System.out.println("GOOOOO gettabbyname tagService");
        return tagRepository.findTag(title);
    }

    public Tag createTag(Tag tag) {
        System.out.println("GOOOOO createTag tagService");
        return tagRepository.createTag(tag);
    }
}
