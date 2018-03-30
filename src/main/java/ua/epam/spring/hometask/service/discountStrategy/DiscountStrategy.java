package ua.epam.spring.hometask.service.discountStrategy;

import java.time.LocalDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

public interface DiscountStrategy {

    public boolean isDiscountAvaliable(@Nullable User user, long numberOfTickets);

    public byte getDiscount();

    public long getNumberofDiscount();

}
