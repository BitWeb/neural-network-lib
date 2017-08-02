package ee.bitweb.neuralnetwork.architecture;

import ee.bitweb.neuralnetwork.architecture.input.InputFunction;
import ee.bitweb.neuralnetwork.architecture.input.WeightedSum;
import ee.bitweb.neuralnetwork.architecture.transfer.Sigmoid;
import ee.bitweb.neuralnetwork.architecture.transfer.TransferFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class Neuron {

    protected Double totalInput = 0d;
    protected Double output = 0d;
    protected Layer parentLayer;
    protected List<Synapse> inputSynapses;
    protected List<Synapse> outputSynapses;
    protected InputFunction inputFunction;
    protected TransferFunction transferFunction;
    protected Double error;

    public Neuron() {
        this.inputSynapses = new ArrayList<>();
        this.outputSynapses = new ArrayList<>();
        this.inputFunction = new WeightedSum();
        this.transferFunction = new Sigmoid();
    }

    void setParentLayer(Layer parentLayer) {
        this.parentLayer = parentLayer;
    }

    public void setOutput(Double output) {
        this.output = output;
    }

    public Double getOutput() {
        return output;
    }

    public void addInputSynapse(Neuron fromNeuron) {
        Synapse synapse = new Synapse(fromNeuron, this);
        addInputSynapse(synapse);
    }

    protected void addInputSynapse(Synapse synapse) {
        inputSynapses.add(synapse);
        synapse.getFromNeuron().addOutputSynapse(synapse);
    }

    public List<Synapse> getInputSynapses() {
        return inputSynapses;
    }

    protected void addOutputSynapse(Synapse synapse) {
        this.outputSynapses.add(synapse);
    }

    public List<Synapse> getOutputSynapses() {
        return outputSynapses;
    }

    void calculate() {
        totalInput = inputFunction.getOutput(inputSynapses);
        output = transferFunction.getOutput(totalInput);
    }

    public void setInput(double input) {
        this.totalInput = input;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public TransferFunction getTransferFunction() {
        return transferFunction;
    }

    public void setError(Double error) {
        this.error = error;
    }

    public Double getError() {
        return error;
    }

    public String toString() {
        return "Neuron totalInput=" + totalInput + " output=" + getOutput();
    }
}
