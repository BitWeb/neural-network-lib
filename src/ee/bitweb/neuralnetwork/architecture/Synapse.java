package ee.bitweb.neuralnetwork.architecture;

/**
 * Created by tobre on 17/07/2017.
 */
public class Synapse {

    private Neuron fromNeuron;
    private Neuron toNeuron;
    private Weight weight;

    public Synapse(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;

        this.weight = new Weight();
    }

    public Synapse(Neuron fromNeuron, Neuron toNeuron, Double weightValue) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;

        this.weight = new Weight(weightValue);
    }

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    public Neuron getToNeuron() {
        return toNeuron;
    }

    public Double getWeightedInput() {
        return getInput() * weight.value;
    }

    public Weight getWeight() {
        return weight;
    }

    public double getInput() {
        return fromNeuron.getOutput();
    }
}
