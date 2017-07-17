package ee.bitweb.neuralnetwork.architecture.learning;

import ee.bitweb.neuralnetwork.architecture.NeuralNetwork;
import ee.bitweb.neuralnetwork.architecture.data.DataSet;
import ee.bitweb.neuralnetwork.architecture.learning.error.ErrorFunction;
import ee.bitweb.neuralnetwork.architecture.learning.stop.StopCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public abstract class LearningRule {

    protected NeuralNetwork neuralNetwork;
    protected Boolean isLearningStopped;
    private List<StopCondition> stopConditions = new ArrayList<>();
    protected ErrorFunction errorFunction;
    protected Double learningRate = 0.1d;
    protected Double maxError = 0.01d;

    public void setNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    protected void onStart() {
        isLearningStopped = false;
    }

    protected Boolean isStopped() {
        return isLearningStopped;
    }

    protected void stopLearning() {
        isLearningStopped = true;
    }

    protected Boolean hasReachedStopCondition() {
        for (StopCondition stopCondition : stopConditions) {
            if (stopCondition.isReached()) {
                return true;
            }
        }

        return false;
    }

    public void setErrorFunction(ErrorFunction errorFunction) {
        this.errorFunction = errorFunction;
    }

    public void addStopCondition(StopCondition stopCondition) {
        this.stopConditions.add(stopCondition);
    }

    public Double getTotalNetworkError() {
        return errorFunction.getTotalError();
    }

    public Double getMaxError() {
        return maxError;
    }

    public void setMaxError(Double maxError) {
        this.maxError = maxError;
    }

    public abstract void learn(DataSet trainingSet);
}
