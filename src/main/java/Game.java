import java.util.*;

public class Game {
    private HashMap<String,Player> players = new HashMap<>() ;


    public void register(Player player) {
            this.players.putIfAbsent(player.getName(),player);
    }

    public int round(String playerName1, String playerName2) {
        if(playerName1.equals(playerName2)){
            System.out.println("You can't round with yourself.");
            throw new RuntimeException();
        }
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException();
        }
        if (player1.getStrength() - player2.getStrength() == 0) {
            return 0;
        } else if (player1.getStrength() - player2.getStrength() > 0) {
            return 1;
        } else {
            return 2;
        }
    }
    public HashMap<String,Player> findAll(){
        return players;
    }
}
