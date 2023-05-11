package br.com.fiap.abctechapi.Application;

import br.com.fiap.abctechapi.Application.dto.AssistResponseDto;

import java.util.List;

public interface AssistanceApplication {

    public List<AssistResponseDto> getAssists();
}
