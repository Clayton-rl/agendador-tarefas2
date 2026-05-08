package com.javanauta.agendadortarefas2.business;

import com.javanauta.agendadortarefas2.business.dto.TarefasDTO;
import com.javanauta.agendadortarefas2.business.mapper.TarefasConverter;
import com.javanauta.agendadortarefas2.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas2.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas2.infrastructure.repository.TarefasRepository;
import com.javanauta.agendadortarefas2.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravaTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefasEntity(dto);

        return tarefasConverter.paraTarefasDTO(tarefasRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return tarefasConverter.paraListaTarefasDTO(
                tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extractEmailToken(token.substring(7));

        return tarefasConverter.paraListaTarefasDTO(tarefasRepository.findByEmailUsuario(email));
    }
}
