package juan.product_crud.service.impl;

import juan.product_crud.entity.Vape;
import juan.product_crud.exception.InvalidStockException;
import juan.product_crud.repository.VapeRepository;
import juan.product_crud.service.IVapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VapeService implements IVapeService {

    private final VapeRepository vapeRepository;

    @Autowired
    public VapeService(VapeRepository vapeRepository) {
        this.vapeRepository = vapeRepository;
    }

    @Override
    public Vape findById(Integer id) {
        return vapeRepository.findById(id).orElseThrow(() -> new RuntimeException("Vape not found"));
    }

    @Override
    public List<Vape> findAll() {
        return vapeRepository.findAll();
    }

    @Override
    public Vape save(Vape vape) {
        return vapeRepository.save(vape);
    }

    @Override
    public void delete(Integer id) {
        vapeRepository.deleteById(id);
    }

    @Override
    public void update(Vape vape) {
        vapeRepository.save(vape);
    }

    @Override
    public List<Vape> findAllByBrand(String brand) {
        return vapeRepository.findAllByBrand(brand);
    }

    @Override
    public List<Vape> findAllStock() {
        return vapeRepository.findAllStock();
    }

    @Override
    public List<Vape> findNoStock() {
        return vapeRepository.findNoStock();
    }

    @Override
    public Integer addStock(Integer id, Integer stock) {
        if (stock <= 0){
            throw new InvalidStockException("Stock must be greater than 0");
        }else{
            return vapeRepository.addStock(id, stock);
        }
    }

    @Override
    public List<Vape> betweenPrices(Double min, Double max) {
        if(min>max){
            throw new ArithmeticException("Min and max must be greater than max");
        }
        return vapeRepository.betweenPrices(min, max);
    }

    @Override
    public List<Vape> findByFlavour(String flavour) {
        return vapeRepository.findByFlavour(flavour);
    }

    @Override
    public List<Vape> findByPartialName(String partialName) {
        return vapeRepository.findByPartialName(partialName);
    }
}
