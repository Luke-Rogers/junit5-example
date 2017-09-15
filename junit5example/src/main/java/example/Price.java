package example;

public class Price {
    final double net;
    final double gross;

    public Price (double net, double gross) {
        this.net = net;
        this.gross = gross;
    }

    public double getNet() {
        return net;
    }

    public double getGross() {
        return gross;
    }
}