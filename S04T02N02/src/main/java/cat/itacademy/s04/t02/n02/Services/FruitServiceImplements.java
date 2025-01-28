package cat.itacademy.s04.t02.n02.Services;

import cat.itacademy.s04.t02.n02.Exceptions.DuplicateFruitException;
import cat.itacademy.s04.t02.n02.Models.Fruit;
import cat.itacademy.s04.t02.n02.Repositories.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImplements implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit) {
        Optional<Fruit> existingFruit = fruitRepository.findByName(fruit.getName());
        if (existingFruit.isPresent()) {
            throw new DuplicateFruitException("Fruit with name " + fruit.getName() + " already exists.");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(int id) {
        fruitRepository.deleteById(id);
    }

    @Override
    public Optional<Fruit> getFruitById(int id) {
        return fruitRepository.findById(id);
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}