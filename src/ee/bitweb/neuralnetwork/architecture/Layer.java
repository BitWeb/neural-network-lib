package ee.bitweb.neuralnetwork.architecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class Layer {

    protected List<Neuron> neurons;

    public Layer() {
        neurons = new ArrayList<>();
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
        neuron.setParentLayer(this);
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    void calculate() {
        for (Neuron neuron : neurons) {
            neuron.calculate();
        }
    }
}
