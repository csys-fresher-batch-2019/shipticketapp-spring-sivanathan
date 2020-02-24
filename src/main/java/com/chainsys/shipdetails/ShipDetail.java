package com.chainsys.shipdetails;

public class ShipDetail {

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "ShipDetail [shipId=" + shipId + ", shipName=" + shipName + ", sourcePlace=" + sourcePlace
				+ ", destinationPlace=" + destinationPlace + ", noOfSeats=" + noOfSeats + ", classes=" + classes
				+ ", amount=" + amount + "]";
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int shipId;
	private String shipName;
	private String sourcePlace;
	private String destinationPlace;
	private int noOfSeats;
	private String classes;
	private int amount;
}
