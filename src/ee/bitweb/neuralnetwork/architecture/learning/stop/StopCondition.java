package ee.bitweb.neuralnetwork.architecture.learning.stop;

import ee.bitweb.neuralnetwork.architecture.learning.LearningRule;

/**
 * Created by tobre on 17/07/2017.
 */
public interface StopCondition {

    abstract Boolean isReached();
}
