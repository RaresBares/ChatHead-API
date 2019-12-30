package de.headchat.accessable.api;


public class MyPoint {


    protected static final MyPoint ZERO = new MyPoint(0.0, 0.0, 0.0);


    private double x;


    protected final double getX() {
        return x;
    }


    private double y;


    protected final double getY() {
        return y;
    }


    private double z;

    protected final double getZ() {
        return z;
    }


    private int hash = 0;


    protected MyPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    protected double distance(double x1, double y1, double z1) {
        double a = getX() - x1;
        double b = getY() - y1;
        double c = getZ() - z1;
        return Math.sqrt(a * a + b * b + c * c);
    }


    protected double distance(MyPoint point) {
        return distance(point.getX(), point.getY(), point.getZ());
    }


    protected MyPoint add(double x, double y, double z) {
        return new MyPoint(
                getX() + x,
                getY() + y,
                getZ() + z);
    }


    protected MyPoint add(MyPoint point) {
        return add(point.getX(), point.getY(), point.getZ());
    }

    protected MyPoint subtract(double x, double y, double z) {
        return new MyPoint(
                getX() - x,
                getY() - y,
                getZ() - z);
    }


    protected MyPoint subtract(MyPoint point) {
        return subtract(point.getX(), point.getY(), point.getZ());
    }


    protected MyPoint multiply(double factor) {
        return new MyPoint(getX() * factor, getY() * factor, getZ() * factor);
    }

    protected MyPoint normalize() {
        final double mag = magnitude();

        if (mag == 0.0) {
            return new MyPoint(0.0, 0.0, 0.0);
        }

        return new MyPoint(
                getX() / mag,
                getY() / mag,
                getZ() / mag);
    }


    protected MyPoint midpoint(double x, double y, double z) {
        return new MyPoint(
                x + (getX() - x) / 2.0,
                y + (getY() - y) / 2.0,
                z + (getZ() - z) / 2.0);
    }

    protected MyPoint midpoint(MyPoint point) {
        return midpoint(point.getX(), point.getY(), point.getZ());
    }


    protected double angle(double x, double y, double z) {
        final double ax = getX();
        final double ay = getY();
        final double az = getZ();

        final double delta = (ax * x + ay * y + az * z) / Math.sqrt(
                (ax * ax + ay * ay + az * az) * (x * x + y * y + z * z));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }


    protected double angle(MyPoint point) {
        return angle(point.getX(), point.getY(), point.getZ());
    }


    protected double angle(MyPoint p1, MyPoint p2) {
        final double x = getX();
        final double y = getY();
        final double z = getZ();

        final double ax = p1.getX() - x;
        final double ay = p1.getY() - y;
        final double az = p1.getZ() - z;
        final double bx = p2.getX() - x;
        final double by = p2.getY() - y;
        final double bz = p2.getZ() - z;

        final double delta = (ax * bx + ay * by + az * bz) / Math.sqrt(
                (ax * ax + ay * ay + az * az) * (bx * bx + by * by + bz * bz));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }


    protected double magnitude() {
        final double x = getX();
        final double y = getY();
        final double z = getZ();

        return Math.sqrt(x * x + y * y + z * z);
    }


    protected double dotProduct(double x, double y, double z) {
        return getX() * x + getY() * y + getZ() * z;
    }


    protected double dotProduct(MyPoint vector) {
        return dotProduct(vector.getX(), vector.getY(), vector.getZ());
    }


    protected MyPoint crossProduct(double x, double y, double z) {
        final double ax = getX();
        final double ay = getY();
        final double az = getZ();

        return new MyPoint(
                ay * z - az * y,
                az * x - ax * z,
                ax * y - ay * x);
    }

    protected MyPoint crossProduct(MyPoint vector) {
        return crossProduct(vector.getX(), vector.getY(), vector.getZ());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof MyPoint) {
            MyPoint other = (MyPoint) obj;
            return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ();
        } else return false;
    }


    @Override
    public int hashCode() {
        if (hash == 0) {
            long bits = 7L;
            bits = 31L * bits + Double.doubleToLongBits(getX());
            bits = 31L * bits + Double.doubleToLongBits(getY());
            bits = 31L * bits + Double.doubleToLongBits(getZ());
            hash = (int) (bits ^ (bits >> 32));
        }
        return hash;
    }


    @Override
    public String toString() {
        return "MyPoint [x = " + getX() + ", y = " + getY() + ", z = " + getZ() + "]";
    }
}
