package ee.bitweb.neuralnetwork.architecture;

/**
 * Created by tobre on 17/07/2017.
 */
public class InputNeuron extends Neuron {

    @Override
    public Double getOutput() {
        return super.totalInput;
    }

    @Override
    void calculate() {
    }
}
