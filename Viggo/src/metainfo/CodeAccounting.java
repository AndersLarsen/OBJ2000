package metainfo;

public @interface CodeAccounting {
	String teamId();// Your team's id
	String[] author(); // List of aliases 
	int valueimo(); // estimate of n/100 of project value in my opinion
	int valueito(); // estimate of n/100 of project value in team's opinion
}
