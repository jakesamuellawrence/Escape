package escape.items;

public interface Item{
	
	public String getName();
	public String getDescription();
	
	public void lookAt();
	public void use();
	public void useWith(Item target);
	public void pickUp();
	public void open();
	public void close();
}
