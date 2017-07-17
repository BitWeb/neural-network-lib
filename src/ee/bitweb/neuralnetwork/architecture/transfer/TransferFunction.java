package ee.bitweb.neuralnetwork.architecture.transfer;

/**
 * Created by tobre on 17/07/2017.
 */
public interface TransferFunction {

    public Double getOutput(Double input);

    public Double getDerivative(Double output);
}
