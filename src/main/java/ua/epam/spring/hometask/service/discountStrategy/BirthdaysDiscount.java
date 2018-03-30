package ua.epam.spring.hometask.service.discountStrategy;

import java.time.LocalDate;
import javax.annotation.Nullable;
import ua.epam.spring.hometask.domain.User;

public class BirthdaysDiscount implements DiscountStrategy {

    private long discountTicket;

    @Override
    public boolean isDiscountAvaliable(@Nullable User user, long numberOfTickets) {
        int periodOfDiscount = 5;
        int dayOfYearofBirth = user.getDateofBirth().getDayOfYear();
        int barginFromDate= LocalDate.now().getDayOfYear()-periodOfDiscount;
        int barginToDate= LocalDate.now().getDayOfYear()+periodOfDiscount;

        if (dayOfYearofBirth >= barginFromDate && dayOfYearofBirth <= barginToDate) {
            discountTicket=numberOfTickets;
            return true;
        }
        return false;
    }

    @Override
    public byte getDiscount() {
        return 5;
    }

    @Override
    public long getNumberofDiscount() {
        return discountTicket;
    }
}
