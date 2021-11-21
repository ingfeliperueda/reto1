/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.service;

import co.edu.usa.model.UserModel;
import co.edu.usa.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Rueda
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<UserModel> getAll() {
        return userRepository.getAll();
    }

    public Optional<UserModel> getUser(int id) {
        return userRepository.getUser(id);
    }

    public UserModel registrar(UserModel user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public UserModel autenticarUsuario(String email, String password) {
        Optional<UserModel> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new UserModel(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
