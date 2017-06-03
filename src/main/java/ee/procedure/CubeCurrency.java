package ee.procedure;

public class CubeCurrency {
    private float rate;
    private String currency;

    public CubeCurrency(String currency, float rate) {
       setCurrency(currency);
       setRate(rate);
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
