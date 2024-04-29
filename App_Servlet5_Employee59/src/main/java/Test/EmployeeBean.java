package Test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable
{
	
	private String id, name,dsg;
	private float bsal,hra,da,ta;
	
	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	public float getDa() {
		return da;
	}

	public void setDa(float da) {
		this.da = da;
	}

	public float getTa() {
		return ta;
	}

	public void setTa(float ta) {
		this.ta = ta;
	}

	public EmployeeBean() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDsg() {
		return dsg;
	}

	public void setDsg(String dsg) {
		this.dsg = dsg;
	}

	public float getBsal() {
		return bsal;
	}

	public void setBsal(float bsal) {
		this.bsal = bsal;
	}
	
}
