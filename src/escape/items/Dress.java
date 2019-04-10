package escape.items;

import escape.InteractionManager;

public class Dress extends DefaultItem{

	public Dress(){
		name = "dress";
		description = "A beautiful navy blue DRESS, hanging in a wardrobe";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("As you look over the elegant folds of the dress, you can't help but let out a slight gasp. "
				             + "It looks like any other dress you've ever seen, and there doesn't seem to be anything particularly "
				             + "special about it, and yet despite that, you just can't seem to take your eyes off of it, as if it possesses "
				             + "some kind of magical aura that captures your mind. You shake your head and look away, for fear that you'd "
				             + "end up staring at it for all eternity.");
	}
	
	@Override
	public void pickUp(){
		InteractionManager.say("You reach your hand out and immediately feel a strange sensation, like a pulsating aura emenating from the "
				             + "dress. Tentatively, you touch the dress and in a flash it's gone. You twirl around, trying to see where "
				             + "it went, and as you do you hear the rustling of fabrics and feel a swish around your legs. Looking down, you "
				             + "see the dress, the same one that was hanging in the wardrobe only a few moments before. You're confused, and "
				             + "amazed, and you feel like you should put it back, but you can't help just doing one twirl in it first, as if "
				             + "compelled by some unknown force deep within you. You spin, and as you do so, you see the colours of the dress "
				             + "shift before "
				             + "your very eyes, from a navy blue to a dandelion yellow. The fabrics morph and twist and twirl, and when you come "
				             + "to rest a completely different dress lays upon you. You spin again, and the dress shifts once more. You spin and "
				             + "spin, a thousand colours dancing off the white walls, and a thousand layers of fabric flowing around you. You "
				             + "spin and spin and spin and spin, before eventually coming to rest once more, the perfect dress now adorning you. "
				             + "You stop a minute to catch your breath, and feel a lump form within your pockets. You're not even quite sure how "
				             + "or where this dress has pockets but you find them and stick your hand inside, finding a strange small VELVET BOX "
				             + "that wasn't there before.");
		InteractionManager.getCurrentRoom().removeItem(this);
		InteractionManager.addItemToInventory(new VelvetBox());
	}
	
	@Override
	public void use(){
		pickUp();
	}
}
