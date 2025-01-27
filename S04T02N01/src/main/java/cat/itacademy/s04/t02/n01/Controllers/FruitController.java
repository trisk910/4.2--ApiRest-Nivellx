package cat.itacademy.s04.t02.n01.Controllers;
import cat.itacademy.s04.t02.n01.Models.Fruit;
import cat.itacademy.s04.t02.n01.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/")
    public String welcomeMessage() {
        return "Benvinguts a la Fruiteria! \n" +
                "Utilitza les seguents commandes:  \n" +
                " /fruita/add \n" +
                " /fruita/update \n" +
                " /fruita/delete/{id} \n-" +
                " /fruita/getOne/{id} \n" +
                " /fruita/getAll";
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestParam String name, @RequestParam int quantityKilos) {
        Fruit fruit = new Fruit();
        fruit.setName(name);
        fruit.setQuantityKilos(quantityKilos);
        Fruit newFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok(newFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        Optional<Fruit> fruit = fruitService.getFruitById(id);
        return fruit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }
}