import java.util.Scanner;

public class Shortestpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions: ");
        int dimrow = sc.nextInt();
        int dimcol = sc.nextInt();
        System.out.println("Enter the adventurer's position: ");
        int advenrow = sc.nextInt();
        int advencol = sc.nextInt();
        System.out.println("Enter the monster's position: ");
        int monsterrow = sc.nextInt();
        int monstercol = sc.nextInt();
        System.out.println("Enter the gold position: ");
        int goldrow = sc.nextInt();
        int goldcol = sc.nextInt();
        StringBuilder path = new StringBuilder();
        int steps = minSteps(advenrow, advencol, goldrow, goldcol, monsterrow, monstercol, path);
        if (steps == -1) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps to reach gold: " + steps);
            System.out.println("Path taken by adventurer: " + path.toString());
        }
    }
    private static int minSteps(int startrow, int startcol, int endrow, int endcol, int monsterrow, int monstercol, StringBuilder path) {
        if ((startrow <= monsterrow && monsterrow <= endrow || endrow <= monsterrow && monsterrow <= startrow) &&
                (startcol <= monstercol && monstercol <= endcol || endcol <= monstercol && monstercol <= startcol)) {
            return -1;
        }
        int steps = Math.abs(startrow - endrow) + Math.abs(startcol - endcol);
        for (int i = 0; i < steps; i++) {
            path.append("(").append(startrow).append(",").append(startcol).append(")");
            if (startrow < endrow) {
                startrow++;
            } else if (startrow > endrow) {
                startrow--;
            } else if (startcol < endcol) {
                startcol++;
            } else if (startcol > endcol) {
                startcol--;
            }
        }
        return steps;
    }
}
