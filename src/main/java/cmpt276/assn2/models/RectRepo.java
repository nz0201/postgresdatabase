package cmpt276.assn2.models;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RectRepo extends JpaRepository<Rectangle,Integer>{
    List<Rectangle> findByName(String name);
    List<Rectangle> findByHeightAndWidth(int height, int width);
}