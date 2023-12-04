package movie.policy;

import movie.Money;
import movie.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Template Method Pattern
public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                // 실제로 요금을 계산하는 부분 위임
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
