package movie.policy;

import movie.Money;
import movie.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    //할인조건을 만족한 경우 일정한 금액 반환
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
