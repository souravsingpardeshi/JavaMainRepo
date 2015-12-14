package javasmmr.zoowsome.services.factories.animalFactories;
import javasmmr.zoowsome.models.animals.*;

public abstract class SpeciesFactory {
	public abstract Animal getAnimal(String type) throws Exception;
	public abstract Animal getAnimalWithRandomAttributes(String type) throws Exception;
}
