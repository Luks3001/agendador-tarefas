package com.lucas.agendadortarefas.business;

import com.lucas.agendadortarefas.business.dto.TarefasDTO;
import com.lucas.agendadortarefas.business.mapper.TarefasConverter;
import com.lucas.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.lucas.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.lucas.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.lucas.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token,TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));

    }
}
