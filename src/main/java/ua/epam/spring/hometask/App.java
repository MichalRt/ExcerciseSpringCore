package ua.epam.spring.hometask;

import java.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.DataStorage;
import ua.epam.spring.hometask.service.AuditoriumImpl;
import ua.epam.spring.hometask.service.EventService;
import ua.epam.spring.hometask.service.EventServiceImpl;
import ua.epam.spring.hometask.service.UserServiceImpl;
import ua.epam.spring.hometask.service.discountStrategy.DiscountManager;

public class App {

    UserServiceImpl userService;
    AuditoriumImpl auditoriumService;
    EventServiceImpl eventService;
    DiscountManager discountManager;

    public App(UserServiceImpl userService,
        AuditoriumImpl auditoriumService, EventServiceImpl eventService,
        DiscountManager discountManager) {
        this.userService = userService;
        this.auditoriumService = auditoriumService;
        this.eventService = eventService;
        this.discountManager = discountManager;
    }

    public App(UserServiceImpl userService,AuditoriumImpl auditorium,EventServiceImpl eventService) {
        this.userService = userService;
        this.auditoriumService = auditorium;
        this.eventService=eventService;

    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        //
        User user = new User();
        user.setEmail("Email1");
        LocalDate localDate = LocalDate.of(1992,01,29);
        user.setDateofBirth(localDate);
        User user1 = new User();
        user1.setEmail("Email12");
        //
        app.userService.save(user);
        app.userService.save(user1);
        app.userService.remove(user);
        DataStorage.getAuditoriumDatabase().entrySet().forEach(e->e.toString());

               //
        app.userService.getAll().forEach(user2 -> System.out.println(user2.toString()));
        app.auditoriumService.getAll().forEach(auditorium -> System.out.println(auditorium.toString()));
        app.eventService.getAll().forEach(event -> System.out.println(event.toString()));
        System.out.println(app.discountManager.selectDiscount(user,100l));
        System.out.println(app.discountManager.avaliableTicketInPromotion(user,100l));

    }
}
