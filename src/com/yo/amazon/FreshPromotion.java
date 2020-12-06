package com.yo.amazon;

public class FreshPromotion {
    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        // test
//        test(codeList1, shoppingCart1, 1);
//        test(codeList2, shoppingCart2, 0);
//        test(codeList3, shoppingCart3, 0);
//        test(codeList4, shoppingCart4, 0);
//        test(codeList5, shoppingCart5, 1);
//        test(codeList6, shoppingCart6, 1);
//        test(codeList7, shoppingCart7, 1);
//        test(codeList8, shoppingCart8, 1);
//        test(codeList9, shoppingCart9, 1);

        // test
        System.out.println(isWinner(codeList1, shoppingCart1));
        System.out.println(isWinner(codeList2, shoppingCart2));
        System.out.println(isWinner(codeList3, shoppingCart3));
        System.out.println(isWinner(codeList4, shoppingCart4));
        System.out.println(isWinner(codeList5, shoppingCart5));
        System.out.println(isWinner(codeList6, shoppingCart6));
        System.out.println(isWinner(codeList7, shoppingCart7));
        System.out.println(isWinner(codeList8, shoppingCart8));
        System.out.println(isWinner(codeList9, shoppingCart9));
    }

    public static int isWinner(String[][] codeList, String[] shoppingCart) {
        int index = 0;
        int codeIndex = 0;
        int newIndex = index;
        int codeWordIndex = 0;
        while (codeIndex < codeList.length && newIndex < shoppingCart.length) {
            if (isMatched(shoppingCart[newIndex], codeList[codeIndex][codeWordIndex])) {
                newIndex++;
                codeWordIndex++;
                if (codeWordIndex == codeList[codeIndex].length) {
                    codeIndex++;
                    index = newIndex;
                    codeWordIndex = 0;
                }
            } else {
                index++;
                newIndex = index;
                codeWordIndex = 0;
            }
        }

        return codeIndex == codeList.length ? 1 : 0;
    }

    private static boolean isMatched(String source, String target) {
        return "anything".equals(target) || target.equals(source);
    }
}
