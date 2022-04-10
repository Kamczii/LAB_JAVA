
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
//        ForkJoinPool pool = new ForkJoinPool(2);

        List<Path> files;

        try {
            Path source = Path.of("files");
            try (Stream<Path> stream = Files.list(source)) {
                files = stream.collect(Collectors.toList());
            }
        } catch (IOException e) {
            System.out.println("Problem I/O!");
            e.printStackTrace();
            return;
        }

        long time = System.currentTimeMillis();
        try {
            pool.submit(()->files.parallelStream()
                    .map(ImageProcessor::getPair)
                    .map(ImageProcessor::transofrm)
                    .forEach(ImageProcessor::save)).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - time);
    }


}
