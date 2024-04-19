package no.ntnu.IDATA2306.Group6.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import no.ntnu.IDATA2306.Group6.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE (u.name = :name or u.email = :name) AND u.password = :password")
    User findByEmailAndPassword(String name, String password);

  User findByEmail(String name);


  User findOneByEmailOrName(String name, String email);
}
