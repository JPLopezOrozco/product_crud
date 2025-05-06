package juan.product_crud.service;

import juan.product_crud.entity.Vape;

import java.util.List;

public interface IVapeService {

    Vape findById(Integer id);
    List<Vape> findAll();
    Vape save(Vape vape);
    void delete(Integer id);
    void update(Vape vape);
}
