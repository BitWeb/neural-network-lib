package ee.bitweb.neuralnetwork.architecture.data;

import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class DataRow {

    private List<Double> input;
    private List<Double> desiredOutput;

    public DataRow(List<Double> input, List<Double> desiredOutput) {
        this.input = input;
        this.desiredOutput = desiredOutput;
    }

    public List<Double> getInput() {
        return input;
    }

    public List<Double> getDesiredOutput() {
        return desiredOutput;
    }
}
