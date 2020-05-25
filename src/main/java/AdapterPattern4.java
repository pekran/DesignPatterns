import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterPattern4 {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4};
        System.out.println(ArrayUtils.countEven(numbers1));
        System.out.println(ArrayUtils.countOdd(numbers1));
        System.out.println(Arrays.toString(ArrayUtils.powOf2(numbers1)));

        System.out.println("---------------------------");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
//        ArrayUtils.countEven(numbers2); cannot use :(
        System.out.println(ListIntegerToArrayIntAdapter.countEven(numbers2));
        System.out.println(ListIntegerToArrayIntAdapter.countOdd(numbers2));
        System.out.println(ListIntegerToArrayIntAdapter.powOf2(numbers2));
    }
}

class ArrayUtils {
    public static long countEven(int[] array) {
        long counter = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static long countOdd(int[] array) {
        long counter = 0;
        for (int value : array) {
            if (value % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] powOf2(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] * array[i];
        }
        return result;
    }

}

class ListIntegerToArrayIntAdapter {
    public static long countEven(List<Integer> integerList) {

        return ArrayUtils.countEven(adapter(integerList));
    }

    public static long countOdd(List<Integer> integerList){
        return ArrayUtils.countOdd(adapter(integerList));
    }

    public static List<Integer> powOf2(List<Integer> integerList){
        int[] ints = ArrayUtils.powOf2(adapter(integerList));
        return adapter2(ints);
    }

    public static List<Integer> adapter2(int[] array){
        return  Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public static int [] adapter(List<Integer> integerList){
        return integerList.stream().mapToInt(i->i).toArray();
    }
}

