package collection;

import ru.job4j.tracker.StubOutput;

import java.util.*;

public class Tasks {

    public static class IteratorForList {
        public static void main(String[] args) {
            List<String> list = List.of("one", "two", "three", "four", "five");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println("Next element has - " + true + ", this element is " + iterator.next());
            }
            System.out.println("Next element has - " + false);
        }
    }

    public static class ListIteratorUsage {
        public static void main(String[] args) {
            List<String> list = new ArrayList<>(List.of("one", "two", "three"));
            ListIterator<String> iterator = list.listIterator();
            System.out.println("Start iterate...");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println("Change direction iterate...");
            while (iterator.hasPrevious()) {
                System.out.println(iterator.previous());
            }
            System.out.println("Finish iterate...");
        }
    }

    public static class CreatorNewList {
        public static void main(String[] args) {
            System.out.println("Создаем список с пустым конструктором.");
            List<String> first = new ArrayList<>(3);
            System.out.println("Добавляем 3 элемента в список.");
            first.add("first");
            first.add("second");
            first.add("third");
            System.out.println("Создаем список - в конструктор передаем коллекцию.");
            List<String> second = new ArrayList<>(first);
            System.out.print("Выводим все элементы в списке.");
            for (String el : second) {
                System.out.println(el);
            }
        }
    }

    public static class ArProgression {
        public static int checkData(List<Integer> data) {
            int sum = 0;
            if (data.size() > 2) {
                for (int i = 0; i < data.size(); i++) {
                    if (i > 0 && i < data.size() - 1) {
                        double halfSum = (double) (data.get(i - 1) + data.get(i + 1)) / 2;
                        if (halfSum != data.get(i)) {
                            sum = 0;
                            break;
                        }
                    }
                    sum += data.get(i);
                }
            }
            return sum;
        }
    }

    public static class GeomProgression {
        public static int generateAndSum(int first, int denominator, int count) {
            List<Integer> geomSeq = new ArrayList<>(count);
            int sum = 0;
            int next = first;
            for (int i = 0; i < count; i++) {
                geomSeq.add(next);
                sum += next;
                next *= denominator;
            }
            return sum;
        }

        public static void main(String[] args) {
            System.out.println(generateAndSum(1,-1,10));
        }
    }

    public static class Alphabet {
        public static String reformat(String s) {
            List<String> list = new ArrayList<>(s.length());
            list.addAll(Arrays.asList(s.split(""  )));
            list.sort(Comparator.comparingInt(o -> o.charAt(0)));
            StringBuilder stringBuilder = new StringBuilder();
            for (String el : list) {
                stringBuilder.append(el);
            }
            return stringBuilder.toString();
        }

        public static void main(String[] args) {
            System.out.println(Alphabet.reformat("javascript"));
        }
    }

    public static int collectUniqueName(List<String> users) {
        Set<String> uniqueUsers = new HashSet<>(users);
        return uniqueUsers.size();
    }

    public static class SetIterator {
        public static void main(String[] args) {
            Set<String> strings = new TreeSet<>(Set.of("one", "two", "three", "four", "five"));
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                System.out.println(String.format("Next element exist? - %s.", true));
                System.out.println(iterator.next());
            }
        }
    }

    public static class Pangram {
        public static boolean checkString(String s) {
            Set<String> strings = new HashSet<>(Arrays.asList(s.split("")));
            List<String> marks = List.of(" ");
            strings.removeAll(marks);
//            for (String el : strings) {
//                System.out.println(el);
//            }
//            System.out.println(strings.size());
            return strings.size() == 26;
        }

        public static void main(String[] args) {
            String str = "Jackdaws love my big sphinx of quartz";
            boolean b = Pangram.checkString(str);
        }
    }

    public static class Firewall {
        public static String checkName(String s, Set<String> words) {
            Set<String> strings = new HashSet<>(Arrays.asList(s.split(" ")));
            String rsl = "Вы сделали правильный выбор!";
            for (String el : words) {
                if (strings.contains(el)) {
                    rsl = "Выберите другую статью...";
                    break;
                }
            }
            return rsl;
        }
    }

    public static class Jackpot {
        public static boolean checkYourWin(String[] combination) {
            Set<String> strings = new HashSet<>(Arrays.asList(combination));
            return strings.size() == 1;
        }
    }

    public static class Isogram {
        public static boolean checkString(String s) {
            Set<String> strings = new HashSet<>(Arrays.asList(s.split("")));
            return s.length() == strings.size();
        }
    }

}
