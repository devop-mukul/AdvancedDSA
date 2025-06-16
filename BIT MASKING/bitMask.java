class bitMask {
    public static void main(String arg[]) {
        int n = 19;
        String s = Integer.toBinaryString(n);

        System.out.println(s);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                System.out.print(s.length() - i);
            else
                System.out.print(" ");
        }
        System.out.println();
        add(n, 4);
    }
    public static void add(int n, int k) {
        int mask = n ^ (1 << (k-1));
        String s = Integer.toBinaryString(mask);
        System.out.println(s);
    }
}