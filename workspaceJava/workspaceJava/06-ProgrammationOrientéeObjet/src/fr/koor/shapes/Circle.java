package fr.koor.shapes;

import java.awt.Point;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle() {
		super();
		this.setRadius( 1 );
	}
	
	public Circle( Point center, double radius) {
		super( center );
		this.setRadius( radius );
	}
	
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = Math.abs( radius );
	}

	@Override
	public double area() {
		//return Math.PI * this.radius * this.radius;			 // πr²
		return Math.PI * Math.pow( this.radius, 2 );
	}
	
	@Override
	public void draw() {
		System.out.println( "Un cercle positionné en " + this.getCenter() + " et de rayon " + this.radius );
	}
	
}
