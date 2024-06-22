package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}
