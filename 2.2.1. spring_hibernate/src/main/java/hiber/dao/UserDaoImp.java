package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user.getCar());
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User user left join fetch user.car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getCarByUserName(String model, int series) {
      String HQL = "FROM User user left join fetch user.car car WHERE car.model LIKE :model AND car.series LIKE :series";
      User user = sessionFactory.getCurrentSession().createQuery(HQL,User.class)
              .setParameter("model",model)
              .setParameter("series",series)
              .uniqueResult();
      return user;
   }
}
