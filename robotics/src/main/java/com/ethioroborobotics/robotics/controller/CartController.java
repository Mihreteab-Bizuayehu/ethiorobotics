package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Cart;
import com.ethioroborobotics.robotics.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart_items")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cartItem){

        Cart createdCartItem=cartService.addItemToCart(cartItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCartItem);
    }

    @GetMapping()
    public ResponseEntity<List<Cart>> getAllCartItems(){

        List<Cart> cartItems=cartService.getAllCartItems();

        return ResponseEntity.status(HttpStatus.OK).body(cartItems);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Optional<Cart>> getCartItemById(@PathVariable("id") Long cartItemId){

        Optional<Cart> cartItem=cartService.getCartItemById(cartItemId);

        return ResponseEntity.status(HttpStatus.OK).body(cartItem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long cartItemId){

        cartService.deleteCartItem(cartItemId);

    }
}
