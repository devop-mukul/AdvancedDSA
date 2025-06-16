class TNode {
    TNode[] ar;
    boolean is_end;
    int count;
    String prefix = "";

    TNode() {
        ar = new TNode[26];
        is_end = false;
        count = 0;
    }
}

public class renamingCities {
    TNode root;

    public renamingCities() {
        root = new TNode();
    }

    public void insert(String word) {
        TNode temp = root; 
        boolean flag = true;
        StringBuilder ans = new StringBuilder(); 

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            ans.append(word.charAt(i)); 

            if (temp.ar[index] == null) {
                temp.ar[index] = new TNode();
            }
            temp.ar[index].count++;

            temp = temp.ar[index]; 
            temp.prefix = ans.toString(); 
        }

        temp.is_end = true; 
    }

public void insert2(String word) {
    TNode temp = root; 
    boolean flag = true;
    StringBuilder ans = new StringBuilder(); 

    for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';

        if (temp.ar[index] == null) {
            temp.ar[index] = new TNode();
        }

        if (flag) {
            ans.append(word.charAt(i));
        }

        temp = temp.ar[index];
        temp.count++;

        if (temp.count == 1) {
            flag = false; 
        }

        temp.prefix = ans.toString();
    }

    temp.is_end = true; 
}

    public static void main(String[] args) {
        renamingCities trie = new renamingCities();
        System.out.println("Renaming Cities Trie Initialized");
        trie.insert2("newyork");
        trie.insert2("newark");
    }
}