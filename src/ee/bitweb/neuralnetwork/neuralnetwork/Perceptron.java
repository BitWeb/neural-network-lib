package ee.bitweb.neuralnetwork.neuralnetwork;

import ee.bitweb.neuralnetwork.architecture.InputNeuron;
import ee.bitweb.neuralnetwork.architecture.Layer;
import ee.bitweb.neuralnetwork.architecture.NeuralNetwork;
import ee.bitweb.neuralnetwork.architecture.Neuron;
import ee.bitweb.neuralnetwork.architecture.learning.LearningRule;
import ee.bitweb.neuralnetwork.architecture.learning.error.MeanSquaredError;
import ee.bitweb.neuralnetwork.architecture.learning.stop.MaxErrorStop;
import ee.bitweb.neuralnetwork.neuralnetwork.learning.BackPropagation;

import java.util.Arrays;

/**
 * Created by tobre on 17/07/2017.
 */
public class Perceptron extends NeuralNetwork {

    public Perceptron(Integer inputNeuronsCount, Integer outputNeuronsCount) {
        createNetwork(inputNeuronsCount, outputNeuronsCount);
    }

    private void createNetwork(Integer inputNeuronsCount, Integer outputNeuronsCount) {
        Layer inputLayer = new Layer();
        for (int i = 0; i < inputNeuronsCount; i++) {
            Neuron n = new InputNeuron();
            inputLayer.addNeuron(n);
            addInputNeuron(n);
        }
        addLayer(inputLayer);

        Layer hiddenLayer = new Layer();
        for (int i = 0; i < Math.ceil((inputNeuronsCount + outputNeuronsCount) * 2 / 3) + 1; i++) {
            Neuron n = new Neuron();
            for (Neuron in : inputLayer.getNeurons()) {
                n.addInputSynapse(in);
            }
            hiddenLayer.addNeuron(n);
        }
        addLayer(hiddenLayer);

        Layer outputLayer = new Layer();
        for (int i = 0; i < outputNeuronsCount; i++) {
            Neuron n = new Neuron();
            outputLayer.addNeuron(n);
            addOutputNeuron(n);
            for (Neuron in : hiddenLayer.getNeurons()) {
                n.addInputSynapse(in);
            }
        }
        addLayer(outputLayer);


        LearningRule learningRule = new BackPropagation();
        learningRule.setNeuralNetwork(this);
        learningRule.setErrorFunction(new MeanSquaredError());
        learningRule.addStopCondition(new MaxErrorStop(learningRule));
        learningRule.setMaxError(0.01);
        setLearningRule(learningRule);
    }
}
