/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.repository.crud;

import co.edu.usa.model.UserModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Felipe Rueda
 */
public interface UserCrudRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}
