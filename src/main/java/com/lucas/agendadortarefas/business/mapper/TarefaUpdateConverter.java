package com.lucas.agendadortarefas.business.mapper;

import com.lucas.agendadortarefas.business.dto.TarefasDTO;
import com.lucas.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {
    void updateTarefas (TarefasDTO dto,@MappingTarget TarefasEntity entity);




}
