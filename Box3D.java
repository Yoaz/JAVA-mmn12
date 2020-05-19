/*This class represent a 3D box
	
Author: Yoaz Shmider */

public class Box3D{
	
/*
* @param _base the front low left point of the 3D box
* @param _length the length of the box
* @param _width the width of the box
* @param _height the height of the box
* @final_param DEFAULT_VAL_0 the default value of a point coordinate
* @final_param DEFAULT_VAL_1 the default value of a box value
*/
private Point3D _base;
private int _length;
private int _width;
private int _height;
final int DEFAULT_VAL_0 = 0;
final int DEFAULT_VAL_1 = 1;


/*
* default constractor set the base point coordinates to (0,0,0)
* setting length, width & height of the 3D box to 1
*/
public Box3D(){
	_base = new Point3D(DEFAULT_VAL_0, DEFAULT_VAL_0, DEFAULT_VAL_0);
	_length = _width = _height = DEFAULT_VAL_1;
}


/*
* constractor set the base point coordinates to the given values of a provided 3D point
* setting length, width & height of the 3D box to the provided values if values are positive else setting values to 1
*/
public Box3D(Point3D p, int length, int width, int height){
	_base = new Point3D(p);
	
	if(length <= 0)
		_length = 1;
	else 
		_length = length;
	
	if(width <= 0)
		_width = 1;
	else 
		_width = width;
	
	if(height <= 0)
		_height = 1; 
	else
		_height = height;	
}


/*
* Copy constractor, setting the point coordinates same values as the provided point 
* and box values same as given
* @param other a Point3D object
*/
public Box3D(Box3D other){
	_base = new Point3D(other.getBase());
	_length = other.getLength();
	_height = other.getHeight();
	_width = other.getWidth();
}


/* 
* @return the length value of a a 3D Box 
*/ 
public int getLength(){
	return _length;
}


/* 
* @return the width value of a a 3D Box 
*/
public int getWidth(){
	return _width;
}


/* 
* @return the height value of a a 3D Box 
*/
public int getHeight(){
	return _height;
}


/* 
* @return the base point of a a 3D Box 
*/
public Point3D getBase(){
	Point3D baseCopy = _base;
	return baseCopy;
}


/* 
* setting the length value of a a 3D Box 
*/
public void setLength(int num){
	if(num <= 0)
		return;
	_length = num;
}


/* 
* setting the width value of a a 3D Box 
*/
public void setWidth(int num){
	if(num <= 0)
		return;
	_width = num;
}


/* 
* setting the height value of a a 3D Box 
*/
public void setHeight(int num){
	if(num <=0)
		return;
	_height = num;
}


/* 
* setting the base point of a a 3D Box 
*/
public void setBase(Point3D p){
	_base.setX(p.getX());
	_base.setY(p.getY());
	_base.setZ(p.getZ());
}


public String toString(){
	return "The base point is (" + _base.getX() + "," + _base.getY() + "," + _base.getZ() + "), length = " + _length + ", width = " + _width + ", height = " + _height; 
}


/* 
* Check and returns true if current box equals to provided box
* @param b a Box3D object
* @return true if it does and false otherwise
*/
public boolean equals(Box3D b){
	if(b.getBase() == _base && b.getLength() == _length && b.getWidth() == _width && b.getHeight() == _height)
		return true;
	return false;
}


/* 
* Computes and move the base point of a given box with the given values
* @param dx, dy, dz new base coordinates
* @return new box updated with new base coordinates
*/
public Box3D move(double dx, double dy, double dz){
	Point3D p = new Point3D(dx, dy, dz);
	Box3D b = new Box3D(p, _length, _width, _height);
	return b;
}	


/* 
* Computes and returns the upper right back point of the box 
* @return the upper right back point of the box 
*/
public Point3D getUpRightBackPoint(){
	Point3D upRightBackPoint = new Point3D(_base);
	upRightBackPoint.move((-1)*_length, _width, _height);
	return upRightBackPoint;	
}


/* 
* Computes and returns the center point of the box 
* @return the center of the box 
*/  
public Point3D getCenter(){
	Point3D center = new Point3D(_base);
	center.move((-1)*_length/2.0, _width/2.0, _height/2.0);
	return center;	
}


/* 
* Computes the ditance between 2 boxes basedon their center point
* @return the distance between 2 box3D objects
*/
public double distance (Box3D other){
	return Math.abs(other.getCenter().distance(this.getCenter()));
}


/* 
* Computes and returns the volume of a 3D box
* @return the volume of a box3D object
*/
public int getVolume(){
	return _length * _width * _height;
}


/* 
* Computes and returns the surface area of a 3D box
* @return the surface area of a box3D object
*/
public double getSurfaceArea(){
	return ((_height * _length + _height * _width + _length * _width) * 2);
}


/* 
* This method accept aa box as a paramater and 
* returns true rather a given box has more capacity then current one or false otherwise
* @param other a box3D object
* @return true if it does, false otherwise
*/
public boolean isLargerCapacity(Box3D other){
	return (_length * _height * _width) > (other.getLength() * other.getHeight() * other.getWidth());	
}


/* 
* Checking rather a given box contains the current one
* @param other a box3D object
* @return true if it does, false otherwise
*/
public boolean contains(Box3D other){
	return this.getLength() > other.getLength() && this.getHeight() > other.getHeight() && this.getWidth() > other.getWidth();	
}


/* 
* Checking rather a given box is above the current one
* @param other a box3D object
* @return true if it does, false otherwise
*/
public boolean isAbove(Box3D other){
	return _base.isAbove(other.getUpRightBackPoint());
}
	
	
}