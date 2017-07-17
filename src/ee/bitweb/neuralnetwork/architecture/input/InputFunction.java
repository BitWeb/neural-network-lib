package ee.bitweb.neuralnetwork.architecture.input;

import ee.bitweb.neuralnetwork.architecture.Synapse;

import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public interface InputFunction {

    Double getOutput(List<Synapse> synapses);
}
