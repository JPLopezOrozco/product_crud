package juan.product_crud.service.impl;

import juan.product_crud.entity.Vape;
import juan.product_crud.service.IVapeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VapeService implements IVapeService {

    private final Map<Integer, Vape> vapeStore = new HashMap<>();
    private Integer nextId = 1;


    @Override
    public Vape findById(Integer id) {
        return vapeStore.get(id);
    }

    @Override
    public List<Vape> findAll() {
        return new ArrayList<>(vapeStore.values());
    }

    @Override
    public Vape save(Vape vape) {
        Vape newVape = Vape.builder()
                .id(nextId++)
                .brand(vape.getBrand())
                .name(vape.getName())
                .flavour(vape.getFlavour())
                .puffs(vape.getPuffs())
                .price(vape.getPrice())
                .stock(vape.getStock())
                .build();
        vapeStore.put(newVape.getId(), newVape);

        return newVape;
    }

    @Override
    public void delete(Integer id) {
        vapeStore.remove(id);
    }

    @Override
    public void update(Vape vape) {
        vapeStore.put(vape.getId(), vape);
    }
}
