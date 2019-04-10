package escape.items;

import escape.InteractionManager;

public class VelvetBox extends DefaultItem{
	
	boolean empty = false;
	
	public VelvetBox(){
		name = "velvet box";
		description = "A small velvet box which materialised itself inside the DRESS";
	}
	
	@Override
	public void lookAt(){
		InteractionManager.say("You pull the velvet box out your pockets and turn it over in your hands. It's impossibly "
				 			 + "soft, and unbelievably beautiful, which is something you never thought you'd "
				 			 + "say about something that was just a box.");
	}
	
	@Override
	public void open(){
		if(!empty){
			InteractionManager.say("You push the lid of the box and it swings open like a clam shell. Inside, glistening "
					 			 + "like a thousand tiny diamonds, sits a SIGNET RING. The seal on the top seems to be "
					 			 + "some kind of loveheart insignia. You grab the SIGNET RING, click the box shut, and "
					 			 + "put them both back in your pockets");
			InteractionManager.addItemToInventory(new SignetRing());
			empty = true;
		}
		else{
			InteractionManager.say("You swing the clamshell lid open and inspect the exquisite cushioning on the inside of the box. "
								 + "You then realise you probably have better things to be doing and click the box shut again, putting "
								 + "it back in your pocket.");
		}
	}
	
	@Override
	public void close(){
		InteractionManager.say("It's already closed...");
	}
}
