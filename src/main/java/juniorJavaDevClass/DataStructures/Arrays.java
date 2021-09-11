package juniorJavaDevClass.DataStructures;

public class Arrays {

    public static void main(String[] args) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g"};

        System.out.println("The old fashioned way");
        for (int i = 0; i < 5; i++) {
            System.out.print(alphabet[i] + " ");
        }

        System.out.println("\n\nUsing the length variable");

        int size = alphabet.length;
        for (int n = 0; n < size; n++) {
            System.out.print(alphabet[n] + " ");
        }

        System.out.println("\n\nUsing the For-Each method");
        for (String letter : alphabet) {
            System.out.print(letter + " ");
        }

        System.out.println("\n\nDouble Arrays");

        String [][] users = {
                {"John", "Williams", "jw@testemail.com", "789789456"},
                {"Sarah", "Jackson", "sj@testemail.com", "456456456"},
                {"RAchel", "Wallace", "rc@testemail.com", "9879874655"}
        };

        // Get the size of the array
        int numOfUsers = users.length;
        int numOfFields = users[0].length;
        System.out.println("Number of users: " + numOfUsers);
        System.out.println("Number of fields: " + numOfFields);

        // traverse the double array
        for (int i = 0; i < numOfUsers; i++) {
            for (int j = 0; j < numOfFields; j++) {
                System.out.println(users[i][j]);
            }
        }

        // traverse the double array
        for (int i = 0; i < numOfUsers; i++) {
            String firstName = users[i][0];
            String lastName = users[i][1];
            String email = users[i][2];
            String phone = users[i][3];
            System.out.println(firstName + " " + lastName + " " + email + " " + phone);
        }

        System.out.println("\n\nUsing FOR EACH");

        for (String[] user : users) {
            System.out.print("[ ");
            for (String field : user) {
                System.out.print(field + " ");
            }
            System.out.println(" ]");
        }
    }
}
