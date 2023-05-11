package br.com.fiap.abctechapi.Application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssistResponseDto {
    private Long id;
    private String title;
    private String description;
}
