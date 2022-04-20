import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (searchByName(player.getName()) == null) {
            this.players.add(player);
        }
    }

    public int round(String playerName1, String playerName2) {
        if(playerName1.equals(playerName2)){
            System.out.println("You can't round with yourself.");
            throw new RuntimeException();
        }
        Player player1 = searchByName(playerName1);
        Player player2 = searchByName(playerName2);
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
    public Player searchByName(String playerName) {
        for (Player player : players) {
            if (playerName.equals(player.getName())) {
                return player;
            }
        }
        return null;
    }
    public List<Player> findAll(){
        return players;
    }
}
