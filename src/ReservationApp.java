import movie.Money;
import movie.Movie;
import movie.Screening;
import movie.condition.PeriodCondition;
import movie.condition.SequenceCondition;
import movie.policy.AmountDiscountPolicy;
import movie.policy.NoneDiscountPolicy;
import movie.policy.PercentDiscountPolicy;

import java.time.*;

public class ReservationApp {

    public static void main(String[] args) {
        Movie avartar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        Screening screening = new Screening(avartar, 11, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 59)));
        //expect to 10000
        System.out.println(avartar.calculateMovieFee(screening));

        Movie avartar2 = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new PercentDiscountPolicy(0.10,
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        Screening screening2 = new Screening(avartar2, 11, LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 1)));
        //expect to 9000.0
        System.out.println(avartar2.calculateMovieFee(screening2));

        Movie starwarz = new Movie("스타워즈",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new NoneDiscountPolicy()
        );

        Screening screening3 = new Screening(starwarz, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 1)));
        //expect to 10000
        System.out.println(starwarz.calculateMovieFee(screening3));

        starwarz.changeDiscountPolicy(new PercentDiscountPolicy(0.20,
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
        //expect to 8000
        System.out.println(starwarz.calculateMovieFee(screening3));
    }
}
