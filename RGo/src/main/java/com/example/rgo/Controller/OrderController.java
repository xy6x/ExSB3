package com.example.rgo.Controller;

import com.example.rgo.Model.Order;
import com.example.rgo.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    Logger logger= LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/get")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
    @PostMapping("/add")
    public ResponseEntity addOlder(@RequestBody @Valid Order order){
        logger.info("added Older");
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body("add Older");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateOlder(@PathVariable Integer id, @RequestBody @Valid Order order) {
        logger.info("update Older");

        orderService.updateOrder(id, order);
        return ResponseEntity.status(HttpStatus.OK).body("Update Older");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOlder(@PathVariable Integer id) {
        logger.info("delete Older");
        return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(id));
    }
    @PutMapping("/rival/{id}")
    public ResponseEntity rival(@PathVariable Integer id){
        Order ord =orderService.rival(id);
        return ResponseEntity.status(HttpStatus.OK).body(ord);

    }
//    @PutMapping("/total/{id}")
//    public ResponseEntity total(@PathVariable Integer id){
//        Order ord =orderService.totals(id);
//        return ResponseEntity.status(HttpStatus.OK).body(ord);
//    }
    @GetMapping("/don/{id}")
    public ResponseEntity don(@PathVariable Integer id){
        Order ord =orderService.don(id);
        return ResponseEntity.status(HttpStatus.OK).body(ord);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity user(@PathVariable Integer id){
       Integer users =orderService.checkUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/dsTotal/{id}/{id2}")
    public ResponseEntity desTotal(@PathVariable Integer id,@PathVariable Integer id2){
        Order order =orderService.coupon(id, id2);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }


    }
