import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TaskResource {
     List<Long> numbersToCheck = new ArrayList<>();

    public synchronized Long take() throws  InterruptedException {
        while (numbersToCheck.isEmpty()){
            wait();
        }
        return numbersToCheck.remove(0);
    }

    public synchronized void put(Long value) {
        this.numbersToCheck.add(value);
        notifyAll();
    }

    public synchronized boolean isEmpty() {
        return this.numbersToCheck.isEmpty();
    }
}
