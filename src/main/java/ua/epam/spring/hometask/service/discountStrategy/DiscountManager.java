package ua.epam.spring.hometask.service.discountStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.User;

public class DiscountManager {

    public DiscountManager(
        List<DiscountStrategy> avaliableDiscount) {
        this.avaliableDiscount = avaliableDiscount;
    }

    List<DiscountStrategy> avaliableDiscount = new ArrayList<>();

    public byte selectDiscount(@Nullable User user, long numberOfTickets) {
        return avaliableDiscount.stream()

            .filter(o -> o.isDiscountAvaliable(user, numberOfTickets))
            .max(Comparator.comparing(DiscountStrategy::getDiscount))
            .map(DiscountStrategy::getDiscount).orElse((byte)0);
        }

    public long avaliableTicketInPromotion(@Nullable User user, long numberOfTickets) {
        return avaliableDiscount.stream()

            .filter(o -> o.isDiscountAvaliable(user, numberOfTickets))
            .max(Comparator.comparing(DiscountStrategy::getDiscount))
            .map(DiscountStrategy::getNumberofDiscount).orElse((long) 0);
    }
}
