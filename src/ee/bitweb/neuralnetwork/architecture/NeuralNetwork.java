package ee.bitweb.neuralnetwork.architecture;

import ee.bitweb.neuralnetwork.architecture.data.DataSet;
import ee.bitweb.neuralnetwork.architecture.learning.LearningRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class NeuralNetwork {

    private List<Layer> layers;
    private List<Neuron> inputNeurons;
    private List<Neuron> outputNeurons;
    private LearningRule learningRule;

    public NeuralNetwork() {
        this.layers = new ArrayList<>();
        this.inputNeurons = new ArrayList<>();
        this.outputNeurons = new ArrayList<>();
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setInputNeurons(List<Neuron> neurons) {
        inputNeurons = neurons;
    }

    public void addInputNeuron(Neuron neuron) {
        inputNeurons.add(neuron);
    }

    public List<Neuron> getInputNeurons() {
        return inputNeurons;
    }

    public void setOutputNeurons(List<Neuron> neurons) {
        outputNeurons = neurons;
    }

    public void addOutputNeuron(Neuron neuron) {
        outputNeurons.add(neuron);
    }

    public List<Neuron> getOutputNeurons() {
        return outputNeurons;
    }

    public void setLearningRule(LearningRule learningRule) {
        this.learningRule = learningRule;
        learningRule.setNeuralNetwork(this);
    }

    public LearningRule getLearningRule() {
        return learningRule;
    }

    public void learn(DataSet dataSet) {
        learningRule.learn(dataSet);
    }

    public void calculate() {
        for (Layer layer : layers) {
            layer.calculate();
        }
    }

    public List<Double> getOutput() {
        List<Double> output = new ArrayList<>();
        for (Neuron neuron : outputNeurons) {
            output.add(neuron.getOutput());
        }

        return output;
    }

    public void setInput(List<Double> inputs) {
        int i = 0;
        for (Neuron neuron : this.inputNeurons) {
            neuron.setInput(inputs.get(i));
            i++;
        }
    }
}
