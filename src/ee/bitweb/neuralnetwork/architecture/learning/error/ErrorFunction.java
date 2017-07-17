package ee.bitweb.neuralnetwork.architecture.learning.error;

import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public interface ErrorFunction {

    public List<Double> addPatternError(List<Double> predictedOutput, List<Double> targetOutput);

    public Double getTotalError();

    public void reset();
}
