package springboot.web.raw;

import springboot.web.raw.models.Concert;

import java.util.ArrayList;
import java.util.Set;

public class User {
	private int number_of_programID_greater_than;
	private String concerts_of_the_season;
	private String concerts_of_workID;
	private String venues_at_the_composer_performed;

	private int count;
	private Set<String> venues;
	private Set<String> sconcert;
	private Set<String> ret;


	public int getNumber_of_programID_greater_than() {
		return number_of_programID_greater_than;
	}

	public void setNumber_of_programID_greater_than(int number_of_programID_greater_than) {
		this.number_of_programID_greater_than = number_of_programID_greater_than;
	}

	public String getConcerts_of_the_season() {
		return concerts_of_the_season;
	}

	public void setConcerts_of_the_season(String concerts_of_the_season) {
		this.concerts_of_the_season = concerts_of_the_season;
	}

	public String getConcerts_of_workID() {
		return concerts_of_workID;
	}

	public void setConcerts_of_workID(String concerts_of_workID) {
		this.concerts_of_workID = concerts_of_workID;
	}

	public String getVenues_at_the_composer_performed() {
		return venues_at_the_composer_performed;
	}

	public void setVenues_at_the_composer_performed(String venues_at_the_composer_performed) {
		this.venues_at_the_composer_performed = venues_at_the_composer_performed;
	}

	public Set<String> getSconcert() {
		return sconcert;
	}

	public void setSconcert(Set<String> sconcert) {
		if (sconcert == null) {
			throw new NullPointerException("stringList must not be null");
		} else {
			this.sconcert = sconcert;
		}
	}



	public int getCount(){
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;

	}

	public Set<String> getRet() {
		return ret;
	}

	public void setRet(Set<String> ret) {
		this.ret = ret;
	}

	public Set<String> getVenues() {
		return venues;
	}

	public void setVenues(Set<String> venues) {
		this.venues = venues;
	}
}
