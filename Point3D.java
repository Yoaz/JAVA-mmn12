/*This class represent a 3D point

Author: Yoaz Shmider */

public class Point3D
{

/*
* @param double_x the x coordinate of the point
* @param double_x the y coordinate of the point
* @param double_x the z coordinate of the point
*/
private double double_x;
private double double_y;
private double double_z;


/*
* default constractor set the point to coordinates (0,0,0)
*/
public Point3D(){
	double_x = double_y = double_z = 0;
}

/*
* Constractor set the point to provided coordinates values
* @param x y z a double coordinates
*/
public Point3D(double x, double y, double z){
	double_x = x;
	double_y = y;
	double_z = z;
}

/*
* Copy constractor, setting the point coordinates same values as the provided point
* @param other a Point3D object
*/
public Point3D(Point3D other){
	double_x = other.double_x;
	double_y = other.double_y;
	double_z = other.double_z;
}

/* 
* @return the x value of a a 3D point 
*/ 
public double getX(){
	return double_x;
}

/* 
* @return the y value of a a 3D point 
*/ 
public double getY(){
	return double_y;
}

/* 
* @return the z value of a a 3D point 
*/ 
public double getZ(){
	return double_z;
}

/* 
* setting the x value of a a 3D point 
*/ 
public void setX(double x){
	double_x = x;
}

/* 
* setting the y value of a a 3D point 
*/ 
public void setY(double y){
	double_y = y;
}

/* 
* setting the z value of a a 3D point 
*/ 
public void setZ(double z){
	double_z = z;
}

public String toString(){
	return "(" + double_x + "," + double_y + "," + double_z + ")";
}

/* 
* Checking if a given point is equals to the current point 
*/ 
public boolean uquals(Point3D other){
	return (double_x == other.getX() && double_y == other.getY() && double_z == other.getZ());
}

/* 
* Checking if a given point is above the current point 
* @param other a Point3D object
*/ 
public boolean isAbove(Point3D other){
	if(double_z > other.getZ())
		return true;
	return false;
}

/* 
* Checking if a given point is under the current point 
* @param other a Point3D object
*/ 
public boolean isUnder(Point3D other){
	if(this.isAbove(other))
		return false;
	return true;
}
	
/* 
* Checking if a given point is left to the current point 
* @param other a Point3D object
*/ 
public boolean isLeft(Point3D other){
	if(double_y < other.getY())
		return true;
	return false;
}

/* 
* Checking if a given point is right to the urrent point 
* @param other a Point3D object
*/ 
public boolean isRight(Point3D other){
	if(this.isLeft(other))
		return false;
	return true;
}

/* 
* Checking if a given point is behind the current point 
* @param other a Point3D object
*/ 
public boolean isBehind(Point3D other){
	if(double_x < other.getX())
		return true;
	return false;
}

/* 
* Checking if a given point is in front of the current point 
* @param other a Point3D object
*/ 
public boolean isInFrontOf(Point3D other){
	if(this.isBehind(other))
		return false;
	return true;
}

/* 
* Moving the point coordinates to a new point based on the added values provided
@param dx dy dz a double new coordinates
*/ 
public void move(double dx, double dy, double dz){
	double_x += dx;
	double_y += dy;
	double_z += dz;
}

/* 
* Calculating the distance between two 3D points
* @param other a Point3D object
* @return the distance between two Point3D points
*/ 
public double distance(Point3D other){
	return Math.sqrt(Math.pow(double_x - other.getX(), 2) + (Math.pow(double_y - other.getY(), 2) + Math.pow(double_z - other.getZ(), 2)));
}
	
}