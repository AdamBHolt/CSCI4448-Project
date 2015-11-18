package com.escape.escape;

/**
 * Abstract class to define basic methods and data members for concrete classes
 */
public abstract class GameObject
{
    private int xPos;
    private int yPos;
    private String objectModel;

    public GameObject(){}

    public GameObject(int x, int y)
    {
        setPosition(x, y);
    }

    /**
     * Set x and y coordinates for the GameObject
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setPosition(int x, int y)
    {
        setXPos(x);
        setYPos(y);
    }

    /**
     * Returns the x, y position of the GameObject
     * @return x,y coordinates of the GameObject as an array [x, y]
     */
    public int[] getPosition()
    {
        int[] pos = new int[2];

        pos[0] = getXPos();
        pos[1] = getYPos();

        return pos;
    }

    /**
     * String value of the specific image to be used for the concret GameObject
     * @param o String location of the concrete GameObject's image
     */
    public void setObjectModel(String o)
    {
        objectModel = o;
    }

    /**
     * Get the String value of the concrete object image
     * @return String representation of the GameObject
     */
    public String getObjectModel()
    {
        return objectModel;
    }

    /**
     * Helper method to set the x coordinate
     * @param x x coordinate
     */
    protected void setXPos(int x)
    {
        xPos = x;
    }

    /**
     * Helper method to set the y coordinate
     * @param y y coordinate
     */
    protected void setYPos(int y)
    {
        yPos = y;
    }

    /**
     * Helper method to get the x coordinate
     * @return x coordinate
     */
    protected int getXPos()
    {
        return xPos;
    }

    /**
     * Helper method to get the y coordinate
     * @return y coordinate
     */
    protected int getYPos() {
        return yPos;
    }
}
