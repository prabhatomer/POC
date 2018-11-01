package com.dao;

import java.util.List;
import com.model.*;

public interface PersonDAO {
	public Boolean save(Person P);

	public List<Person> list();
}
