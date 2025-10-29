import java.util.Random;

public class ScrollArt {
    static final int WIDTH = getTerminalWidth() - 1;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        char[][] nextRows = new char[34][WIDTH]; // store upcoming rows
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }

        char[] prevRow = nextRows[0];
        while (true) {
            // At each column on the top row, 1% chance to add a new image
            for (int x = 0; x < WIDTH - 34; x += 34) {
                if (isBlank(prevRow, x) && rand.nextDouble() < 0.08) {
                    loadNextRowsWithImage(nextRows, x);
                }
            }
            // Print and remove the top row
            System.out.println(new String(nextRows[0]));
            prevRow = nextRows[0];
            // Shift all rows up
            shiftRowsUp(nextRows);
            Thread.sleep(100); // Delay in ms
            long time = System.currentTimeMillis() - startTime;

            // System.err.println("average time per frame: " + (time / iterations) + " ms");
        }
    }

    private static boolean isBlank(char[] prevRow, int x) {
        for (int i = x; i < x + 34; i++) {
            if (prevRow[i] != ' ') {
                return false;
            }
        }
        return true;
    }

    private static void loadNextRowsWithImage(char[][] nextRows, int x) {
        // char[][][] images;
        AsciiArt[] images = { new AsciiArt(getShield()), new AsciiArt(getSword()),new AsciiArt(getOtherSword()),
            new AsciiArt(getSparkle()), new AsciiArt(masker()), new AsciiArt(getCloud()) };
        AsciiArt art = images[rand.nextInt(images.length)];
        AsciiArt widestArt = AsciiArt.getWidestArt(images);
        art.resize(widestArt.width);
        for (int iy = 0; iy < art.height; iy++) { // height
            for (int ix = 0; ix < art.width; ix++) { // widrth
                nextRows[iy][x + ix] = art.img[iy][ix];
            }
        }
    }

    static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
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

    // rename your function here
    static char[][] getSparkle() { //Sparkle by Oliver Joffee, https://github.com/Oliver-Joffee/scroll-art
        char[][] img = new char[8][6];
        // fill with empty space
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 6; x++) {
                img[y][x] = ' ';
            }
        }

        img[3][0] = '/';
        img[4][0] = '\\';
        img[2][0] = '_';
        img[1][0] = '_';
        img[5][0] = '_';
        img[6][0] = '_';
        img[1][1] = '\\';
        img[6][1] = '/';
        img[1][2] = '/';
        img[6][2] = '\\';
        img[0][2] = '_';
        img[7][2] = '_';
        img[1][3] = '\\';
        img[6][3] = '/';
        img[1][4] = '/';
        img[6][4] = '\\';
        img[3][5] = '\\';
        img[4][5] = '/';
        img[2][5] = '‾';
        img[1][5] = '‾';
        img[5][5] = '‾';
        img[6][5] = '‾';

        
    
        return img;
    }

    static char[][] getOtherSword() { //Sword by Rayden Wang, https://github.com/rwanghm5/scroll-art/blob/main/Rayden'sAsciiArtStuff/src/AsciiArt.java
        char[][] img = new char[16][12];
        // fill with empty space
        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 12; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][2] = '/';
        img[0][3] = '\\';
        img[1][1] = '(';
        img[1][4] = ')';
        img[2][1] = '/';
        img[2][4] = '\\';

        img[3][0] = '|';
        img[3][2] = '~';
        img[3][3] = '~';
        img[3][5] = '|';
        img[4][0] = '|';
        img[4][2] = '~';
        img[4][3] = '~';
        img[4][5] = '|';
        img[5][0] = '|';
        img[5][2] = '~';
        img[5][3] = '~';
        img[5][5] = '|';
        img[6][0] = '|';
        img[6][2] = 'R';
        img[6][3] = 'W';
        img[6][5] = '|';
        img[7][0] = '|';
        img[7][2] = '~';
        img[7][3] = '~';
        img[7][5] = '|';
        img[8][0] = '|';
        img[8][2] = '~';
        img[8][3] = '~';
        img[8][5] = '|';
        img[9][0] = '(';
        img[9][2] = '~';
        img[9][3] = '~';
        img[9][5] = ')';
        img[10][0] = '\\';
        img[10][2] = '~';
        img[10][3] = '~';
        img[10][5] = '/';
        img[11][1] = '|';
        img[11][4] = '|';
        img[12][1] = '|';
        img[12][4] = '|';
        img[13][1] = '\\';
        img[13][4] = '/';
        img[14][2] = '\\';
        img[14][3] = '/';

        return img;
    }

    static char[][] masker() { //Mask by Conor Felczak, https://github.com/conor-felczak/scroll-art
        char[][] img = new char[13][13];
        for(int y = 0; y < 13; y++) {
            for(int x = 0; x < 13; x++) {
                img[x][y] = ' ';
            }
        }
        img[0][0] = '/';
        img[0][1] = '-';
        img[0][2] = '-';
        img[0][3] = '-';
        img[0][4] = '-';
        img[0][5] = '\\';
        img[0][6] = '/';
        img[0][7] = '-';
        img[0][8] = '-';
        img[0][9] = '-';
        img[0][10] = '-';
        img[0][11] = '\\';
        img[0][12] = ',';
        

        img[1][0] = '\\';
        img[1][2] = '#';
        img[1][3] = '#';
        img[1][8] = '#';
        img[1][9] = '#';
        img[1][11] = '/';
        img[1][12] = ',';
        

        img[2][1] = '\\';
        img[2][4] = '/';
        img[2][7] = '\\';
        img[2][10] = '/';
        img[2][12] = ',';
        
        
        img[3][2] = '\\';
        img[3][3] = '-';
        img[3][5] = '\\';
        img[3][6] = '/';
        img[3][8] = '-';
        img[3][9] = '/';
        img[3][12] = ',';
       
        
        
        return img;
    }

    public static char[][] getCloud() { //cloud by David Moos, https://github.com/dmooshm/DM-Scroll-Art/blob/master/src/Cloud.java

        int cloudheight = 9;
        int cloudwidth = 6;

        char[][] cloudimg = new char[cloudheight+1][cloudheight+1];
        for (int y = 0; y <= cloudheight; y++) {
            for (int x = 0; x <= cloudwidth; x++) {
                cloudimg[y][x] = ' ';
            }
        }

        for (int i = 2; i <= 9; i++) {
            cloudimg[i][1] = ':';
        }
        cloudimg[1][2] = '_';
        cloudimg[2][3] = ':';
        cloudimg[2][4] = '.';
        cloudimg[3][5] = ':';
        cloudimg[4][4] = '*';
        cloudimg[5][5] = ':';
        cloudimg[6][6] = '*';
        cloudimg[7][6] = ';';
        cloudimg[8][4] = '.';
        cloudimg[8][5] = '*';
        cloudimg[9][2] = ':';
        cloudimg[9][3] = '*';

        return cloudimg;

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