package ee.bitweb.neuralnetwork.architecture.learning.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class MeanSquaredError implements ErrorFunction {

    private Double totalError = 0d;
    private Integer patternCount = 0;

    public MeanSquaredError() {
        reset();
    }

    @Override
    public List<Double> addPatternError(List<Double> predictedOutput, List<Double> targetOutput) {
        List<Double> patternError = new ArrayList<>();

        for (int i = 0; i < predictedOutput.size(); i++) {
            patternError.add(predictedOutput.get(i) - targetOutput.get(i));
            //patternError.add(targetOutput.get(i) - predictedOutput.get(i));
            totalError += Math.pow(patternError.get(i), 2);
        }

        patternCount++;
        return patternError;
    }

    @Override
    public Double getTotalError() {
        return totalError / (2 * patternCount );
    }

    public void reset() {
        patternCount = 0;
        totalError = 0d;
    }
}
