/****************************************************************************
Copyright (c) 2004, Colorado School of Mines and others. All rights reserved.
This program and accompanying materials are made available under the terms of
the Common Public License - v1.0, which accompanies this distribution, and is 
available at http://www.eclipse.org/legal/cpl-v10.html
****************************************************************************/
package edu.mines.jtk.sgl;

/**
 * A point with three coordinates x, y, and z.
 * @author Dave Hale, Colorado School of Mines
 * @version 2005.05.20
 */
public class Point3 extends Tuple3 {

  /**
   * Constructs a point with coordinates zero.
   */
  public Point3() {
  }

  /**
   * Constructs a point with specified coordinates.
   * @param x the x coordinate.
   * @param y the y coordinate.
   * @param z the z coordinate.
   */
  public Point3(double x, double y, double z) {
    super(x,y,z);
  }

  /**
   * Returns a clone of this point.
   * @return the clone.
   */
  public Point3 clone() {
    return new Point3(x,y,z);
  }

  /**
   * Returns the point q = p+v, for this point p and the specified vector v.
   * @param v the vector v.
   * @return the point q = p+v.
   */
  public Point3 plus(Vector3 v) {
    return new Point3(x+v.x,y+v.y,z+v.z);
  }

  /**
   * Returns the point q = p-v, for this point p and the specified vector v.
   * @param v the vector v.
   * @return the point q = p-v.
   */
  public Point3 minus(Vector3 v) {
    return new Point3(x-v.x,y-v.y,z-v.z);
  }

  /**
   * Moves this point p by adding the specified vector v.
   * @param v the vector v.
   * @return this point, p += v, moved.
   */
  public Point3 plusEquals(Vector3 v) {
    x += v.x;
    y += v.y;
    z += v.z;
    return this;
  }

  /**
   * Moves this point p by subtracting the specified vector v.
   * @param v the vector v.
   * @return this point, p -= v, moved.
   */
  public Point3 minusEquals(Vector3 v) {
    x -= v.x;
    y -= v.y;
    z -= v.z;
    return this;
  }

  /**
   * Returns an affine combination of this point p and the specified point q.
   * @param a the weight of the point q.
   * @param q the point q.
   * @return the affine combination (1-a)*p + a*q.
   */
  public Point3 affine(double a, Point3 q) {
    double b = 1.0-a;
    Point3 p = this;
    return new Point3(b*p.x+a*q.x,b*p.y+a*q.y,b*p.z+a*q.z);
  }

  /**
   * Returns the distance between this point p and the specified point q.
   * @param q the point.
   * @return the distance |q-p|.
   */
  public double distanceTo(Point3 q) {
    double dx = x-q.x;
    double dy = y-q.y;
    double dz = z-q.z;
    return Math.sqrt(dx*dx+dy*dy+dz*dz);
  }
}
