package cat.itacademy.s04.t02.n01.Services;

import cat.itacademy.s04.t02.n01.Models.Fruit;
import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit addFruit(Fruit fruit);
    Fruit updateFruit(Fruit fruit);
    void deleteFruit(int id);
    Optional<Fruit> getFruitById(int id);
    List<Fruit> getAllFruits();
}