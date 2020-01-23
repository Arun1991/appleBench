package java8.model;

public class Bike {

	String name;
	String model;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Bike [name=" + name + ", model=" + model + "]";
	}
	
	
}
