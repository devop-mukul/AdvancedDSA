class tnode {
    tnode ar[];
    boolean is_end;
    tnode() {
        ar = new tnode[26];
        is_end = false;
    }
}

class implementTrie {
    tnode root;

    public implementTrie() {
        root = new tnode();
    }
    
    public void insert(String word) {
        tnode temp = root; //start temporary from root
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if(temp.ar[index] == null) {
                temp.ar[index] =  new tnode();
            }

            temp = temp.ar[index];
        }
        temp.is_end = true;
    }
    
    public boolean search(String word) {
        tnode temp = root; //start temporary from root
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if(temp.ar[index] == null) {
                return false;
            }

            temp = temp.ar[index];
        }
        return temp.is_end;
    }
    
    public boolean startsWith(String prefix) {
        tnode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (temp.ar[index] == null) {
                return false;
            }

            temp = temp.ar[index];
        }
        return true;
    }
    public static void main(String[] args) {
        implementTrie trie = new implementTrie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println("apple\napp\nbat");
        System.out.println("Search for words:");
        System.out.println(trie.search("apple"));   
        System.out.println(trie.search("app"));     
        System.out.println(trie.search("appl"));    
        System.out.println(trie.search("bat"));     
        System.out.println(trie.search("batch"));   

        // Check for prefixes
        System.out.println("Start with prefixes:");
        System.out.println(trie.startsWith("app")); 
        System.out.println(trie.startsWith("bat")); 
        System.out.println(trie.startsWith("ba"));  
        System.out.println(trie.startsWith("cat")); 
    }
}