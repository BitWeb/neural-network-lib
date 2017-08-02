package ee.bitweb.neuralnetwork.neuralnetwork.learning;

import ee.bitweb.neuralnetwork.architecture.Layer;
import ee.bitweb.neuralnetwork.architecture.Neuron;
import ee.bitweb.neuralnetwork.architecture.Synapse;
import ee.bitweb.neuralnetwork.architecture.Weight;
import ee.bitweb.neuralnetwork.architecture.data.DataRow;
import ee.bitweb.neuralnetwork.architecture.data.DataSet;
import ee.bitweb.neuralnetwork.architecture.learning.LearningRule;
import ee.bitweb.neuralnetwork.architecture.transfer.TransferFunction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class BackPropagation extends LearningRule {

    @Override
    public void learn(DataSet trainingSet) {
        onStart();
        while (!isStopped()) {
            doLearningEpoch(trainingSet);
            if (hasReachedStopCondition()) {
                stopLearning();
            }
        }
    }

    private void doLearningEpoch(DataSet trainingSet) {
        Iterator<DataRow> iterator = trainingSet.iterator();
        while (iterator.hasNext() && !isStopped()) {
            learnPattern(iterator.next());
        }
    }

    private void learnPattern(DataRow trainingElement) {
        neuralNetwork.setInput(trainingElement.getInput());
        neuralNetwork.calculate();

        List<Double> patternError = errorFunction.addPatternError(neuralNetwork.getOutput(), trainingElement.getDesiredOutput());
        calculateWeightChanges(patternError);
        applyWeightChanges();
    }

    protected void calculateWeightChanges(List<Double> patternError) {
        calculateErrorAndUpdateOutputNeurons(patternError);
        calculateErrorAndUpdateHiddenNeurons();
    }

    protected void calculateErrorAndUpdateOutputNeurons(List<Double> outputError) {
        int i = 0;
        for (Neuron neuron : neuralNetwork.getOutputNeurons()) {
            TransferFunction transferFunction = neuron.getTransferFunction();
            Double delta = outputError.get(i) * transferFunction.getDerivative(neuron.getOutput()); // delta = (y-d)*df(net)
            neuron.setError(delta);

            updateNeuronWeights(neuron);
            i++;
        }
    }

    protected void calculateErrorAndUpdateHiddenNeurons() {
        List<Layer> layers = neuralNetwork.getLayers();
        for (int i = layers.size() - 2; i > 0; i--) {
            for (Neuron neuron : layers.get(i).getNeurons()) {
                Double delta = calculateHiddenNeuronError(neuron);
                neuron.setError(delta);
                updateNeuronWeights(neuron);
            }
        }
    }

    protected void updateNeuronWeights(Neuron neuron) {
        Double delta = neuron.getError();

        for (Synapse synapse : neuron.getInputSynapses()) {
            Double weightChange = -learningRate * delta * synapse.getInput();

            Weight weight = synapse.getWeight();
            weight.setWeightChange(weightChange);
        }
    }

    protected double calculateHiddenNeuronError(Neuron neuron) {
        double deltaSum = 0d;
        for (Synapse synapse : neuron.getOutputSynapses()) {
            double delta = synapse.getToNeuron().getError() * synapse.getWeight().getValue();
            deltaSum += delta; // weighted delta sum from the next layer
        }

        TransferFunction transferFunction = neuron.getTransferFunction();
        double f1 = transferFunction.getDerivative(neuron.getOutput());

        return f1 * deltaSum;
    }

    private void applyWeightChanges() {
        List<Layer> layers = neuralNetwork.getLayers();
        for (int i = neuralNetwork.getLayers().size() - 1; i > 0; i--) {
            for (Neuron neuron : layers.get(i).getNeurons()) {
                for (Synapse synapse : neuron.getInputSynapses()) {
                    Weight weight = synapse.getWeight();
                    weight.setValue(weight.getValue() + weight.getWeightChange());
                    weight.resetWeightChange();
                }
            }
        }
    }
}
