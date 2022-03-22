package spring.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.model.Coffee;
import spring.demo.model.CoffeeOrder;
import spring.demo.model.OrderState;
import spring.demo.repository.CoffeeOrderRepository;

import java.util.ArrayList;
import java.util.Arrays;


@Service
@Slf4j
@Transactional
public class CoffeeOrderService {


    @Autowired
    private CoffeeOrderRepository orderRepository;

    // 增加数据 （添加订单）
    public CoffeeOrder createOrder(String customer, Coffee...coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    }

    // 修改数据 (更改咖啡订单)
    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }
}



