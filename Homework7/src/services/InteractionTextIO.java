package services;

public class InteractionTextIO implements InfInteractionServ {

	@Override
	public int getInt() {
		int number = TextIO.getlnInt();
		System.out.println("TEXTIO");
		return number;
	}

}
