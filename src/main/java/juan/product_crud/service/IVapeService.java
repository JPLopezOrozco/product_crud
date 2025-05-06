package juan.product_crud.service;

import juan.product_crud.entity.Vape;
import org.springframework.data.repository.query.Param;

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
    Integer addStock(Integer id,Integer stock);
    List<Vape> betweenPrices(Double min, Double max);
    List<Vape> findByFlavour(String flavour);
    List<Vape> findByPartialName(String partialName);
}
