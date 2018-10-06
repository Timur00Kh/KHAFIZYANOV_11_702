package ru.itis;

public class Main {

    public static void main(String[] args) {
        String s1 = "(4+((3+4)*(9+1)))";
        String s2 = "(3+(4*5))";
        String s3 = "((7+3)*(5-2))";

        ExpressionTree tree = new ExpressionTree();
        tree.insert(s1);
        tree.printByLevels();
        System.out.println("=============");
        tree.insert(s2);
        tree.printByLevels();
        System.out.println("=============");
        tree.insert(s3);
        tree.printByLevels();
        System.out.println("=============");

//        tree.insert("3+5*[6-2]]");

    }
}
