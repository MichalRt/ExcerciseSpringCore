package ua.epam.spring.hometask.repository;

import java.util.HashMap;
import java.util.Map;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

public class DataStorage {

    public static Integer idUserCounter =1;
    public static Integer idAuditoriumCounter =1;
    public static Integer idEventCounter =1;

    private static Map<Integer,User> userDatabase = new HashMap<>();
    private static Map<Integer,Auditorium> auditoriumDatabase = new HashMap<>();
    private static Map<Integer,Event> eventDatabase = new HashMap<>();

    public static Map<Integer, User> getUserDatabase() {
        return userDatabase;
    }

    public static void setUserDatabase(
        Map<Integer, User> userDatabase) {
        DataStorage.userDatabase = userDatabase;
        idUserCounter = DataStorage.userDatabase.size()+1;
    }

    public static Integer getIdUserCounter() {
        return idUserCounter;
    }

    public static void setIdUserCounter(Integer idUserCounter) {
        DataStorage.idUserCounter = idUserCounter;
    }

    public static Integer getIdAuditoriumCounter() {
        return idAuditoriumCounter;
    }

    public static void setIdAuditoriumCounter(Integer idAuditoriumCounter) {
        DataStorage.idAuditoriumCounter = idAuditoriumCounter;
    }

    public static Map<Integer, Auditorium> getAuditoriumDatabase() {
        return auditoriumDatabase;
    }

    public static Integer getIdEventCounter() {
        return idEventCounter;
    }

    public static void setIdEventCounter(Integer idEventCounter) {
        DataStorage.idEventCounter = idEventCounter;
    }

    public static void setAuditoriumDatabase(
        Map<Integer, Auditorium> auditoriumDatabase) {
        DataStorage.auditoriumDatabase = auditoriumDatabase;
    }

    public static Map<Integer, Event> getEventDatabase() {
        return eventDatabase;
    }

    public static void setEventDatabase(
        Map<Integer, Event> eventDatabase) {
        DataStorage.eventDatabase = eventDatabase;
    }

}
