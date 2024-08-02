package hash;

import java.util.Scanner;

public class HashTabTestClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTab hashTab = new HashTab(10);
        while (true){
            System.out.println("add\nfind\nlist\nexit");
            char t = scanner.next().charAt(0);
            switch (t){
                case 'a':
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    hashTab.add(new Emp(id,name));
                    hashTab.list();
                    break;
                case 'f':
                    System.out.println("请输入id");
                    id = scanner.nextInt();
                    Emp emp = hashTab.findById(id);
                    System.out.println(emp);
                    break;
                case 'l':
                    hashTab.list();
                    break;
                case 'e':
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("不支持的操作");
                    break;
            }
        }
    }
}
