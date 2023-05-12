package br.com.fiap.abctechapi.Application;

import br.com.fiap.abctechapi.Application.dto.OrderDto;

public interface OrderApplication {

    public void createOrder(OrderDto orderDto) throws Exception;
}
