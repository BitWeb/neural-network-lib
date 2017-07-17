package ee.bitweb.neuralnetwork.architecture.learning.stop;

import ee.bitweb.neuralnetwork.architecture.learning.LearningRule;

/**
 * Created by tobre on 17/07/2017.
 */
public class MaxErrorStop implements StopCondition {

    private LearningRule learningRule;

    public MaxErrorStop(LearningRule learningRule) {
        this.learningRule = learningRule;
    }

    @Override
    public Boolean isReached() {
        Double totalNetworkError = learningRule.getTotalNetworkError();
        return totalNetworkError < learningRule.getMaxError();
    }
}
