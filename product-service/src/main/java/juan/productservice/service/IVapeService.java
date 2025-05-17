package juan.productservice.service;

import juan.productservice.entity.Vape;

import java.util.List;

public interface IVapeService {
    Vape findById(Integer id);
    List<Vape> findAll();
    Vape save(Vape vape);
    void delete(Integer id);
    void update(Vape vape);
    List<Vape> findAllByBrand(String brand);
    List<Vape> findAllStock();
    List<Vape> findNoStock();
    void addStock(Integer id, Integer stock);
    List<Vape> betweenPrices(Double min, Double max);
    List<Vape> findByFlavour(String flavour);
    List<Vape> findByPartialName(String partialName);
}
