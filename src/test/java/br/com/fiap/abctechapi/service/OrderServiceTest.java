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
            Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 1L, 2L)));
            Mockito.verify(orderRepository, times(0)).save(newOrder);
        }
        //cenario criando order
        @Test
        public void create_order_success() throws Exception {
            Order newOrder = new Order();
            newOrder.setOperatorId(1234L);

            orderService.saveOrder(newOrder, generate_mocks_ids(5));
            Mockito.verify(orderRepository, times(1)).save(newOrder);
        }
        private List<Long> generate_mocks_ids(int number){
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int x= 0; x< number; x++){
                arrayList.add(Integer.toUnsignedLong(x));

            }
            return arrayList;



        }

    }

