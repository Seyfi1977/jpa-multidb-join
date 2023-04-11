package com.example.jpa.service;

import com.example.jpa.entity.user.User;
import com.example.jpa.repository.product.ProductRepository;
import com.example.jpa.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MultiDBService {

    @PersistenceContext(unitName = "product")
    private EntityManager productEntityManager;

    @PersistenceContext(unitName = "user")
    private EntityManager userEntityManager;


    private final UserRepository userRepository;

    private final ProductRepository productRepository;

@Autowired
public MultiDBService(UserRepository userRepository,
                      ProductRepository productRepository) {
    this.userRepository = userRepository;
    this.productRepository = productRepository;
}

    public List<User> findUsersByCusipNumbers() {
        return userRepository.findByCusipNumberIn(findAllProducts());
    }

    private List<String>  findAllProducts() {
       return productRepository.findAllDistinctCusipNumbers();
    }

}
