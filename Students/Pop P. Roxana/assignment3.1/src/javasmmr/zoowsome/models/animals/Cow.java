package javasmmr.zoowsome.models.animals;

public class Cow extends Mammal {

	public Cow(Integer nrOfLegs, String name, float normalBodyTemp, float hairPerc) {

		setNrOfLegs(nrOfLegs);
		setName(name);
		setNormalBodyTemp(normalBodyTemp);
		setPercBodyHair(hairPerc);
	}

	public Cow() {
		this(new Integer(4), "cow", 37, 0.8f);
	}

}
