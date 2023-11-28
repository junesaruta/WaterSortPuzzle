import java.util.List;
    public class main{
        public static void main(String[] args) {
            String[] bottles = {"red", "blue", "green", "blue", "red"};
            List<String> steps = WaterSortPuzzle.waterSortPuzzle(bottles);

            for (String step : steps) {
                System.out.println(step);
            }
        }
    }
