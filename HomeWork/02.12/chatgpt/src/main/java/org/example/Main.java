package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* 1. Уровень: Начальный

        Задание:
        Создайте программу, которая принимает на вход строку текста от пользователя и возвращает ее, но каждое слово в строке должно начинаться с заглавной буквы.

                Условия:

        Программа должна игнорировать любые лишние пробелы в начале, конце и между словами.
                Обработка должна быть нечувствительной к регистру.
                Цель:
        Закрепить основы работы со строками, методами их обработки и пользовательским вводом. */

        String input= "lorem denim";
        String output = "";

        String[] words = input.split(" ");

       for(int i =0; i < words.length; i++){
           words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
       }
       for(int i=0; i < words.length; i++){
           output+=words[i];
           output+=" ";
       }

        System.out.println(output);

        /*2. Уровень: Средний

        Задание:
        Реализуйте программу для подсчета количества уникальных чисел в массиве.

                Условия:

        На вход подается строка с числами, разделенными пробелами.
                Программа должна возвращать количество уникальных чисел и список этих чисел.
                Результаты должны быть выведены в порядке возрастания.
        Цель:
        Понимание работы со структурами данных (списками, множества) и сортировкой.*/

        int[] numbers = {1,2,3,4,5,1,2,6,8,1,4,2,4,5,6};
        Map<Integer, Integer> numbersCount = new HashMap<>();
        List<Integer> uniqueNumbers = new ArrayList<>();

        for(int i =0; i<numbers.length; i++){
            if(numbersCount.get(numbers[i]) == null){
                numbersCount.put(numbers[i], 1);
            } else{
                numbersCount.put(numbers[i], numbersCount.get(numbers[i])+1);
            }
        }
        System.out.println(numbersCount);

        for(Map.Entry<Integer, Integer> keys: numbersCount.entrySet()){
            if(keys.getValue() == 1){
                uniqueNumbers.add(keys.getKey());
            }
        }


        System.out.println( uniqueNumbers.stream().sorted().toList());

        /*3. Уровень: Средний

        Задание:
        Напишите программу, которая симулирует работу банкомата.

                Условия:

        Банкомат имеет ограниченный набор купюр: 100, 500, 1000 рублей.
                Пользователь вводит сумму, которую хочет снять.
        Программа должна выдать количество купюр каждого номинала, которое нужно для выдачи суммы.
        Если сумму нельзя выдать, программа должна сообщить об этом.
        Цель:
        Закрепить умение разрабатывать алгоритмы, работать с циклами и условиями.*/

        int sum=2675;
        Map<Banknote, Integer> banknotes= new HashMap<Banknote, Integer>();


        banknotes.put(Banknote.MAX, (int)(sum/Banknote.MAX.getValue()));
        sum = sum - Banknote.MAX.getValue() * (int)(sum/Banknote.MAX.getValue());

        banknotes.put(Banknote.MEAN, (int)(sum/Banknote.MEAN.getValue()));
        sum = sum - Banknote.MEAN.getValue() * (int)(sum/Banknote.MEAN.getValue());

        banknotes.put(Banknote.MIN, (int)(sum/Banknote.MIN.getValue()));
        sum = sum - Banknote.MIN.getValue() * (int)(sum/Banknote.MIN.getValue());


        System.out.println(sum);
        System.out.println(banknotes);

        /*4. Уровень: Продвинутый

        Задание:
        Реализуйте программу для поиска кратчайшего пути в графе.

        Условия:

        На вход подается описание графа в виде списка вершин и связей между ними с весами.
                Пользователь вводит начальную и конечную вершину.
                Программа должна вернуть длину кратчайшего пути и сам путь.
        Использовать алгоритм Дейкстры или аналогичный.
                Цель:
        Закрепить работу с графами, структурами данных и алгоритмами поиска.*/

        Integer[][] f = {{0,1,0,0,0,0}, {1,0,1,1,0,0}, {0,1,0,0,0,1}, {0,0,0,1,0,1}, {0,0,1,1,1,0}};

        Graph g = new Graph(f);

        System.out.println(g.fastestRoute(0,5));

        /*5. Уровень: Эксперт

        Задание:
        Реализуйте программу для определения регулярности расписания.

        Условия:

        На вход подается список временных меток (в формате "ЧЧ:ММ"), представляющих расписание прибытия автобусов.
        Программа должна определить, являются ли интервалы между всеми соседними временными метками одинаковыми.
        Если расписание регулярное, программа должна вывести интервал; если нет — сообщить об этом.
                Цель:
        Работа с форматами времени, математическими вычислениями и проверками.*/

        /*6. Уровень: Эксперт

        Задание:
        Разработайте программу для генерации и проверки простых чисел.

        Условия:

        На вход подается диапазон чисел (например, от 1 до 10 000).
                Программа должна:
        Найти все простые числа в заданном диапазоне.
                Проверить, является ли заданное число простым, используя алгоритм типа теста Ферма.
        Цель:
        Изучение алгоритмов поиска простых чисел и работы с числами больших порядков.*/
    }
}