package srpfacadelab;

import java.util.List;
import java.util.ArrayList;

public class InventoryManagement{
	private RpgPlayer player;

	public InventoryManagement(RpgPlayer player){
		player = player
	}

	public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }
    
    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }    

    public boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        if (weight + item.getWeight() > carryingCapacity)
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            health += item.getHeal();

            if (health > maxHealth)
                health = maxHealth;

            if (item.getHeal() > 500) {
                player.getGameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare()){
            if (item.isUnique(){
               player.getGameEngine.playSpecialEffect("blue_swirly");
            }
            else{
            player.getGameEngine.playSpecialEffect("cool_swirly_particles");
            }
         }
        inventory.add(item);

        player.calculateStats();

        return true;
    }

}