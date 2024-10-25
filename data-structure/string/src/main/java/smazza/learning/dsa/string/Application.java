package smazza.learning.dsa.string;

public class Application {

    public static void main(String[] args) {
        CustomString string = new CustomString("Hello World!".toCharArray());

        System.out.println(string);
        System.out.println("string.length(): " + string.length());
        System.out.println("string.indexOf('H'): " + string.indexOf('H'));
        System.out.println("string.indexOf('H', 1): " + string.indexOf('H', 1));
        System.out.println("string.lastIndexOf('o'): " + string.lastIndexOf('o'));
        System.out.println("string.lastIndexOf('o', 6): " + string.lastIndexOf('o', 6));
        System.out.println("string.contains('r'): " + string.contains('r'));
        System.out.println("string.contains(\"  \".toCharArray()): " + string.contains("  ".toCharArray()));
        System.out.println("string.contains(new CustomString(\"Hello \".toCharArray())): " + string.contains(new CustomString("Hello ".toCharArray())));
        System.out.println("string.isEmpty(): " + string.isEmpty());
        System.out.println("string.isNotEmpty(): " + string.isNotEmpty());
        System.out.println("string.isBlank(): " + string.isBlank());
        System.out.println("string.isNotBlank(): " + string.isNotBlank());
        System.out.println("string.equals(\"Hello World!\".toCharArray()): " + string.equals("Hello World!".toCharArray()));
        System.out.println("string.equals(string): " + string.equals(string));
        System.out.println("string.equalsIgnoreCase(\"hello world!\".toCharArray()): " + string.equalsIgnoreCase("hello world!".toCharArray()));
        System.out.println("string.equalsIgnoreCase(string): " + string.equalsIgnoreCase(string));
        System.out.println("string.endsWith('!'): " + string.endsWith('!'));
        System.out.println("string.endsWith(\"World!\".toCharArray()): " + string.endsWith("World!".toCharArray()));
        System.out.println("string.endsWith(new CustomString(\"World!\".toCharArray())): " + string.endsWith(new CustomString("World!".toCharArray())));
        System.out.println("string.startsWith('H'): " + string.startsWith('H'));
        System.out.println("string.startsWith(\"Hell\".toCharArray()): " + string.startsWith("Hell".toCharArray()));
        System.out.println("string.startsWith(new CustomString(\"Hell\".toCharArray())): " + string.startsWith(new CustomString("Hell".toCharArray())));
        System.out.println("string.charAt(0): " + string.charAt(0));
        System.out.println("string.toLowerCase(): " + string.toLowerCase());
        System.out.println("string.toUpperCase(): " + string.toUpperCase());
        System.out.println("string.replace('H', 'h'): " + string.replace('H', 'h'));
        System.out.println("string.replace('o', 'O', 5): " + string.replace('o', 'O', 5));
        System.out.println("string.replace('o', 'O', 5, 10): " + string.replace('o', 'O', 5, 10));
        System.out.println("string.replaceAll('o', 'O'): " + string.replaceAll('o', 'O'));
        System.out.println("string.replaceAll('o', 'O', 5): " + string.replaceAll('o', 'O', 5));
        System.out.println("string.replaceAll('o', 'O', 5, 10): " + string.replaceAll('o', 'O', 5, 10));
        System.out.println("string.substring(5): " + string.substring(5));
        System.out.println("string.substring(0, 5): " + string.substring(0, 5));
        System.out.println("string.concat('!'): " + string.concat('!'));
        System.out.println("string.concat(\" I'm Simone\".toCharArray()): " + string.concat(" I'm Simone".toCharArray()));
        System.out.println("string.concat(new CustomString(\" I'm Simone\".toCharArray())): " + string.concat(new CustomString(" I'm Simone".toCharArray())));
    }
}
