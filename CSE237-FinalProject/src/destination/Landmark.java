package destination;

import java.util.Objects;

public class Landmark {
	String name;
	
	public Landmark(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Landmark landmark = (Landmark) o;
		return Objects.equals(name, landmark.name);
	}
}