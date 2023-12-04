package movie.policy;

import movie.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
