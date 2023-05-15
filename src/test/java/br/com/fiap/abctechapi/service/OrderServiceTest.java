package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.entity.OrderLocation;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @MockBean
    private AssistanceRepository assistanceRepository;
    @MockBean
    private OrderRepository orderRepository;

    private OrderService orderService;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(assistanceRepository, orderRepository);
        when(assistanceRepository.findById(any()))
                .thenReturn(Optional.of(new Assistance(1L, "Test", "Teste Description")));
    }

        //Minimum assist >0
        @Test
        public void create_order_error_min_assist(){
            Order newOrder = new Order();
            newOrder.setOperatorId(1234L);
            Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
            Mockito.verify(orderRepository, times(0)).save(newOrder);
        }
        //max assist <=15
        @Test
        public void create_order_error_max_assist() {
            Order newOrder = new Order();
            newOrder.setOperatorId(1234L);
            Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L, 16L)));
            Mockito.verify(orderRepository, times(0)).save(newOrder);
        }
        //cenario criando order
        public void create_order_success() throws Exception {
            Order newOrder = new Order();

            // Create mock data
            newOrder.setOperatorId(1234L);

            List<Long> assists = List.of(1L, 2L, 3L);

            Assistance assistance1 = new Assistance();
            assistance1.setId(1L);

            Assistance assistance2 = new Assistance();
            assistance2.setId(2L);

            Assistance assistance3 = new Assistance();
            assistance3.setId(3L);

            // Mock the behavior of assistanceRepository.findById
            Mockito.when(assistanceRepository.findById(1L)).thenReturn(Optional.of(assistance1));
            Mockito.when(assistanceRepository.findById(2L)).thenReturn(Optional.of(assistance2));
            Mockito.when(assistanceRepository.findById(3L)).thenReturn(Optional.of(assistance3));

            // Call the method
            orderService.saveOrder(newOrder, assists);

            // Verify the behavior
            Mockito.verify(assistanceRepository, times(3)).findById(anyLong());
            Mockito.verify(orderRepository, times(1)).save(newOrder);
        }
}