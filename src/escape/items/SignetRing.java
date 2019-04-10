package escape.items;

import escape.InteractionManager;

public class SignetRing extends DefaultItem{

	public SignetRing(){
		name = "signet ring";
		description = "a signet ring with a loveheart insignia";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("You turn the signet ring over in your hands and it glistens like a thousand tiny diamonds. "
							 + "The seal on the top of the ring seems to be some kind of embossed loveheart insignia. It's "
							 + "beautifully ornate.");
	}
	
}
