package srpfacadelab;

public class RPGFacade(){
	PlayerAction playerAction;
	InventoryManagement inventoryManagement;

	RPGFacade(RpgPlayer player){
		playerAction = PlayerAction(player);
		inventoryManagement = InventoryManagement(player);
	}

	public boolean checkIfItemExistsInInventory(Item item){
		return inventoryManagement.checkIfItemExistsInInventory(item);
	}
	public int calculateInventoryWeight(){
		return inventoryManagement.calculateInventoryWeight();
	}

	public boolean pickUpItem(Item item) {
		return inventoryManagement.pickUpItem(item);
	}

	public void takeDamage(int damage) {
		playerAction.takeDamage(damage);
	}

	public void useItem(Item item) {
		playerAction.useItem(item);
	}
}