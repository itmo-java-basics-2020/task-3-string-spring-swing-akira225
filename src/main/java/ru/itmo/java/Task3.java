package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {

        if (inputArray == null || inputArray.length < 1)
        {
            return new int[0];
        }
        else
        {
            int [] toReturn= new int[inputArray.length];
            for (int i=0; i < inputArray.length - 1; ++i)
            {
                toReturn[i+1] = inputArray[i];
            }
            toReturn[0]=inputArray[inputArray.length-1];
            return toReturn;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0)
            return 0;
        if(inputArray.length == 1)
            return inputArray[0];
        int min1 = Integer.MAX_VALUE, min2 = min1;
        int max1 = Integer.MIN_VALUE, max2 = max1;
        for(int i = 0; i < inputArray.length; ++i)
        {
            if(inputArray[i] > max1)
            {
                max2 = max1;
                max1 = inputArray[i];
            }
            else if(inputArray[i] > max2)
            {
                max2 = inputArray[i];
            }
            if(inputArray[i] < min1)
            {
                min2 = min1;
                min1 = inputArray[i];
            }
            else if(inputArray[i] < min2)
            {
                min2 = inputArray[i];
            }
        }
        return Math.max(min1*min2, max1*max2);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.length() < 1)
            return 0;
        else
        {
            int count = 0;
            for (int i = 0; i < input.length(); ++i)
            {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'b' ||
                        input.charAt(i) == 'A' || input.charAt(i) == 'B')
                {
                    count++;
                }
            }
            return 100*count/input.length();
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;
        else if(input.length() < 2)
            return true;
        else
        {
            int i = 0, j = input.length()-1;
            while (i < j)
            {
                if (input.charAt(i) != input.charAt(j))
                {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input)
    {
        if (input == null || input.length() < 1)
            return new String("");
        StringBuilder toReturn = new StringBuilder();
        int count = 1;
        char curChar = input.charAt(0);
        for(int i = 1; i < input.length(); ++i)
        {
            if(input.charAt(i) == curChar)
                count++;
            else
            {
                toReturn.append(curChar);
                toReturn.append(count);
                count = 1;
                curChar = input.charAt(i);
            }
        }
        toReturn.append(curChar);
        toReturn.append(count);
        return toReturn.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || one.length() == 0 || two == null || two.length() == 0 || one.length() != two.length())
            return false;
        int[] count = new int[65536]; // 2^16
        for(int i = 0; i < one.length(); ++i)
        {
            count[one.charAt(i)]++;
            count[two.charAt(i)]--;
        }
        for(int i = 0; i < 65536; ++i)
        {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() < 1)
            return false;
        boolean[] contains = new boolean[65536];
        for(int i = 0; i < s.length(); ++i)
        {
            if (!contains[s.charAt(i)])
                contains[s.charAt(i)] = true;
            else
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length < 1 || (m.length != m[0].length))
        {
            return new int[0][0];
        }
        int [][] toReturn = new int[m.length][m.length];
        for(int i = 0; i < m.length; ++i)
        {
            for (int j = 0; j < m.length; ++j)
            {
                toReturn[i][j] = m[j][i];
            }
        }

        return toReturn;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null || inputStrings.length == 0)
            return new String("");
        if(separator == null)
            separator = ' ';

        StringBuilder toReturn = new StringBuilder();
        toReturn.append(inputStrings[0]);

        for(int i = 1; i < inputStrings.length; ++i)
        {
            toReturn.append(separator);
            toReturn.append(inputStrings[i]);
        }
        return toReturn.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;
        int count = 0;
        for(int i = 0; i < inputStrings.length; ++i)
        {
            if (inputStrings[i].startsWith(prefix))
                count++;
        }
        return count;
    }
}
