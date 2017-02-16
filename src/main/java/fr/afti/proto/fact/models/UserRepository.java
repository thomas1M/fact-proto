package fr.afti.proto.fact.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.CrudRepository;
import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by khoya on 15/02/17.
 */

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT nomUtilisateur FROM User where email = :mail")
    String findUserByMail (@Param("mail") String mail);

    @Modifying
    //@Query("DELETE FROM User u where u.email = ?1")
    void delteUserById(String mail);

    // Doesn't work
    // TODO : learn why
    User findByEmail(String email);
}
