package cat.itacademy.s04.t02.n02.Repositories;

import cat.itacademy.s04.t02.n02.Models.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    Optional<Fruit> findByName(String name);
}
