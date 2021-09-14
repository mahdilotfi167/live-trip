package co.live.trip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.live.trip.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
