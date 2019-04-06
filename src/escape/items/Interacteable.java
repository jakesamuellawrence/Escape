package escape.items;

public interface Interacteable{
	
	public String getName();
	public String getDescription();
	
	public void lookAt();
	public void use();
	public void useWith(Interacteable target);
	public void pickUp();
	public void open();
	public void close();
}
