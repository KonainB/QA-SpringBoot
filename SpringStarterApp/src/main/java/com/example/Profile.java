package com.example;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Profile {
	@Size(min = 3, max = 10)
	private String forename;

	@Size(min = 3, max = 10)
	private String surname;

	@Pattern(regexp = "^(19|20)\\d\\d[- /.] (0[1-9]|1[012])[- /.] (0[1-9]|[12][0-9]|3[01])$")
	private String dateOfBirth;
	
	private String gender;

	@Size(min = 3, max = 15)
	@NotNull
	private String ethnicity;

	@Override
	public String toString() {
		return "Profile [forename=" + forename + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", ethnicity=" + ethnicity + "]";
	}

}
