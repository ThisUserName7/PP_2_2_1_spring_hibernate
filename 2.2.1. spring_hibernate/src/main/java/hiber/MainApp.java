package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("user1","lastName1","email1@mail.ru").setCar(new Car("Model1",11)));
      userService.add(new User("user2","lastName2","email2@mail.ru").setCar(new Car("Model2",22)));
      userService.add(new User("user3","lastName3","email3@mail.ru").setCar(new Car("Model3",33)));
      userService.add(new User("user4","lastName4","email4@mail.ru").setCar(new Car("Model4",44)));
      userService.add(new User("user5","lastName5","email5@mail.ru").setCar(new Car("Model5",55)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id is - " + user.getId());
         System.out.println("Name is - " + user.getFirstName());
         System.out.println("Last name is - " + user.getLastName());
         System.out.println("User email is - " + user.getEmail());
         System.out.println("Car is -" + "{"+user.getCar()+"}");
      }

      System.out.println();

      User user = userService.getUserByCar("Model1",11);
      System.out.println("For user id = "+user.getId() + "Name is - " + user.getFirstName() + " Last name is - " + user.getLastName() + " Email is - " + user.getEmail()+ "Car is - " + "{ "+user.getCar()+" }");

      try {
         User notFoundUser = userService.getUserByCar("Model767",88);
      } catch (NoResultException e) {
         System.out.println("No found");
      }
      context.close();
   }
}
