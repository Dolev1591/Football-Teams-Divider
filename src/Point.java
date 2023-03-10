public class Point {
    private double x;
    private double y;

    public Point(double X, double Y){
        this.x=X;
        this.y=Y;
    }

    public void setX(double x1){
        this.x=x1;
    }

    public void setY(double y1){
        this.y=y1;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double distance(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    @Override
    public String toString() {
        return "("+this.x+" , "+this.y+")";
    }
}
