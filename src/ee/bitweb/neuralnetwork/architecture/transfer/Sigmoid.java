package ee.bitweb.neuralnetwork.architecture.transfer;

/**
 * Created by tobre on 17/07/2017.
 */
public class Sigmoid implements TransferFunction {

    private Double slope = 1d;

    @Override
    public Double getOutput(Double input) {
        if (input > 100) {
            return 1.0;
        } else if (input < -100) {
            return 0.0;
        }
        double den = 1 + Math.exp(-this.slope * input);

        return (1d / den);
    }

    @Override
    public Double getDerivative(Double output) {
        return this.slope * output * (1d - output);
    }
}
