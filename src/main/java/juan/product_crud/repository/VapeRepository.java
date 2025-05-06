package juan.product_crud.repository;

import juan.product_crud.entity.Vape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VapeRepository extends JpaRepository<Vape, Integer> {
    @Query("SELECT v FROM Vape v WHERE v.brand = :brand")
    List<Vape> findAllByBrand(@Param("brand") String brand);

    @Query("SELECT v FROM Vape v WHERE v.stock > 0")
    List<Vape> findAllStock();

    @Query("SELECT v FROM Vape v WHERE v.stock = 0")
    List<Vape> findNoStock();

    @Modifying
    @Transactional
    @Query("UPDATE Vape v SET v.stock = v.stock + :stock WHERE v.id = :id")
    Integer addStock(@Param("id") Integer id,
                         @Param("stock") Integer stock);
    @Query("SELECT v FROM Vape v WHERE v.price >= :min AND v.price <= :max")
    List<Vape> betweenPrices(Double min, Double max);

    @Query("SELECT v FROM Vape v WHERE v.flavour = :flavour")
    List<Vape> findByFlavour(String flavour);

    @Query("SELECT v FROM Vape v WHERE LOWER(v.name) LIKE LOWER ((CONCAT('%', :partialName, '%'))) ")
    List<Vape> findByPartialName(String partialName);

}
