import java.util.Random;
public class Hero {

    //properties
    private String name;

    private int hitPoints;

    //constructors
    public Hero(String userName){
        name = userName;
    }

    //methods
    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }

    public void attack(Hero opponent){
        double randomNumber = Math.random();
        if (randomNumber >= 0.5){
            hitPoints += 10;
        }
    }

    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void senzuBean(){
        hitPoints = 100;
    }
    public void fightUntilTheDeathHelper(Hero opponent){
        while (this.hitPoints > 0 && opponent.hitPoints > 0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        fightUntilTheDeathHelper(opponent);
        int tempOppPoints = opponent.getHitPoints();
        int tempMyPoints = getHitPoints();

        return opponent.name + ": " + tempOppPoints + "  " + name + ": " + tempMyPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] pointsArr = new int[2];

        while(n != 0){
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                pointsArr[0] += 1;
            }
            else{
                pointsArr[1] += 1;
            }
            opponent.senzuBean();
            senzuBean();
        }

        return pointsArr;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int[] tempArr = nFightsToTheDeathHelper(opponent, n);

        if(tempArr[0] > tempArr[1]){
            return (opponent.name + ": " + tempArr[1] + " wins\n" + name + ": " + tempArr[0] + " wins\n" + name + " wins!");
        } else if (tempArr[0] < tempArr[1]) {
            return (opponent.name + ": " + tempArr[1] + " wins\n" + name + ": " + tempArr[0] + " wins\n" + opponent.name + " wins!");
        }
        else{
            return (opponent.name + ": " + tempArr[1] + " wins\n" + name + ": " + tempArr[0] + " wins\n" + "OMG! It was actually a draw!");

        }

    }
    public void dramaticFightToDeath(Hero opponent){
        while(opponent.hitPoints != 0 || hitPoints !=0){
            attack(opponent);
            System.out.println(opponent.name + ": " + opponent.hitPoints + "  " + name + ": " + hitPoints);
        }

    }


}