package br.com.fiap.abctechapi.application;

import br.com.fiap.abctechapi.Application.AssistanceApplication;
import br.com.fiap.abctechapi.Application.dto.AssistResponseDto;
import br.com.fiap.abctechapi.Application.impl.AssistanceApplicationImpl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AssistanceAppTest {
    private AssistanceApplication assistanceApp;

    @MockBean
    private AssistanceServiceImpl assistanceService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceApp = new AssistanceApplicationImpl(assistanceService);
    }

    @Test
    public void test_get_assistence() {
        // Mock the data
        Assistance assistance1 = new Assistance(1L, "Assist 1", "Description 1");
        Assistance assistance2 = new Assistance(2L, "Assist 2", "Description 2");
        List<Assistance> assistanceList = Arrays.asList(assistance1, assistance2);
        Mockito.when(assistanceService.getAssists()).thenReturn(assistanceList);

        // Expected
        AssistResponseDto dto1 = new AssistResponseDto(1L, "Assist 1", "Description 1");
        AssistResponseDto dto2 = new AssistResponseDto(2L, "Assist 2", "Description 2");
        List<AssistResponseDto> expectedDtoList = Arrays.asList(dto1, dto2);

        // Call the method
        List<AssistResponseDto> actualDtoList = assistanceApp.getAssists();

        // Verify
        Assertions.assertEquals(expectedDtoList, actualDtoList);
        Mockito.verify(assistanceService).getAssists();
    }

}