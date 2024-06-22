package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1","LastName1","username1@gmail.com",new Car("BMW",1));
      User user2 = new User("User2","LastName2","username1@gmail.com",new Car("BMW",2));
      User user3 = new User("User3","LastName3","username3@gmail.com",new Car("BMW",3));
      User user4 = new User("User4","LastName4","username4@gmail.com",new Car("BMW",4));

      System.out.println(userService.getCarByUserName("userCar1",1));
      System.out.println(userService.getCarByUserName("userCar3",3));

      List<User> list = userService.listUsers();
      for (User user : list){
         System.out.println(user);
      }
      context.close();
   }
}
