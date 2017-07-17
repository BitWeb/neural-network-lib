import ee.bitweb.neuralnetwork.architecture.NeuralNetwork;
import ee.bitweb.neuralnetwork.architecture.Neuron;
import ee.bitweb.neuralnetwork.architecture.data.DataRow;
import ee.bitweb.neuralnetwork.architecture.data.DataSet;
import ee.bitweb.neuralnetwork.neuralnetwork.Perceptron;

import java.util.Arrays;

/**
 * Created by tobre on 17/07/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        NeuralNetwork nn = new Perceptron(4, 4);

        DataSet dataSet = new DataSet();
        dataSet.addRow(new DataRow(Arrays.asList(0d, 0d, 0d, 0d), Arrays.asList(0d, 0d, 0d, 1d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 0d, 0d, 1d), Arrays.asList(0d, 0d, 1d, 0d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 0d, 1d, 0d), Arrays.asList(0d, 0d, 1d, 1d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 0d, 1d, 1d), Arrays.asList(0d, 1d, 0d, 0d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 1d, 0d, 0d), Arrays.asList(0d, 1d, 0d, 1d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 1d, 0d, 1d), Arrays.asList(0d, 1d, 1d, 0d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 1d, 1d, 0d), Arrays.asList(0d, 1d, 1d, 1d)));
        dataSet.addRow(new DataRow(Arrays.asList(0d, 1d, 1d, 1d), Arrays.asList(1d, 0d, 0d, 0d)));
        dataSet.addRow(new DataRow(Arrays.asList(1d, 0d, 0d, 0d), Arrays.asList(1d, 0d, 0d, 1d)));
        dataSet.addRow(new DataRow(Arrays.asList(1d, 0d, 0d, 1d), Arrays.asList(1d, 0d, 1d, 0d)));
        dataSet.addRow(new DataRow(Arrays.asList(1d, 0d, 1d, 0d), Arrays.asList(0d, 0d, 0d, 0d)));


        nn.learn(dataSet);

        double a = 0d;
        double b = 0d;
        double c = 0d;
        double d = 0d;

        do {
            nn.setInput(Arrays.asList(a, b, c, d));
            nn.calculate();

            a = nn.getOutputNeurons().get(0).getOutput();
            b = nn.getOutputNeurons().get(1).getOutput();
            c = nn.getOutputNeurons().get(2).getOutput();
            d = nn.getOutputNeurons().get(3).getOutput();

            String string = String.valueOf(Math.round(a)) + String.valueOf(Math.round(b) + String.valueOf(Math.round(c))+ String.valueOf(Math.round(d)));
            System.out.println(Integer.parseInt(string, 2));

            Thread.sleep(1 * 100);

        } while (true);

        /*for (Neuron neuron : nn.getOutputNeurons()) {
            System.out.print((Math.round(neuron.getOutput())));
            System.out.print(" ");
        }
        System.out.println();*/
    }
}
