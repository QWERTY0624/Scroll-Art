import java.util.Random;

public class SwordShield {

    public static void main(String[] args) throws Exception {
        int width = getTerminalWidth() - 1;
        Random spaces = new Random();
        Random spaces2 = new Random();
        Random delays = new Random();
        Random side = new Random();
        
        while (true) {
            int spacing = spaces.nextInt(0, width / 2);
            int spacing2 = spaces2.nextInt(0, width / 2);
            int delay = delays.nextInt(0, 15);
            boolean whichFirst = side.nextInt(0,2) == 1;

            for (int i = 0; i < 13 + delay; i++) {
                printArt(spacing, spacing2, i, delay, whichFirst);
                Thread.sleep(50);
            }

        }

    }

    static char[][] getSword() {
        char[][] img = new char[13][10];

        for (int i = 0; i < 13; i++) {
            for (int x = 0; x < 10; x++) {
                img[i][x] = ' ';
            }
        }

        img[0][3] = '|';
        img[0][4] = '-';
        img[0][5] = '|';
        img[1][3] = '|';
        img[1][5] = '|';
        img[2][3] = '|';
        img[2][5] = '|';
        img[3][1] = '-';
        img[3][2] = '-';
        img[3][3] = '-';
        img[3][4] = '-';
        img[3][5] = '-';
        img[3][6] = '-';
        img[3][7] = '-';
        img[4][0] = '|';
        img[4][1] = '\\';
        img[4][2] = '\\';
        img[4][3] = '\\';
        img[4][4] = '\\';
        img[4][5] = '\\';
        img[4][6] = '\\';
        img[4][7] = '\\';
        img[4][8] = '|';
        img[5][1] = '-';
        img[5][2] = '-';
        img[5][3] = '-';
        img[5][4] = '-';
        img[5][5] = '-';
        img[5][6] = '-';
        img[5][7] = '-';
        img[6][3] = '|';
        img[6][5] = '|';
        img[7][3] = '|';
        img[7][5] = '|';
        img[8][3] = '|';
        img[8][4] = '|';
        img[8][5] = '|';
        img[9][3] = '|';
        img[9][4] = '|';
        img[9][5] = '|';
        img[10][3] = '|';
        img[10][4] = '|';
        img[10][5] = '|';
        img[11][3] = '\\';
        img[11][4] = '|';
        img[11][5] = '/';
        img[12][4] = 'ˇ';

        return img;
    }

    static char[][] getShield() {
        char[][] img = new char[13][10];

        for (int i = 0; i < 13; i++) {
            for (int x = 0; x < 10; x++) {
                img[i][x] = ' ';
            }
        }

        img[0][0] = '|';
        img[0][1] = '-';
        img[0][2] = '-';
        img[0][3] = '-';
        img[0][4] = '-';
        img[0][5] = '-';
        img[0][6] = '-';
        img[0][7] = '-';
        img[0][8] = '-';
        img[0][9] = '|';
        img[1][0] = '|';
        img[1][1] = '\\';
        img[1][4] = '|';
        img[1][5] = '|';
        img[1][8] = '/';
        img[1][9] = '|';
        img[2][0] = '|';
        img[2][2] = '\\';
        img[2][4] = '|';
        img[2][5] = '|';
        img[2][7] = '/';
        img[2][9] = '|';
        img[3][0] = '|';
        img[3][3] = '\\';
        img[3][4] = '|';
        img[3][5] = '|';
        img[3][6] = '/';
        img[3][9] = '|';
        img[4][0] = '|';
        img[4][4] = '\\';
        img[4][5] = '/';
        img[4][9] = '|';
        img[5][0] = '|';
        img[5][4] = '/';
        img[5][5] = '\\';
        img[5][9] = '|';
        img[6][0] = '|';
        img[6][3] = '/';
        img[6][4] = '|';
        img[6][5] = '|';
        img[6][6] = '\\';
        img[6][9] = '|';
        img[7][0] = '|';
        img[7][2] = '/';
        img[7][4] = '|';
        img[7][5] = '|';
        img[7][7] = '\\';
        img[7][9] = '|';
        img[8][0] = '|';
        img[8][1] = '/';
        img[8][4] = '|';
        img[8][5] = '|';
        img[8][8] = '\\';
        img[8][9] = '|';
        img[9][1] = '\\';
        img[9][4] = '|';
        img[9][5] = '|';
        img[9][8] = '/';
        img[10][2] = '\\';
        img[10][4] = '|';
        img[10][5] = '|';
        img[10][7] = '/';
        img[11][3] = '\\';
        img[11][4] = '|';
        img[11][5] = '|';
        img[11][6] = '/';
        img[12][4] = '\\';
        img[12][5] = '/';

        return img;
    }

    static void printArt(int spacing, int spacing2, int row, int delay, boolean first) {
        System.out.println("");
        // Sword first
        if (first == true) {
            if (row < 13) {
                for (int s = 0; s < spacing; s++) {
                    System.out.print(" ");
                }
                for (int x = 0; x < 10; x++) {
                    System.out.print(getSword()[row][x]);
                }
            }

            // shield
            if (row - delay >= 0) {
                if (row > 12) {
                    for (int s = 0; s < spacing + 10; s++) {
                        System.out.print(" ");
                    }
                }
                for (int s = 0; s < spacing2; s++) {
                    System.out.print(" ");
                }
                for (int x = 0; x < 10; x++) {
                    System.out.print(getShield()[row - delay][x]);
                }
            }
        }

        // shield first
        else {
            if (row < 13) {
                for (int s = 0; s < spacing; s++) {
                    System.out.print(" ");
                }
                for (int x = 0; x < 10; x++) {
                    System.out.print(getShield()[row][x]);
                }
            }

            // shield
            if (row - delay >= 0) {
                if (row > 12) {
                    for (int s = 0; s < spacing + 10; s++) {
                        System.out.print(" ");
                    }
                }
                for (int s = 0; s < spacing2; s++) {
                    System.out.print(" ");
                }
                for (int x = 0; x < 10; x++) {
                    System.out.print(getSword()[row - delay][x]);
                }
            }
        }
    }

    // width of terminal
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
