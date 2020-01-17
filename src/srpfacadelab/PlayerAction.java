package srpfacadelab;

public class PlayerAction{
	private RpgPlayer player;

	public PlayerAction(RpgPlayer player){
		player = player
	}


	public void takeDamage(int damage) {
        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - armour;
        if (player.calculateInventoryWeight() <= float(player.getCarryingCapacity()/2)){
            damageToDeal = float(damageToDeal/4)
        }
        player.setHealth(player.getHealth()-damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
}