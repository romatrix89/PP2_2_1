package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User us = new User("User5", "Lastname5", "user5@mail.ru");
      User us1 = new User("User6", "Lastname6", "user6@mail.ru");
      User us2 = new User("User7", "Lastname5", "user5@mail.ru");
      User us3 = new User("User8", "Lastname6", "user6@mail.ru");
      us.setCars(new Car("Tesla", 1));
      us1.setCars(new Car("Ferrari", 2));
      us2.setCars(new Car("Lotus", 3));
      us3.setCars(new Car("Lada", 4));
      userService.add(us);
      userService.add(us1);
      userService.add(us2);
      userService.add(us3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCars() != null) {
            System.out.println(user.getCars().toString());
         }
         System.out.println();
      }
      System.out.println(userService.findUserCar("Ferrari", 2).getUsers().toString());
      context.close();
   }
}
