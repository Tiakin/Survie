package fr.tiakin.item;



public enum Discs {
	
	melo_disc(
			Items.melo_disc,
			"minecraft:custom.melo_coton"
		),
	moonlight_disc(
			Items.moonlight_disc,
			"minecraft:custom.moonlight"
		),
	ice_disc(
			Items.ice_disc,
			"minecraft:custom.ice"
		),
	pillaged_disc(
			Items.pillaged_disc,
			"minecraft:custom.pillaged"
		),
	shulk_disc(
			Items.shulk_disc,
			"minecraft:custom.shulk"
		);
	
	private Items item;
	private String sound;
		
	Discs(Items item, String sound) {
		this.item = item;
		this.sound = sound;
	}
	
	public Items getItem() {
    	return item;
    }
	
	public String getSound() {
		return sound;
	}
	
}
