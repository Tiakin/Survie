package fr.tiakin.item;

import java.util.Arrays;
import java.util.Collection;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum Foods {
	
	//other
	uncooked_fries(
			Items.uncooked_fries,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 1, 0)
			}
		),
	cooked_fries(
			Items.cooked_fries,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 4, 0)
			}
		),
	chocolate_caramel_fudge(
			Items.chocolate_caramel_fudge,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 2, 0)
			}
		),
	cotton_candy(
			Items.cotton_candy,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 1, 0)
			}
		),
	baguette(
			Items.baguette,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 5, 0)
			}
		),
	hamburger(
			Items.hamburger,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 600, 0)
			}
		),
	cheese_burger(
			Items.cheese_burger,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 800, 0)
			}
		),
	bacon_cheese_burger(
			Items.bacon_cheese_burger,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 800, 0)	
			}
		),
	fish_and_chips(
			Items.fish_and_chips,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 400, 0)		
			}
		),
	cheese(
			Items.cheese,
			new PotionEffect[] {
				new PotionEffect(PotionEffectType.SATURATION, 200, 0)
			}
		),
	
	//carrot
	diamond_carrot(
			Items.diamond_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0)
					}
		),
	emerald_carrot(
			Items.emerald_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 0),
					new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 12000, 1)
					}
		),
	netherite_carrot(
			Items.netherite_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.NIGHT_VISION, 18000, 0),
					new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 12000, 0),
					new PotionEffect(PotionEffectType.WATER_BREATHING, 18000, 0)
					}
		),
	enderite_carrot(
			Items.enderite_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.SLOW_FALLING, 18000, 0),
					new PotionEffect(PotionEffectType.JUMP, 18000, 1)
					}
		),
	discordium_carrot(
			Items.discordium_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.INVISIBILITY, 12000, 0),
					new PotionEffect(PotionEffectType.LUCK, 18000, 0)
					}
		),
	blazite_carrot(
			Items.blazite_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SPEED, 12000, 1),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 1)
					}
		),
	manyullyn_carrot(
			Items.manyullyn_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.GLOWING, 18000, 0),
					new PotionEffect(PotionEffectType.LUCK, 18000, 0)
					}
		),
	chaos_carrot(
			Items.chaos_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.CONFUSION , 1000, 0),
					new PotionEffect(PotionEffectType.LEVITATION, 1500, 0),
					new PotionEffect(PotionEffectType.BLINDNESS , 1500, 0),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 12000, 2)
					}
		),
	netherstar_carrot(
			Items.netherstar_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 4800, 0),
					new PotionEffect(PotionEffectType.LUCK, 24000, 0)
					}
		),
	infinity_carrot(
			Items.infinity_carrot,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 6000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 7200, 0),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 16000, 1),
					new PotionEffect(PotionEffectType.SPEED, 16000, 1),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 2),
					new PotionEffect(PotionEffectType.JUMP, 18000, 2),
					new PotionEffect(PotionEffectType.REGENERATION, 1200, 0)
					}
		),
	
	//apple
	diamond_apple(
			Items.diamond_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0)
					}
		),
	enchanted_diamond_apple(
			Items.enchanted_diamond_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 1)
					}
		),
	emerald_apple(
			Items.emerald_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 0),
					new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 12000, 1)
					}
		),
	enchanted_emerald_apple(
			Items.enchanted_emerald_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 1),
					new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, 30000, 3)
					}
		),
	netherite_apple(
			Items.netherite_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.NIGHT_VISION, 18000, 0),
					new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 12000, 0),
					new PotionEffect(PotionEffectType.WATER_BREATHING, 18000, 0)
					}
		),
	enchanted_netherite_apple(
			Items.enchanted_emerald_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 24000, 0),
					new PotionEffect(PotionEffectType.NIGHT_VISION, 30000, 0),
					new PotionEffect(PotionEffectType.WATER_BREATHING, 30000, 0)
					}
		),
	enderite_apple(
			Items.enderite_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SLOW_FALLING, 18000, 0),
					new PotionEffect(PotionEffectType.JUMP, 18000, 1)
					}
		),
	enchanted_enderite_apple(
			Items.enchanted_enderite_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.SLOW_FALLING, 30000, 0),
					new PotionEffect(PotionEffectType.JUMP, 30000, 3)
					}
		),
	discordium_apple(
			Items.discordium_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.INVISIBILITY, 12000, 0),
					new PotionEffect(PotionEffectType.LUCK, 18000, 0)
					}
		),
	enchanted_discordium_apple(
			Items.enchanted_discordium_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.INVISIBILITY, 18000, 0),
					new PotionEffect(PotionEffectType.LUCK, 30000, 1)
					}
		),
	blazite_apple(
			Items.blazite_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SPEED, 12000, 1),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 12000, 1)
					}
		),
	enchanted_blazite_apple(
			Items.enchanted_blazite_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.SPEED, 18000, 2),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 18000, 2)
					}
		),
	manyullyn_apple(
			Items.manyullyn_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.GLOWING, 18000, 0),
					new PotionEffect(PotionEffectType.LUCK, 18000, 0)
					}
		),
	enchanted_manyullyn_apple(
			Items.enchanted_manyullyn_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.GLOWING, 30000, 0),
					new PotionEffect(PotionEffectType.LUCK, 30000, 1)
					}
		),
	chaos_apple(
			Items.chaos_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.CONFUSION , 1000, 0),
					new PotionEffect(PotionEffectType.LEVITATION, 1500, 0),
					new PotionEffect(PotionEffectType.BLINDNESS , 1500, 0),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 12000, 2)
					}
		),
	enchanted_chaos_apple(
			Items.enchanted_chaos_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.CONFUSION , 2000, 0),
					new PotionEffect(PotionEffectType.LEVITATION, 3000, 0),
					new PotionEffect(PotionEffectType.BLINDNESS , 3000, 0),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 24000, 4)
					}
		),
	netherstar_apple(
			Items.netherstar_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 4800, 0),
					new PotionEffect(PotionEffectType.LUCK, 24000, 0)
					}
		),
	enchanted_netherstar_apple(
			Items.enchanted_netherstar_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9600, 1),
					new PotionEffect(PotionEffectType.LUCK, 36000, 1)
					}
		),
	infinity_apple(
			Items.infinity_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 7200, 0),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 16000, 1),
					new PotionEffect(PotionEffectType.SPEED, 16000, 1),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 2),
					new PotionEffect(PotionEffectType.JUMP, 18000, 2),
					new PotionEffect(PotionEffectType.REGENERATION, 1200, 0)
					}
		),
	enchanted_infinity_apple(
			Items.enchanted_infinity_apple,
			new PotionEffect[] {
					new PotionEffect(PotionEffectType.SATURATION, 24000, 0),
					new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 12000, 1),
					new PotionEffect(PotionEffectType.FAST_DIGGING, 24000, 2),
					new PotionEffect(PotionEffectType.SPEED, 24000, 2),
					new PotionEffect(PotionEffectType.HEALTH_BOOST, 30000, 4),
					new PotionEffect(PotionEffectType.JUMP, 30000, 4),
					new PotionEffect(PotionEffectType.REGENERATION, 2400, 1)
					}
		);
	
	private Items item;
	private PotionEffect[] potionEffects;
		
	Foods(Items item, PotionEffect[] potionEffects) {
		this.item = item;
		this.potionEffects = potionEffects;
	}
	
	public Items getItem() {
    	return item;
    }
	
	public Collection<PotionEffect> getEffets() {
		return Arrays.asList(potionEffects);
	}
	
}
