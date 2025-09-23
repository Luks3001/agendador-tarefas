package com.lucas.agendadortarefas.business.mapper;

import com.lucas.agendadortarefas.business.dto.TarefasDTO;
import com.lucas.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity (TarefasDTO dto);

    TarefasDTO paraTarefaDTO (TarefasEntity entity);
}
