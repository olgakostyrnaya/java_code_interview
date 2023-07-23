import java.util.ArrayList;
import java.util.List;

//{0,2,3,4,5,7,9}
//{“0”, “2->5”, “7”, “9”}

//{-9, -8, -7, -5, -4, 0, 1, 2, 4, 5
// {“-9->-7”, “-5->-4”, “0”, “1->2”, “4->5”}

//{2,3}
//{“2->3”}

//{-2,3}
//{“-2”,”3”}

//Complexity:
//Time: O(N) - массив отсортирован, но прийтись нужно по каждому элементу минимум 1 раз
//Memory: O(N) - вернуть надо новый массив другого типа поэтому также зависим от количества элементов

//Размышления:
//Мы знаем, что последовательность отсортирована, разбивать ее на интервалы нужно, если числовой ряд прерывается
//Что будем делать:
//создаем 3 индекса - левого элемента интервала и правого элемента интервала и текущий
//индекс левого элемента это индекс чтения по последовательности
//идем циклом while пока модуль разницы = 1 между текущим элементом и правым
//когда вышли из цикла проверяем что левый индекс больше правого. Если нет - значит диапазон из одного элемента, если да - нужно взять элемент из последовательности по левому индексу и склеить со знаком «->» и элементом правого индекса

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length < 1) {
            return new ArrayList<String>();
        }

        if (nums.length == 1) {
            List<String> result = new ArrayList<String>();
            result.add(String.valueOf(nums[0]));

            return result;
        }

        List<String> result = new ArrayList<String>();
        int leftIndex = 0;
        int rightIndex = 0;
        int cur = 0;

        while (++rightIndex < nums.length && cur < nums.length) {

            leftIndex = cur;
            while (Math.abs(nums[cur] - nums[rightIndex]) == 1) {
                cur++;
                rightIndex++;
            }

            if (rightIndex - leftIndex == 1) {
                result.add(String.valueOf(nums[leftIndex]));
            } else {
                result.add(nums[leftIndex] + "->" + nums[rightIndex]);
            }
            cur++;
        }
        //System.out.println(result);
        return result;

    }
}