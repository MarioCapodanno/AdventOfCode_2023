import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
public class P2 {

    public static void main(String[] args) {
        try {
            // Replace "input.txt" with the actual path to your input file
            String input = Files.readString(Paths.get("/home/azur/IdeaProjects/AOC_Day2/P1/src/input.txt"));
            String[] games = input.split("\n");
            int sum_power_set = 0;
            // Loop through each line
            for (int i = 0; i < games.length; i++) {
                boolean is_valid = true;
                // First subest is "Game id:"
                String game = games[i].split(":")[1];
                // Second subset is a list of sets of cube
                String[] sets = game.split(";");
                int max_red = 1;
                int max_green = 1;
                int max_blue = 1;
                int r_index = 0;
                int b_index = 0;
                int g_index = 0;
                // Loop into each set of cubes
                for (String set : sets) {
                    // Remove the inital withespace
                    set = set.replaceFirst(" ", "");


                    // "x red, y blue, z green" ==> {[x,red],[y,blue],[z,green]}
                    for (String reveal : set.split(", ")) {
                        String[] revealSplit = reveal.split(" ");
                        int current_value = Integer.parseInt(revealSplit[0]);
                        switch (revealSplit[1]){
                            case "red":
                                if (current_value > max_red || r_index == 0)
                                    max_red = current_value;
                                    r_index++;
                                break;
                            case "blue":
                                if (current_value > max_blue || b_index == 0)
                                    max_blue = current_value;
                                    b_index++;
                                break;
                            case "green":
                                if (current_value > max_green || g_index == 0)
                                    max_green = current_value;
                                    g_index++;
                        }
                    }
                }
                System.out.println(r_index);
                System.out.printf("Game: %d Current value: %d red, %d blue, %d green", i, max_red, max_blue, max_green);
                sum_power_set += max_green*max_blue*max_red;
                System.out.println(sum_power_set);
            }

            System.out.printf("Sum of all valid Ids: %d", sum_power_set);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
