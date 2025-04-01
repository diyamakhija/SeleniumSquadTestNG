package tests;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime

public @interface DataRow {
	int value(); // This will hold the row number
}
