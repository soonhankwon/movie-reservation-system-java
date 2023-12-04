package movie;

public class Reservation {

    //고객
    private Customer customer;
    //상영정보
    private Screening screening;
    //예매 요금
    private Money fee;
    //인원 수
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
