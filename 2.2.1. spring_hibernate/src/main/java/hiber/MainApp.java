package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@gmail.com", new Car("BMW", 1)));
      userService.add(new User("User2", "Lastname2", "user2@gmail.com", new Car("Nissan", 2)));
      userService.add(new User("User3", "Lastname3", "user3@gmail.com", new Car("Mitsubishi", 3)));
      userService.add(new User("User4", "Lastname4", "user4@gmail.com", new Car("Cadilac", 4)));
      userService.add(new User("User5", "Lastname5", "user5@gmail.com", null));
      userService.add(new User("User6", "Lastname6", "user7@gmail.com"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         if(user.getCar() != null){
            System.out.println(user);
         } else {
            System.out.println(user.toString2());
         }
      }
      User byUserCar = userService.getUserByCarModelAndSeries("Nissan", 2);
      System.out.println(byUserCar);

      context.close();
   }
}
