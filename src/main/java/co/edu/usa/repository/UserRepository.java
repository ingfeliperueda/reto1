/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.repository;

import co.edu.usa.model.UserModel;
import co.edu.usa.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe Rueda
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<UserModel> getAll() {
        return (List<UserModel>) userCrudRepository.findAll();
    }

    public Optional<UserModel> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public UserModel save(UserModel user) {
        return userCrudRepository.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<UserModel> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<UserModel> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
