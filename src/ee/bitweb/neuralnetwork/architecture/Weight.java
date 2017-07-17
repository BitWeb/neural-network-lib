package ee.bitweb.neuralnetwork.architecture;

/**
 * Created by tobre on 17/07/2017.
 */
public class Weight {

    protected Double value;
    protected Double weightChange = 0d;

    public Weight() {
        this.value = Math.random();
    }

    public Weight(Double value) {
        this.value = value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public Double getWeightChange() {
        return weightChange;
    }

    public void setWeightChange(Double weightChange) {
        this.weightChange = weightChange;
    }

    public void resetWeightChange() {
        weightChange = 0d;
    }
}
