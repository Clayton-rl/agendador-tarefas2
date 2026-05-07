package com.javanauta.agendadortarefas2.infrastructure.repository;

import com.javanauta.agendadortarefas2.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}
