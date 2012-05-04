package task2.model;

import java.util.ArrayList;
import java.util.List;

public class Computers {
	private List<Computer> computers = new ArrayList<Computer>();

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	public void addComputer(Computer computer) {
		this.computers.add(computer);
	}

}
