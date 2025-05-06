package juan.product_crud.controller;

import juan.product_crud.entity.Vape;
import juan.product_crud.service.impl.VapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vape")
public class VapeController {
    private final VapeService vapeService;

    public VapeController(VapeService vapeService) {
        this.vapeService = vapeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Vape> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(vapeService.findById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Vape>> findAll() {
        return ResponseEntity.ok(vapeService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Vape> save(@RequestBody Vape vape) {
        return ResponseEntity.ok(vapeService.save(vape));
    }

    @PutMapping
    public ResponseEntity<Vape> update(@RequestBody Vape vape) {
        try {
            vapeService.update(vape);
            return ResponseEntity.ok(vape);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try{
            vapeService.delete(id);
            return ResponseEntity.ok("Vape deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vape with id:" + id + "not founded");
        }
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Vape>> findByBrand(@PathVariable String brand) {
        List<Vape> vapes = vapeService.findAllByBrand(brand);
        if (vapes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vapes);
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Vape>> findAllStock() {
        return ResponseEntity.ok(vapeService.findAllStock());
    }

    @GetMapping("/no-stock")
    public ResponseEntity<List<Vape>> findNoStock() {
        return ResponseEntity.ok(vapeService.findNoStock());
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<String> addStock(@PathVariable Integer id, @RequestParam Integer stock) {
        vapeService.addStock(id, stock);
        return ResponseEntity.ok().body("Stock updated successfully.");
    }

    @GetMapping("/range")
    public ResponseEntity<List<Vape>> betweenPrices(@RequestParam Double min, @RequestParam Double max) {
        List<Vape> vapes = vapeService.betweenPrices(min, max);
        return ResponseEntity.ok(vapes);
    }

    @GetMapping("/flavour/{flavour}")
    public ResponseEntity<List<Vape>> findByFlavour(@PathVariable String flavour) {
        List<Vape> vapes = vapeService.findByFlavour(flavour);
        if (vapes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vapes);
    }

    @GetMapping("/name/{partialName}")
    public ResponseEntity<List<Vape>> findByPartialName(@PathVariable String partialName) {
        List<Vape> vapes = vapeService.findByPartialName(partialName);
        if (vapes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vapes);
    }


}
