package ee.bitweb.neuralnetwork.architecture.input;

import ee.bitweb.neuralnetwork.architecture.Synapse;

import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class WeightedSum implements InputFunction {

    @Override
    public Double getOutput(List<Synapse> synapses) {
        Double output = 0d;
        for (Synapse synapse : synapses) {
            output += synapse.getWeightedInput();
        }

        return output;
    }
}
