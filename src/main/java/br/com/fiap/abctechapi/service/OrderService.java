package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> assistsId) throws Exception;


}
