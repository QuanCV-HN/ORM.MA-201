package DAO;

import Utils.HibernateUtils;
import fa.training.entities.MovieType;
import fa.training.entities.Type;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeDAOImpl implements TypeDAO{
    @Override
    public Type create(Type type) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();

            session.save(type);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public List<Type> readALl() {
        List<Type> typeList = null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            Query<Type> query = session.createQuery("SELECT t FROM Type t");
            typeList = query.getResultList();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return typeList;
    }

    @Override
    public Type readById(Integer id) {
        Type type = null;
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();
            type =session.get(Type.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public void update(Type type) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();

            Type typeDB = session.get(Type.class, type.getId());
            typeDB.setName(type.getName());
            typeDB.setDescription(type.getDescription());

            session.update(typeDB);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (
                Session session = HibernateUtils.getSessionFactory().openSession();
        ){
            session.beginTransaction();

            Type type = session.get(Type.class, id);
            session.remove(type);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
