package ee.bitweb.neuralnetwork.architecture.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tobre on 17/07/2017.
 */
public class DataSet implements Iterable<DataRow> {

    private List<DataRow> rows = new ArrayList<>();

    public void addRow(DataRow row) {
        rows.add(row);
    }

    @Override
    public Iterator<DataRow> iterator() {
        return rows.iterator();
    }
}
