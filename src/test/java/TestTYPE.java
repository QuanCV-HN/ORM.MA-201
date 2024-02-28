import DAO.TypeDAO;
import DAO.TypeDAOImpl;
import fa.training.entities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTYPE {
    TypeDAO typeDAO = new TypeDAOImpl();

    @Test
    public  void create(){
        Type type = new Type();
        type.setName("Kinh di");
        type.setDescription("Hay, dac sac");

        Assertions.assertNotNull(typeDAO.create(type).getId());
    }

    @Test
    public void readAll(){

        List<Type> typeList = typeDAO.readALl();
        typeList.forEach(l ->{
            System.out.println(l);
        });
        Assertions.assertNotNull(typeList);
    }

    @Test
    public void read_by_id(){
        Integer id = 1;
        Type type = typeDAO.readById(id);
        System.out.println(type);
        Assertions.assertNotNull(type);
    }

    @Test
    public void update(){
        Type type = new Type();
        type.setId(1);
        type.setName("Trinh tham");
        type.setDescription("hap dan");
        typeDAO.update(type);
        Type typeUpdated = typeDAO.readById(type.getId());

        Assertions.assertEquals(type.getName(), typeUpdated.getName());
    }

    @Test
    public void delete(){
        Integer id = 1;
        typeDAO.delete(id);

        Type type = typeDAO.readById(id);

        Assertions.assertNull(type);
    }
}
