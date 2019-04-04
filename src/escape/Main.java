package escape;

public class Main{
	public static void main(String[] args){
		TextManager.say("Hello! I'm escape!");
		String name = TextManager.ask("What's your name?");
		TextManager.say("Nice to meet you, " + name);
	}
}
