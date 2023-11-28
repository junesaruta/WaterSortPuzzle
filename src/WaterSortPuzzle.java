import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class WaterSortPuzzle {
    public static List<String> waterSortPuzzle(String[] bottles) {
        List<String> steps = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int numBottles = bottles.length;

        while (true) {
            // ตรวจสอบว่าทุกขวดถูกจัดเรียงแล้วหรือไม่
            int sortedCount = 0;
            for (String bottle : bottles) {
                if (bottle == null) {
                    sortedCount++;
                }
            }
            if (sortedCount == numBottles) {
                break;
            }

            // หาขวดที่มีน้ำอยู่
            for (int i = 0; i < numBottles; i++) {
                if (bottles[i] != null) {
                    // หาขวดที่มีน้ำอยู่และไม่ใช่ขวดล่าสุดในสแต็ก
                    if (stack.isEmpty() || !stack.peek().equals(bottles[i])) {
                        stack.push(bottles[i]);
                        bottles[i] = null;
                        steps.add("Move bottle " + stack.peek() + " to stack");
                    }
                }
            }

            // หาขวดที่จะเทียบน้ำ
            for (int i = 0; i < numBottles; i++) {
                if (bottles[i] != null) {
                    // หาขวดที่มีน้ำและไม่ใช่ขวดล่าสุดในสแต็ก
                    if (stack.isEmpty() || !stack.peek().equals(bottles[i])) {
                        // หาขวดที่มีน้ำเหมือนกับขวดบนสุดของสแต็ก
                        for (int j = i + 1; j < numBottles; j++) {
                            if (bottles[j] != null && bottles[j].equals(stack.peek())) {
                                stack.push(bottles[j]);
                                bottles[j] = null;
                                steps.add("Move bottle " + stack.peek() + " to stack");
                                break;
                            }
                        }
                    }
                }
            }

            // นำขวดออกจากสแต็กและใส่ให้ถูกสี
            if (!stack.isEmpty()) {
                String colorToFill = stack.pop();
                for (int i = 0; i < numBottles; i++) {
                    if (bottles[i] == null) {
                        bottles[i] = colorToFill;
                        steps.add("Pour " + colorToFill + " from stack to bottle " + i);
                        break;
                    }
                }
            }
        }
        return steps;
    }
}