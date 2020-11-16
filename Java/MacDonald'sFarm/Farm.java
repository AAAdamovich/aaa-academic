//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-17-12
//Lab 1

class Farm {
	private Animal[] a = new Animal[4];

	Farm() {
		a[0] = new Chick("cluck", "cheep", "chick");
		a[1] = new Pig("oink", "pig");
		a[2] = new Cow("moo", "cow");
		a[3] = new NamedCow("moo", "cow", "Jeff Beefington");
	}

	public void animalSounds() {
		for (int i = 0; i <= 1; i++)
			System.out.println("The " + a[i].getType() + " goes "
					+ a[i].getSound());
		System.out.println("The " + a[3].getType() + " named " + ((NamedCow) a[3]).getName()
				+ " goes " + a[3].getSound());
		// Testing the 'compareTo' method
		int comparer = (((Chick)a[0]).compareTo(((Cow)a[2])));
		if(comparer > 0) System.out.println("The chick was louder");
		else{ 
			if(comparer < 0) System.out.println("The Cow was louder");
			else System.out.println("The animals were the same volume");
		}
		// Testing the 'toString' method
		System.out.println(a[1].toString());
	}
}
