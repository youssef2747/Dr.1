
public class person {
	private int id;
	private String name ;
	private int Start_His;
	private int End_His;
	
	public person(int id, String name, int start_His, int end_His) {
		this.id = id;
		this.name = name;
		Start_His = start_His;
		End_His = end_His;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStart_His() {
		return Start_His;
	}
	public void setStart_His(int start_His) {
		Start_His = start_His;
	}
	public int getEnd_His() {
		return End_His;
	}
	public void setEnd_His(int end_His) {
		End_His = end_His;
	}
	public static person LinearSearch(String name) {
		person  a = null;
		for(int i=0 ; i<database.getPersons().size();i++) {
			if(database.getPersons().get(i).getName().equals(name)) {
				a=database.getPersons().get(i);
			}
		}
		return a;
	}
	
}
