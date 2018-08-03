import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        SplayTree st = new SplayTree();
        Scanner s = new Scanner(System.in);
        String str;

        double start = System.nanoTime();

        int N = 0;

        /*while(true){
            System.out.println("1.Print(T)  2.Splay(x)  3.Search(x)  4.Insert(x)  5.Delete(x)  6.Quit");
            System.out.print("Task : ");
            int input = s.nextInt();
*/
        //while (++N<=10004) {
            //Random random = new Random();
            //int input = random.nextInt(3) + 3;

        int n=0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("1305072_input2.txt"));
            br.readLine();
            n = Integer.parseInt(br.readLine());
        } catch (Exception e) {}

        for(int i=1;i<=n;i++){
            str = br.readLine();
            StringTokenizer strt = new StringTokenizer(str, " ");
            int input = Integer.parseInt(strt.nextToken());

            if (input == 1) {
                st.tree = st.test(st.root);
                BTreePrinter.printNode(st.tree);
            } else if (input == 2) {
                //System.out.print("Splay : ");
                //int x = s.nextInt();
                int x = Integer.parseInt(strt.nextToken());
                st.root = st.splay(st.root, x);
            } else if (input == 3) {
                //System.out.print("Search : ");
                //int x = s.nextInt();
                //int x = random.nextInt(104);
                int x = Integer.parseInt(strt.nextToken());
                st.root = st.splay(st.root, x);
            } else if (input == 4) {
                //System.out.print("Insert : ");
                //int x = s.nextInt();
                //int x = random.nextInt(104);
                int x = Integer.parseInt(strt.nextToken());
                st.root = st.insert(st.root, x);
            } else if (input == 5) {
                //System.out.print("Delete : ");
                //int x = s.nextInt();
                //int x = random.nextInt(104);
                int x = Integer.parseInt(strt.nextToken());
                st.root = st.delete(st.root, x);
            } else if (input == 6) break;
        }

        double end = System.nanoTime();

        System.out.println("Total Operations time : "+(end-start)/1000000 + " ms");
    }
}
