package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Cart;
import com.ethioroborobotics.robotics.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;

    public Cart addItemToCart(Cart cartItem){
        return cartRepository.save(cartItem);
    }

    public List<Cart> getAllCartItems(){
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartItemById(Long cartItemId){
        return cartRepository.findById(cartItemId);
    }

    public void deleteCartItem(Long cartItemId){
        cartRepository.deleteById(cartItemId);
    }

}
