import java.util.Random;

public class Diamonds {

    public static void main(String[] args) throws Exception {
        int terminalWidth = getTerminalWidth()-1;
        Random size = new Random();
        while (true) { 
            int tempSize = size.nextInt(0,terminalWidth/2);
            for(int i = -1; i < tempSize; i+=2){
                printDiamond(i, terminalWidth);
                Thread.sleep(20);
            }
            for(int i = tempSize; i > 0; i-=2){
                printDiamond(i, terminalWidth);
                Thread.sleep(20);
            }
            
        }
    }

    static void printDiamond(int amount, int width){
        System.out.println("");
        for(int i = 0; i < (width / 2) - (amount / 2); i++){
            System.out.print(" ");
        }
        for(int i = 0; i < amount; i++){
            System.out.print("#");
        }
    
    }


    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    }
}

