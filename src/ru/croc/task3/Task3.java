package src.ru.croc.task3;

public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[args.length];

        for(int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }

        swapElements(nums);

        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * метод, который переставляет наименьшее значение массива в начало, а наибольшее - в конец
     * @param nums - массив целых чисел
     */
    private static void swapElements(int[] nums) {
        int indexMin = 0;
        int indexMax = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[indexMin] > nums[i]) {
                indexMin = i;
            }
            if(nums[indexMax] < nums[i]) {
                indexMax = i;
            }
        }

        if(indexMin == 0 && indexMax == nums.length - 1) { //элементы на своих местах - менять не нужно
            return;
        } else if(indexMin == 0) { //первый элемент на своем месте - достаточно поменять последний
            swap(nums, indexMax, nums.length - 1);
        } else if(indexMax == nums.length - 1) { //последний элемент на своем месте - достаточно поменять первый
            swap(nums, indexMin, 0);
        } else if(indexMin == nums.length - 1 && indexMax == 0) { // элементы на противоположных местах - поменять один раз
            swap(nums, indexMin, 0);
        } else { //элементы не на своих местах - поменять их дважды
            swap(nums, indexMin, 0);
            swap(nums, indexMax, nums.length - 1);
        }

    }

    /**
     * Метод, который менят местами 2 элемента в массиве
     * @param nums - массив целых чисел
     * @param index - индекс, откуда элемент массива нужно перенести
     * @param i - индекс, куда нужно положить элемент массива
     */
    private static void swap(int[] nums, int index, int i) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
