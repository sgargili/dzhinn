package task2.model;

public class Computer {
	private int id;
	private Hardware hardware;
	private String software;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hardware getHardware() {
		return hardware;
	}

	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}
}
