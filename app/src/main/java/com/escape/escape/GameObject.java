package com.escape.escape;

public abstract class GameObject
{
    private int xPos;
    private int yPos;
    private String objectModel;

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

    public void setObjectModel(String o)
    {
        objectModel = o;
    }

    public String getObjectModel()
    {
        return objectModel;
    }

    private void setXPos(int x)
    {
        xPos = x;
    }

    private void setYPos(int y)
    {
        yPos = y;
    }

    private int getXPos()
    {
        return xPos;
    }

    private int getYPos() {
        return yPos;
    }
}
