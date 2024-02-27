public class CrackerRunnable implements Runnable {
    char start;
    String pass;
    static boolean found;

    public CrackerRunnable(char start, String pass) {
        this.start = start;
        this.pass = pass;
        this.found = false;
    }

    @Override
    public void run() {
        int len = pass.length();
        String atk = start + "a".repeat(len);


        while(!found) {
            System.out.println(atk);
            int i;
            for (i = len-1; atk.charAt(i) == 'z'; i--);
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len-i-1);
            atk = first + next + after;

            if(atk.equals(pass)) {
                found = true;
                System.out.println("Found: " + atk);
            }
        }

        // from ch+"aaaaa..." until ch+"zzzzz..."
        // example: pass = cool, ch = j
        // this thread searches jaaa to jzzz
    }

}

