import java.util.List;

public interface CocheCRUD {

    void save(CocheCRUDImpl coche);
    List<CocheCRUDImpl> findAll();
    void delete(CocheCRUDImpl coche);
}
