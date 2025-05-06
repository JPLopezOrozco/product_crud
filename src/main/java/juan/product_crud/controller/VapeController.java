package juan.product_crud.controller;

import juan.product_crud.entity.Vape;
import juan.product_crud.service.impl.VapeService;
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
    public Vape findById(@PathVariable Integer id) {
        return vapeService.findById(id);
    }

    @GetMapping()
    public List<Vape> findAll() {
        return vapeService.findAll();
    }

    @PostMapping()
    public Vape save(@RequestBody Vape vape) {
        return vapeService.save(vape);
    }

    @PutMapping
    public Vape update(@RequestBody Vape vape) {
        vapeService.update(vape);
        return vape;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        vapeService.delete(id);
    }

}
