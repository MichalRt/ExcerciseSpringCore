package ua.epam.spring.hometask.service.discountStrategy;

import java.time.LocalDate;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.User;

public class EveryTenTicketDiscount implements DiscountStrategy {

    private long discountTicket;

    @Override
    public boolean isDiscountAvaliable(@Nullable User user, long numberOfTickets) {
        long amountDiscount = (long) Math.floor(user.getTickets().size() / 10);
        long secondDiscount = (long) Math.floor((user.getTickets().size() + numberOfTickets) /10);

        if ((secondDiscount-amountDiscount)>0){
            discountTicket=secondDiscount-amountDiscount;
            return true;
        }
        else
            return false;
    }

    @Override
    public byte getDiscount() {
        return 50;
    }

    @Override
    public long getNumberofDiscount() {
        return discountTicket;
    }
}
