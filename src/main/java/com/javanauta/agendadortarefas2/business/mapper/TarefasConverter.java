package com.javanauta.agendadortarefas2.business.mapper;

import com.javanauta.agendadortarefas2.business.dto.TarefasDTO;
import com.javanauta.agendadortarefas2.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);

    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
