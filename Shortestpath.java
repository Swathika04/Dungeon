import java.util.Scanner;
public class Shortestpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the dimensions: ");
        int dimrow = sc.nextInt();
        int dimcol = sc.nextInt();
        System.out.println("enter the adventurer's position: ");
        int advenrow = sc.nextInt();
        int advencol = sc.nextInt();
        System.out.println("enter the monster's position: ");
        int monsterrow = sc.nextInt();
        int monstercol = sc.nextInt();
        System.out.println("enter the gold position: ");
        int goldrow = sc.nextInt();
        int goldcol = sc.nextInt();
        int steps = minSteps(advenrow, advencol, goldrow, goldcol, monsterrow, monstercol);
        if (steps == -1) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps to reach gold: " + steps);
        }
    }
    private static int minSteps(int startrow, int startcol, int endrow, int endcol, int monsterrow, int monstercol) {
        if ((startrow <= monsterrow && monsterrow <= endrow || endrow <= monsterrow && monsterrow <= startrow) &&
                (startcol <= monstercol && monstercol <= endcol || endcol <= monstercol && monstercol <= startcol)) {
            return -1;
        }
        return Math.abs(startrow - endrow) + Math.abs(startcol - endcol);
    }
}
