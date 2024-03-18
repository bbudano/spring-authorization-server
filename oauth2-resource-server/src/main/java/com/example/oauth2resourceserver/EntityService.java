package com.example.oauth2resourceserver;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EntityService {

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final Map<Integer, Entity> entityRepository = new ConcurrentHashMap<>();

    @PreAuthorize("hasAuthority('SCOPE_user.write')")
    public Integer createEntity(String name) {
        var id = idGenerator.getAndIncrement();
        entityRepository.put(id, new Entity(id, name));
        return id;
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_user.read', 'SCOPE_user.write')")
    public Entity findById(Integer id) {
        return entityRepository.get(id);
    }

}


