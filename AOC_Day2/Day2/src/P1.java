import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
public class Main {

    public static void P1(String[] args) {
        try {
            // Replace "input.txt" with the actual path to your input file
            String input = Files.readString(Paths.get("/home/azur/IdeaProjects/AOC_Day2P1/src/input.txt"));
            String[] games = input.split("\n");
            int sum_valid_gameId = 0;
            // Loop through each line
            for (int i = 0; i < games.length; i++) {
                boolean is_valid = true;
                // First subest is "Game id:"
                String game = games[i].split(":")[1];
                // Second subset is a list of sets of cube
                String[] sets = game.split(";");

                // Loop into each set of cubes
                for (String set : sets) {
                    // Remove the inital withespace
                    set = set.replaceFirst(" ", "");

                    int red = 0;
                    int green = 0;
                    int blue = 0;
                    // "x red, y blue, z green" ==> {[x,red],[y,blue],[z,green]}
                    for (String reveal : set.split(", ")) {
                        String[] revealSplit = reveal.split(" ");
                        switch (revealSplit[1]){
                            case "red":
                                red += Integer.parseInt(revealSplit[0]);
                                break;
                            case "blue":
                                blue += Integer.parseInt(revealSplit[0]);
                                break;
                            case "green":
                                green += Integer.parseInt(revealSplit[0]);
                        }
                    }
                    if (red > 12 || green > 13 || blue > 14) {
                        is_valid = false;
                    }
                }

                if (is_valid) {
                    sum_valid_gameId += i + 1;
                }
            }

            System.out.printf("Sum of all valid Ids: %d", sum_valid_gameId);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
