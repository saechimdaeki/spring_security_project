package me.saechimdaeki.security.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.saechimdaeki.security.domain.Resources;
import me.saechimdaeki.security.repository.ResourcesRepository;
import me.saechimdaeki.security.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service

public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private me.saechimdaeki.security.repository.ResourcesRepository ResourcesRepository;

    @Transactional
    public Resources getResources(long id) {
        return ResourcesRepository.findById(id).orElse(new Resources());
    }

    @Transactional
    public List<Resources> getResources() {
        return ResourcesRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Transactional
    public void createResources(Resources resources){
        ResourcesRepository.save(resources);
    }

    @Transactional
    public void deleteResources(long id) {
        ResourcesRepository.deleteById(id);
    }
}