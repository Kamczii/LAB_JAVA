public class CalculationThread implements Runnable{

    private TaskResource taskResource;
    private SavingResource savingResource;

    public CalculationThread(TaskResource taskResource, SavingResource savingResource) {
        this.taskResource = taskResource;
        this.savingResource = savingResource;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                long number = taskResource.take();
                StringBuilder builder = new StringBuilder(Thread.currentThread().getName());
                builder.append(" Liczba ");
                builder.append(number);
                builder.append(": ");
                Thread.sleep(1000);
                for (long i=1; i<number ;i++){
                    if(number % i==0) {
                        builder.append(i);
                        builder.append(", ");
                    }
                }

                builder.append("\n");
                savingResource.save(builder.toString());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
