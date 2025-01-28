package cat.itacademy.s04.t02.n02.Controllers;
import cat.itacademy.s04.t02.n02.Models.Fruit;
import cat.itacademy.s04.t02.n02.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Fruit> addFruit(@RequestParam String name, @RequestParam int kg) {
        Fruit fruit = new Fruit();
        fruit.setName(name);
        fruit.setKg(kg);
        Fruit newFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok(newFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        Optional<Fruit> fruit = fruitService.getFruitById(id);
        if (fruit.isPresent()) {
            fruitService.deleteFruit(id);
            return ResponseEntity.ok("Fruit deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<String> getFruitById(@PathVariable int id) {
        Optional<Fruit> fruit = fruitService.getFruitById(id);
        if (fruit.isPresent()) {
            return ResponseEntity.ok(fruit.get().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits.toString());
    }
}