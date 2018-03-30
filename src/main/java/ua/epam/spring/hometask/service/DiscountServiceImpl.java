package ua.epam.spring.hometask.service;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.discountStrategy.DiscountManager;

public class DiscountServiceImpl implements DiscountService {

    private DiscountManager discountManager;


    public DiscountServiceImpl(
        DiscountManager discountManager) {
        this.discountManager = discountManager;
    }

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event,
        @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        return discountManager.selectDiscount(user,numberOfTickets);
    }
}
